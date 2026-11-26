dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            // https://assertj.github.io/doc/#assertj-core-release-notes
            version("assertj", "3.27.7")
            // https://developer.android.com/studio/releases/gradle-plugin
            // Please update Lint version whenever you update Android Gradle plugin
            version("androidGradlePlugin", "9.5.3")

            // https://github.com/mannodermaus/android-junit5/releases
            version("androidJunit5", "2.0.2")

            // https://junit.org/junit5/docs/snapshot/release-notes/
            version("junit5", "5.14.4")

            // https://kotlinlang.org/docs/releases.html#release-details
            version("kotlin", "2.4.21")

            // https://github.com/mockito/mockito/releases
            version("mockito", "5.24.0")
            // https://github.com/mockito/mockito-kotlin/releases
            version("mockitoKotlin", "6.4.0")

            // https://github.com/square/okhttp/blob/master/CHANGELOG.md
            version("okhttp", "5.5.1")

            version("ohttp-encapsulator-android", "0.3.0")
            version("bhttp", "0.1.0")

            library("androidGradlePlugin", "com.android.tools.build", "gradle").versionRef("androidGradlePlugin")
            library("androidJunit5", "de.mannodermaus.gradle.plugins", "android-junit5").versionRef("androidJunit5")

            library("kotlin_gradlePlugin", "org.jetbrains.kotlin", "kotlin-gradle-plugin").versionRef("kotlin")

            library("network_okhttp", "com.squareup.okhttp3", "okhttp").versionRef("okhttp")
            library("network_okhttp_mockWebServer", "com.squareup.okhttp3", "mockwebserver").versionRef("okhttp")

            library("network_ohttpEncapsulator", "com.github.flohealth", "ohttp-encapsulator")
                .versionRef("ohttp-encapsulator-android")
            library("network_bhttp", "com.github.flohealth", "ok-bhttp")
                .versionRef("bhttp")

            // The BOM sets the versions of the other JUnit artifacts, including the platform launcher.
            library("testing_junit5_bom", "org.junit", "junit-bom").versionRef("junit5")
            library("testing_junit5", "org.junit.jupiter", "junit-jupiter-api").withoutVersion()
            library("testing_junit5_engine", "org.junit.jupiter", "junit-jupiter-engine").withoutVersion()
            library("testing_junit5_launcher", "org.junit.platform", "junit-platform-launcher").withoutVersion()
            library("testing_junit5_params", "org.junit.jupiter", "junit-jupiter-params").withoutVersion()
            bundle("testing_junit5", listOf("testing_junit5", "testing_junit5_params"))

            library("testing_mockito_core", "org.mockito", "mockito-core").versionRef("mockito")
            library("testing_mockito_kotlin", "org.mockito.kotlin", "mockito-kotlin").versionRef("mockitoKotlin")
            bundle(
                "testing_mockito",
                listOf(
                    "testing_mockito_core",
                    "testing_mockito_kotlin",
                ),
            )

            library("testing_assertj", "org.assertj", "assertj-core").versionRef("assertj")
        }
    }
}

include(
    ":lib-ohttp-plugin",
)
