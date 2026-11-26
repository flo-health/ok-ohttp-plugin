import health.flo.network.gradle.Environment
import health.flo.network.gradle.configureCompiler
import health.flo.network.gradle.configureSdk

plugins {
    id("com.android.library")
}

android {
    configureSdk()
    configureCompiler(project.tasks)

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments += mapOf(
            "clearPackageData" to "true",
        )
    }

    buildFeatures {
        shaders = false
    }
}

kotlin {
    compilerOptions {
        allWarningsAsErrors = Environment.isCI
    }
}
