import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

val testImplementation by configurations
val testRuntimeOnly by configurations
val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

dependencies {
    testRuntimeOnly(libs.findLibrary("testing.junit5.engine").get())

    testImplementation(libs.findBundle("testing.junit5").get())
    testImplementation(libs.findBundle("testing.mockito").get())
    testImplementation(libs.findLibrary("testing.assertj").get())
}
