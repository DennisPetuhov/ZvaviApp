plugins {
    id("shared.android.config")
    id("kmp.network.config")
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