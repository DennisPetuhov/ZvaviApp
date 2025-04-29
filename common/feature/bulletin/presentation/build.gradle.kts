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
                implementation("org.jetbrains.skiko:skiko:0.8.18")

                implementation(project(":common:core:foundation"))
                implementation(project(":common:core:designsystem"))
                implementation(project(":common:core:network"))
                implementation(project(":common:feature:bulletin:api"))
                implementation(project(":common:feature:bulletin:data"))
            }
        }
    }
}
