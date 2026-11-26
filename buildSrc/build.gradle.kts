plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    // android gradle plugin, required by custom plugin
    implementation("com.android.tools.build:gradle:9.5.3")
    // kotlin plugin, required by custom plugin
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.4.21")
}
