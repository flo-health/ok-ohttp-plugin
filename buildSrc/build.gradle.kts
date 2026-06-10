plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    // android gradle plugin, required by custom plugin
    implementation("com.android.tools.build:gradle:9.1.1")
    // kotlin plugin, required by custom plugin
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.3.0")
}
