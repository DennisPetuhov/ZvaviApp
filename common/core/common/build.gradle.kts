plugins {
    id("shared.android.config")
    id("kmp.base.config")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
        }
    }
}

android {
    namespace = "ge.avalanche.zvavi.core.common"
} 