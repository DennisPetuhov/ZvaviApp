plugins {
    id("shared.android.config")
    id("kmp.database.configue")
//    alias(libs.plugins.kotlinx.serialization)
}
android { namespace = "ge.avalanche.zvavi.common.core.database" }
kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core:foundation"))
            }
        }
    }
}
