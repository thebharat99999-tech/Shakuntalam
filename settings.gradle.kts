pluginManagement {
  repositories {
    google {
      content {
        includeGroupByRegex("com\\.android.*")
        includeGroupByRegex("com\\.google.*")
        includeGroupByRegex("androidx.*")
      }
    }
    mavenCentral()
    gradlePluginPortal()
  }
}

plugins { id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0" }

dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}

rootProject.name = "Shakuntalam"

// Suppress benign KSP shaded-IntelliJ AWT-EventQueue-0 post-disposal race condition in headless Gradle daemon
val previousUncaughtHandler = Thread.getDefaultUncaughtExceptionHandler()
Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
  val isKspAwtPostDisposal =
    thread.name.startsWith("AWT-EventQueue") &&
      (throwable.message?.contains("ksp.com.intellij.openapi.application.Application") == true ||
        throwable.stackTrace.any { it.className.startsWith("ksp.com.intellij.") })
  if (!isKspAwtPostDisposal) {
    if (previousUncaughtHandler != null) {
      previousUncaughtHandler.uncaughtException(thread, throwable)
    } else {
      System.err.print("Exception in thread \"${thread.name}\" ")
      throwable.printStackTrace(System.err)
    }
  }
}

include(":app")

