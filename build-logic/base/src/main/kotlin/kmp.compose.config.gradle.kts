import extensions.libs
import org.jetbrains.compose.ExperimentalComposeLibrary

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
//            implementation(compose.components.uiToolingPreview)
//            implementation(libs.ui.util)

//            implementation(libs.kermit)
//            implementation(libs.kotlinx.coroutines.core)
//            implementation(libs.ktor.client.core)
//            implementation(libs.ktor.client.content.negotiation)
//            implementation(libs.ktor.client.serialization)
//            implementation(libs.ktor.client.logging)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.androidx.navigation.composee)
//            implementation(libs.kotlinx.serialization.json)
//            implementation(libs.koin.core)
//            implementation(libs.koin.compose)
            implementation(libs.coil)
            implementation(libs.coil.network.ktor)
            implementation(libs.multiplatformSettings)
            implementation(libs.kotlinx.datetime)
            implementation(libs.androidx.ui.text.google.fonts)
        }

//        commonTest.dependencies {
//            implementation(kotlin("test"))
//            @OptIn(ExperimentalComposeLibrary::class)
//            implementation(compose.uiTest)
//            implementation(libs.kotlinx.coroutines.test)
//        }
//
        androidMain.dependencies {
            implementation(compose.uiTooling)
            implementation(libs.androidx.runtime.android)
//            implementation(libs.androidx.ui.text.google.fonts)

//            implementation(libs.androidx.activityCompose)
//            implementation(libs.kotlinx.coroutines.android)
//            implementation(libs.ktor.client.okhttp)
        }
//
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
//            implementation(libs.kotlinx.coroutines.swing)
//            implementation(libs.ktor.client.okhttp)
            implementation(libs.ui.util)
        }
//
        iosMain.dependencies {
//            implementation(libs.ktor.client.darwin)
        }
    }
}