import extensions.androidTestImplementation
import extensions.debugImplementation
import extensions.kotlinAndroidTarget
import extensions.libs
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree

kotlinAndroidTarget {
    instrumentedTestVariant.sourceSetTree.set(KotlinSourceSetTree.test)
}

dependencies {
    androidTestImplementation(libs.androidx.uitest.junit4)
    debugImplementation(libs.androidx.uitest.testManifest)
}