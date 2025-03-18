import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.android.application)
    id("kmp.base.config")
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.buildConfig)
    id("kmp.compose.config")

}
kotlin {
    jvmToolchain(17)// this is for compiler
    sourceSets { }
}

android {
    namespace = "ge.avalanche.zvavi"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}


compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "ZvaviApp"
            packageVersion = "1.0.0"

            linux {
                iconFile.set(project.file("desktopAppIcons/LinuxIcon.png"))
            }
            windows {
                iconFile.set(project.file("desktopAppIcons/WindowsIcon.ico"))
            }
            macOS {
                iconFile.set(project.file("desktopAppIcons/MacosIcon.icns"))
                bundleID = "ge.avalanche.zvavi.desktopApp"
            }
        }
    }
}