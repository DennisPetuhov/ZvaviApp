plugins {
    id("shared.android.config")
    id("kmp.base.config")
    id("kmp.network.config")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":common:feature:bulletin:api"))
        }
    }
}

android {
    namespace = "ge.avalanche.zvavi.feature.bulletin.data"
}