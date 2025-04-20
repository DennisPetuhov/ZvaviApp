plugins{
    id("shared.android.config")
    id("kmp.base.config")
    id("kmp.network.config")
    alias(libs.plugins.kotlinx.serialization)
}
kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":common:core:network"))
            implementation(project(":common:core:foundation"))
            implementation(libs.kotlinx.serialization.json)
        }
    }
}
android {
    namespace = "ge.avalanche.zvavi.feature.bulletin.api"
}