plugins {
    id("org.jetbrains.kotlin.multiplatform")
}
kotlin {
    androidTarget()
    jvm()
    listOf(
        iosX64(), iosArm64(), iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
}