plugins {
    id("shared.android.config")
    id("kmp.compose.config")
}

android {
    namespace = "ge.avalanche.zvavi.feature.splash.presentation"
}
kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core:foundation"))
                implementation(project(":common:core:designsystem"))
            }
        }
    }
}
