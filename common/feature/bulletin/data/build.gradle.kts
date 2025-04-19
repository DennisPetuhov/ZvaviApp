plugins {
    id("shared.android.config")
    id("kmp.base.config")
    id("kmp.network.config")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":common:feature:bulletin:api"))
            implementation(project(":common:core:foundation"))
            implementation(project(":common:core:network"))
        }
    }
}

android {
    namespace = "ge.avalanche.zvavi.feature.bulletin.data"
}