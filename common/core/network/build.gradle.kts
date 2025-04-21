plugins {
    id("shared.android.config")
    id("kmp.network.config")
    alias(libs.plugins.kotlinx.serialization)
}
kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core:foundation"))
            }
        }
    }
}
android {
    namespace = "ge.avalanche.zvavi.common.core.network"
}