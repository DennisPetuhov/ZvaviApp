plugins {
    id("shared.android.config")
    id("kmp.compose.config")
}

android {
    namespace = "ge.avalanche.zvavi.feature.bulletin.presentation"
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
dependencies {
    implementation(libs.androidx.compose.testing)
}
