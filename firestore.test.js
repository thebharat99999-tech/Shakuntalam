const {
  initializeTestEnvironment,
  assertFails,
  assertSucceeds,
} = require("@firebase/rules-unit-testing");
const { test, before, after, beforeEach } = require("node:test");
const fs = require("node:fs");

let testEnv;
const PROJECT_ID = process.env.GCP_PROJECT || "demo-no-project";
const ALICE_UID = "alice_123";
const BOB_UID = "bob_456";

const [emulatorHost, emulatorPortStr] = (
  process.env.FIRESTORE_EMULATOR_HOST || "127.0.0.1:8085"
).split(":");
const emulatorPort = parseInt(emulatorPortStr, 10);

before(async () => {
  const rules = fs.readFileSync("./firestore.rules", "utf8");
  testEnv = await initializeTestEnvironment({
    projectId: PROJECT_ID,
    firestore: {
      rules,
      host: emulatorHost,
      port: emulatorPort,
    },
  });
});

after(async () => {
  if (testEnv) {
    await testEnv.cleanup();
  }
});

beforeEach(async () => {
  if (testEnv) {
    await testEnv.clearFirestore();
  }
});

function validStudentPayload(uid) {
  const now = new Date(Date.now() - 500);
  return {
    userId: uid,
    studentName: "Aarav Sharma",
    targetExam: "IIT JEE (Main & Advanced)",
    authMethod: "GOOGLE",
    totalPoints: 250,
    testsAttempted: 3,
    averageAccuracy: 82,
    streakDays: 5,
    accountSetupCompleted: true,
    createdAt: now,
    updatedAt: now,
  };
}

function validAttemptPayload(uid) {
  const now = new Date(Date.now() - 500);
  return {
    userId: uid,
    testId: "jee_main_phy_1",
    testTitle: "IIT JEE Main Physics Mock 1",
    examCategory: "IIT JEE",
    score: 85,
    totalQuestions: 100,
    accuracyPercent: 85,
    createdAt: now,
    updatedAt: now,
  };
}

function validQuizTestPayload(uid, testId = "upsc_flt_mock_1") {
  const now = new Date(Date.now() - 500);
  return {
    userId: uid,
    testId: testId,
    examKey: "upsc",
    titleEn: "UPSC CSE Full-Length Mock Test 1",
    titleHi: "यूपीएससी फुल लेंथ मॉक टेस्ट 1",
    durationMinutes: 120,
    totalMarks: 200,
    questionCount: 100,
    paidOnly: true,
    createdAt: now,
    updatedAt: now,
  };
}

function validSubscriptionPayload(uid, planCode = "MONTHLY_9", priceInr = 9) {
  const now = new Date(Date.now() - 500);
  const startMs = Date.now() - 1000;
  const expiryMs = startMs + 30 * 24 * 60 * 60 * 1000;
  return {
    userId: uid,
    planCode: planCode,
    planName: "Shakuntalam Monthly All-Access Pass (₹9/Month)",
    priceInr: priceInr,
    status: "ACTIVE",
    active: true,
    startEpochMillis: startMs,
    expiryEpochMillis: expiryMs,
    receiptNumber: "SUB-RCPT-9001",
    createdAt: now,
    updatedAt: now,
  };
}

// --- SECURITY BOUNDS TESTS (Dirty Dozen) ---

test("Unauthenticated user: cannot read or create student profiles", async () => {
  const unauthContext = testEnv.unauthenticatedContext();
  const unauthDb = unauthContext.firestore();
  await assertFails(unauthDb.collection("students").doc(ALICE_UID).get());
  await assertFails(
    unauthDb
      .collection("students")
      .doc(ALICE_UID)
      .set(validStudentPayload(ALICE_UID))
  );
});

test("Authenticated user: can create and read their own student profile", async () => {
  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();

  await assertSucceeds(
    aliceDb
      .collection("students")
      .doc(ALICE_UID)
      .set(validStudentPayload(ALICE_UID))
  );

  await assertSucceeds(aliceDb.collection("students").doc(ALICE_UID).get());
});

test("Authenticated user: cannot read or overwrite another user's student profile", async () => {
  const bobDb = testEnv.authenticatedContext(BOB_UID).firestore();
  await assertSucceeds(
    bobDb
      .collection("students")
      .doc(BOB_UID)
      .set(validStudentPayload(BOB_UID))
  );

  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();
  await assertFails(aliceDb.collection("students").doc(BOB_UID).get());
  await assertFails(
    aliceDb
      .collection("students")
      .doc(BOB_UID)
      .set(validStudentPayload(ALICE_UID))
  );
});

test("Shadow Update Test: rejects student profile write with unexpected ghost field", async () => {
  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();

  const poisonedPayload = {
    ...validStudentPayload(ALICE_UID),
    isAdmin: true,
  };
  await assertFails(
    aliceDb.collection("students").doc(ALICE_UID).set(poisonedPayload)
  );
});

test("Value Poisoning Test: rejects out-of-range accuracy or empty studentName on update", async () => {
  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();

  await assertSucceeds(
    aliceDb
      .collection("students")
      .doc(ALICE_UID)
      .set(validStudentPayload(ALICE_UID))
  );

  await assertFails(
    aliceDb.collection("students").doc(ALICE_UID).update({
      averageAccuracy: 150,
      updatedAt: new Date(Date.now() - 100),
    })
  );

  await assertFails(
    aliceDb.collection("students").doc(ALICE_UID).update({
      studentName: "",
      updatedAt: new Date(Date.now() - 100),
    })
  );
});

test("Authenticated user: can create and query their own test_attempts subcollection", async () => {
  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();

  await assertSucceeds(
    aliceDb
      .collection("students")
      .doc(ALICE_UID)
      .collection("test_attempts")
      .doc("attempt_1")
      .set(validAttemptPayload(ALICE_UID))
  );

  await assertSucceeds(
    aliceDb
      .collection("students")
      .doc(ALICE_UID)
      .collection("test_attempts")
      .get()
  );
});

test("Authenticated user: cannot read or write another user's test_attempts subcollection", async () => {
  const bobDb = testEnv.authenticatedContext(BOB_UID).firestore();

  await assertSucceeds(
    bobDb
      .collection("students")
      .doc(BOB_UID)
      .collection("test_attempts")
      .doc("attempt_bob_1")
      .set(validAttemptPayload(BOB_UID))
  );

  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();
  await assertFails(
    aliceDb
      .collection("students")
      .doc(BOB_UID)
      .collection("test_attempts")
      .get()
  );
});

// --- QUIZ TEST DATA SUBCOLLECTION TESTS (/students/{userId}/quiz_tests/{testId}) ---

test("Authenticated user: can create, read, update, and list their own quiz_tests subcollection", async () => {
  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();

  await assertSucceeds(
    aliceDb
      .collection("students")
      .doc(ALICE_UID)
      .collection("quiz_tests")
      .doc("upsc_flt_mock_1")
      .set(validQuizTestPayload(ALICE_UID, "upsc_flt_mock_1"))
  );

  await assertSucceeds(
    aliceDb
      .collection("students")
      .doc(ALICE_UID)
      .collection("quiz_tests")
      .doc("upsc_flt_mock_1")
      .get()
  );

  await assertSucceeds(
    aliceDb
      .collection("students")
      .doc(ALICE_UID)
      .collection("quiz_tests")
      .get()
  );

  await assertSucceeds(
    aliceDb
      .collection("students")
      .doc(ALICE_UID)
      .collection("quiz_tests")
      .doc("upsc_flt_mock_1")
      .update({
        questionCount: 100,
        paidOnly: true,
        updatedAt: new Date(Date.now() - 100),
      })
  );
});

test("Authenticated user: cannot read or modify another user's quiz_tests subcollection", async () => {
  const bobDb = testEnv.authenticatedContext(BOB_UID).firestore();
  await assertSucceeds(
    bobDb
      .collection("students")
      .doc(BOB_UID)
      .collection("quiz_tests")
      .doc("up_police_flt_mock_1")
      .set(validQuizTestPayload(BOB_UID, "up_police_flt_mock_1"))
  );

  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();
  await assertFails(
    aliceDb
      .collection("students")
      .doc(BOB_UID)
      .collection("quiz_tests")
      .doc("up_police_flt_mock_1")
      .get()
  );
});

// --- SUBSCRIPTION MANAGEMENT SECURITY RULES TESTS (/subscriptions/{userId}) ---

test("Unauthenticated user: cannot read or write subscriptions", async () => {
  const unauthDb = testEnv.unauthenticatedContext().firestore();
  await assertFails(unauthDb.collection("subscriptions").doc(ALICE_UID).get());
  await assertFails(
    unauthDb
      .collection("subscriptions")
      .doc(ALICE_UID)
      .set(validSubscriptionPayload(ALICE_UID, "MONTHLY_9", 9))
  );
});

test("Authenticated user: can create Monthly (₹9), upgrade to Yearly (₹99) & Lifetime (₹399), and expire their own subscription", async () => {
  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();

  await assertSucceeds(
    aliceDb
      .collection("subscriptions")
      .doc(ALICE_UID)
      .set(validSubscriptionPayload(ALICE_UID, "MONTHLY_9", 9))
  );

  await assertSucceeds(aliceDb.collection("subscriptions").doc(ALICE_UID).get());

  await assertSucceeds(
    aliceDb.collection("subscriptions").doc(ALICE_UID).update({
      planCode: "YEARLY_99",
      planName: "Shakuntalam Yearly All-Access Pass (₹99/Year)",
      priceInr: 99,
      status: "ACTIVE",
      active: true,
      expiryEpochMillis: Date.now() + 365 * 24 * 60 * 60 * 1000,
      receiptNumber: "SUB-RCPT-9902",
      updatedAt: new Date(Date.now() - 200),
    })
  );

  await assertSucceeds(
    aliceDb.collection("subscriptions").doc(ALICE_UID).update({
      planCode: "LIFETIME_399",
      planName: "Shakuntalam Lifetime All-Access Pass (₹399)",
      priceInr: 399,
      status: "ACTIVE",
      active: true,
      expiryEpochMillis: Date.now() + 3650 * 24 * 60 * 60 * 1000,
      receiptNumber: "SUB-RCPT-39903",
      updatedAt: new Date(Date.now() - 100),
    })
  );

  await assertSucceeds(
    aliceDb.collection("subscriptions").doc(ALICE_UID).update({
      planCode: "NONE",
      planName: "Free Plan",
      priceInr: 0,
      status: "EXPIRED",
      active: false,
      startEpochMillis: 0,
      expiryEpochMillis: 0,
      updatedAt: new Date(Date.now() - 50),
    })
  );
});

test("Authenticated user: cannot read or tamper with another user's subscription", async () => {
  const bobDb = testEnv.authenticatedContext(BOB_UID).firestore();
  await assertSucceeds(
    bobDb
      .collection("subscriptions")
      .doc(BOB_UID)
      .set(validSubscriptionPayload(BOB_UID, "YEARLY_99", 99))
  );

  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();
  await assertFails(aliceDb.collection("subscriptions").doc(BOB_UID).get());
  await assertFails(
    aliceDb.collection("subscriptions").doc(BOB_UID).update({
      planCode: "NONE",
      active: false,
      status: "EXPIRED",
      updatedAt: new Date(Date.now() - 100),
    })
  );
});

test("Subscription Validation: rejects invalid planCode, invalid priceInr, or @DocumentId id field", async () => {
  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();

  await assertFails(
    aliceDb
      .collection("students")
      .doc(ALICE_UID)
      .collection("quiz_tests")
      .doc("bad_quiz")
      .set({
        ...validQuizTestPayload(ALICE_UID, "bad_quiz"),
        id: "bad_quiz",
      })
  );

  await assertFails(
    aliceDb
      .collection("subscriptions")
      .doc(ALICE_UID)
      .set({
        ...validSubscriptionPayload(ALICE_UID, "MONTHLY_9", 9),
        planCode: "HACKED_FREE_PLAN",
      })
  );

  await assertFails(
    aliceDb
      .collection("subscriptions")
      .doc(ALICE_UID)
      .set({
        ...validSubscriptionPayload(ALICE_UID, "MONTHLY_9", 9),
        priceInr: 1,
      })
  );

  await assertFails(
    aliceDb
      .collection("subscriptions")
      .doc(ALICE_UID)
      .set({
        ...validSubscriptionPayload(ALICE_UID, "MONTHLY_9", 9),
        id: ALICE_UID,
      })
  );
});

test("Subscription Query Alignment: filtered userId query succeeds; unfiltered query fails", async () => {
  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();
  await assertSucceeds(
    aliceDb
      .collection("subscriptions")
      .doc(ALICE_UID)
      .set(validSubscriptionPayload(ALICE_UID, "LIFETIME_399", 399))
  );

  await assertSucceeds(
    aliceDb.collection("subscriptions").where("userId", "==", ALICE_UID).get()
  );
  await assertFails(aliceDb.collection("subscriptions").get());
});
