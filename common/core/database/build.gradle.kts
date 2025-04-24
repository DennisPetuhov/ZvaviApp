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
                
                // Room
                implementation("androidx.room:room-runtime:2.7.0")
                implementation("androidx.room:room-ktx:2.7.0")
                implementation("androidx.sqlite:sqlite-ktx:2.4.0")
            }
        }
        
        androidMain {
            dependencies {
                implementation("androidx.room:room-runtime:2.7.0")
                implementation("androidx.room:room-ktx:2.7.0")
            }
        }
        
        iosMain {
            dependencies {
                implementation("androidx.room:room-runtime:2.7.0")
                implementation("androidx.room:room-ktx:2.7.0")
            }
        }
    }
}
