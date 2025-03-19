import extensions.kotlinAndroidTarget
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree
import extensions.debugImplementation
import extensions.androidTestImplementation
import extensions.libs
kotlinAndroidTarget {
    instrumentedTestVariant.sourceSetTree.set(KotlinSourceSetTree.test)
}

dependencies {
    androidTestImplementation(libs.androidx.uitest.junit4)
    debugImplementation(libs.androidx.uitest.testManifest)
}