plugins {
    id("shared.android.config")
    id("kmp.compose.config")
}

android {
    namespace = "ge.avalanche.zvavi.feature.explore.presentation"
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
