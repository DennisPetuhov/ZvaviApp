import extensions.libs

plugins {
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.compose")
    id("kmp.base.config")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.components.resources)
            implementation(libs.ui.util)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.androidx.navigation.compose)
            implementation(libs.coil)
            implementation(libs.coil.network.ktor)
            implementation(libs.androidx.ui.text.google.fonts)
            implementation(libs.androidx.navigation.compose)


        }

        androidMain.dependencies {
            implementation(compose.uiTooling)
            implementation(libs.androidx.runtime.android)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.ui.util)
            implementation(libs.androidx.navigation.compose)
        }
        iosMain.dependencies {
            implementation(libs.androidx.navigation.compose)
        }
    }
}