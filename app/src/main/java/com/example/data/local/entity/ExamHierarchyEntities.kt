package com.example.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation

/**
 * Level 1 of Hierarchy: Exam Entity (e.g. UPSC CSE, SSC CGL, UPPCS, Railway NTPC)
 */
@Entity(
    tableName = "exams",
    indices = [
        Index(value = ["category_group"]),
        Index(value = ["order_index"])
    ]
)
data class ExamEntity(
    @PrimaryKey
    val id: String, // e.g. "upsc_cse", "ssc_cgl", "uppcs"

    val name: String, // e.g. "UPSC Civil Services Examination"

    @ColumnInfo(name = "hindi_name")
    val hindiName: String, // e.g. "यूपीएससी सिविल सेवा परीक्षा"

    @ColumnInfo(name = "category_group")
    val categoryGroup: String, // e.g. "Civil Services", "Staff Selection", "State PSC", "Railway"

    @ColumnInfo(name = "badge", defaultValue = "")
    val badge: String = "", // e.g. "Flagship", "Hot", "Trending"

    @ColumnInfo(name = "icon_key", defaultValue = "AccountBalance")
    val iconKey: String = "AccountBalance",

    @ColumnInfo(name = "total_vacancies", defaultValue = "0")
    val totalVacancies: Int = 0,

    @ColumnInfo(name = "order_index", defaultValue = "0")
    val orderIndex: Int = 0
)

/**
 * Level 2 of Hierarchy: Subject Entity (e.g. Prelims GS - Indian Polity, History, CSAT)
 * Connected to ExamEntity via ForeignKey with CASCADE delete.
 */
@Entity(
    tableName = "subjects",
    foreignKeys = [
        ForeignKey(
            entity = ExamEntity::class,
            parentColumns = ["id"],
            childColumns = ["exam_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["exam_id"]),
        Index(value = ["stage_or_tier"]),
        Index(value = ["order_index"])
    ]
)
data class SubjectEntity(
    @PrimaryKey
    val id: String, // e.g. "upsc_pre_polity", "upsc_pre_history", "ssc_cgl_quant"

    @ColumnInfo(name = "exam_id")
    val examId: String, // references ExamEntity.id

    val name: String, // e.g. "Indian Polity & Constitutional Governance"

    @ColumnInfo(name = "hindi_name")
    val hindiName: String, // e.g. "भारतीय राजव्यवस्था एवं संविधान"

    @ColumnInfo(name = "stage_or_tier")
    val stageOrTier: String, // e.g. "Prelims", "Mains", "Tier 1", "Tier 2", "Paper 1"

    @ColumnInfo(name = "description", defaultValue = "")
    val description: String = "",

    @ColumnInfo(name = "weightage_marks", defaultValue = "0")
    val weightageMarks: Int = 0,

    @ColumnInfo(name = "order_index", defaultValue = "0")
    val orderIndex: Int = 0
)

/**
 * Level 3 of Hierarchy: Sub-topic Entity (e.g. "Preamble & Fundamental Rights", "Revolt of 1857")
 * Connected to SubjectEntity via ForeignKey with CASCADE delete.
 */
@Entity(
    tableName = "sub_topics",
    foreignKeys = [
        ForeignKey(
            entity = SubjectEntity::class,
            parentColumns = ["id"],
            childColumns = ["subject_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["subject_id"]),
        Index(value = ["importance_level"]),
        Index(value = ["order_index"])
    ]
)
data class SubTopicEntity(
    @PrimaryKey
    val id: String, // e.g. "polity_fundamental_rights", "history_revolt_1857"

    @ColumnInfo(name = "subject_id")
    val subjectId: String, // references SubjectEntity.id

    val name: String, // e.g. "Fundamental Rights (Articles 12-35) & Writs"

    @ColumnInfo(name = "hindi_name")
    val hindiName: String, // e.g. "मूल अधिकार (अनुच्छेद 12-35) एवं रिट क्षेत्राधिकार"

    @ColumnInfo(name = "importance_level", defaultValue = "High Yield")
    val importanceLevel: String = "High Yield", // "High Yield", "Must Read", "Core Foundation", "Revision Only"

    @ColumnInfo(name = "estimated_hours", defaultValue = "4.0")
    val estimatedHours: Double = 4.0,

    @ColumnInfo(name = "pyq_count", defaultValue = "25")
    val pyqCount: Int = 25, // Previous year questions count

    @ColumnInfo(name = "summary", defaultValue = "")
    val summary: String = "",

    @ColumnInfo(name = "order_index", defaultValue = "0")
    val orderIndex: Int = 0
)

// ==========================================
// Relational POJOs for Room 1:N and Nested Hierarchies
// ==========================================

/**
 * Subject with its list of Sub-topics (1 to Many)
 */
data class SubjectWithSubTopics(
    @Embedded
    val subject: SubjectEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "subject_id"
    )
    val subTopics: List<SubTopicEntity>
)

/**
 * Exam with its list of Subjects (1 to Many)
 */
data class ExamWithSubjects(
    @Embedded
    val exam: ExamEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "exam_id"
    )
    val subjects: List<SubjectEntity>
)

/**
 * Complete Full 3-Tier Nested Hierarchy:
 * Exam -> Subjects -> SubTopics
 */
data class ExamWithSubjectsAndSubTopics(
    @Embedded
    val exam: ExamEntity,

    @Relation(
        entity = SubjectEntity::class,
        parentColumn = "id",
        entityColumn = "exam_id"
    )
    val subjectsWithSubTopics: List<SubjectWithSubTopics>
)
