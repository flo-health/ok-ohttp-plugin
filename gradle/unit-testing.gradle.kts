import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.gradle.process.CommandLineArgumentProvider

val testImplementation = configurations.getByName("testImplementation")
val testRuntimeOnly = configurations.getByName("testRuntimeOnly")
val mockitoAgent = configurations.create("mockitoAgent") {
    isTransitive = false
}
val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

dependencies {
    testImplementation(platform(libs.findLibrary("testing.junit5.bom").get()))
    testRuntimeOnly(platform(libs.findLibrary("testing.junit5.bom").get()))
    testRuntimeOnly(libs.findLibrary("testing.junit5.engine").get())
    testRuntimeOnly(libs.findLibrary("testing.junit5.launcher").get())

    testImplementation(libs.findBundle("testing.junit5").get())
    testImplementation(libs.findBundle("testing.mockito").get())
    testImplementation(libs.findLibrary("testing.assertj").get())

    mockitoAgent(libs.findLibrary("testing.mockito.core").get())
}

// Mockito warns when it attaches its agent at runtime, and future JDKs will block that.
// Its inline mock maker extends the boot classpath, which makes the JVM warn about class data sharing.
tasks.withType<Test>().configureEach {
    val agent = mockitoAgent
    jvmArgumentProviders.add(CommandLineArgumentProvider { listOf("-javaagent:${agent.singleFile}", "-Xshare:off") })
}
