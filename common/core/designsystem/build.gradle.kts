plugins {
    id("shared.android.config")
    id("kmp.compose.config")
}
android {
    namespace = "ge.avalanche.zvavi.feature.designsystem"
}
kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.ui.util)
            }
        }
    }
}