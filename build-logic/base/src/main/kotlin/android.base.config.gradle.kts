import extensions.androidConfig
import extensions.android
import extensions.kotlinJvmCompilerOptions
import extensions.libs
import extensions.projectJavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

android {
    compileSdk = libs.versions.compileSdk.get().toInt()


    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()

        applicationId = "ge.avalanche.zvavi.androidApp"
        versionCode = 1
        versionName = "1.0.0"

    }
    compileOptions {// is used to specify the Java version compatibility for compiling the source code and the target bytecode version.
        sourceCompatibility = JavaVersion.toVersion(libs.versions.java.get())
        targetCompatibility = JavaVersion.toVersion(libs.versions.java.get())
    }
}