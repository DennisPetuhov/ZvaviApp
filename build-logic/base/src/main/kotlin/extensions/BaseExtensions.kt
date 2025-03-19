package extensions

import com.android.build.api.dsl.AndroidResources
import com.android.build.api.dsl.BuildFeatures
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.DefaultConfig
import com.android.build.api.dsl.Installation
import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.dsl.ProductFlavor
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.the
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompilerOptions
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinAndroidTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

private typealias AndroidExtensions = CommonExtension<
        out BuildFeatures,
        out BuildType,
        out DefaultConfig,
        out ProductFlavor,
        out AndroidResources,
        out Installation>
private val Project.androidExtension: AndroidExtensions
    get() = extensions.findByType(BaseAppModuleExtension::class)
        ?: extensions.findByType(LibraryExtension::class)
        ?: error(
            "\"Project.androidExtension\" value may be called only from android application" +
                    " or android library gradle script"
        )

private val Project.androidExtension1: BaseAppModuleExtension
    get() = extensions.findByType(BaseAppModuleExtension::class)
        ?: error(
            "\"Project.androidExtension\" value may be called only from android application" +
                    " or android library gradle script"
        )
//Чтобы Version Catalogs у нас заработали, напишем extension.
val Project.libs: LibrariesForLibs
    get() = the<LibrariesForLibs>()

val Project.projectJavaVersion: JavaVersion
    get() = JavaVersion.toVersion(libs.versions.java.get().toInt())
//В функции Project.androidConfig предоставляем лямбду block с контекстом на AndroidExtensions.
//Теперь при использовании этой функции мы сможем задавать android-specific-конфигурации.
fun Project.androidConfig(block: AndroidExtensions.() -> Unit): Unit = block(androidExtension)


fun Project.android(configure: BaseAppModuleExtension.() -> Unit):Unit =    configure(androidExtension1)



fun Project.kotlinMultiplatformConfig(block: KotlinMultiplatformExtension.() -> Unit) {
    extensions.findByType<KotlinMultiplatformExtension>()
        ?.apply(block)
        ?: error("Kotlin multiplatform was not been added")
}

fun Project.kotlinAndroidTarget(block: KotlinAndroidTarget.() -> Unit) {
    kotlinMultiplatformConfig {
        androidTarget(block)
    }
}
//В функции Project.kotlinJvmCompilerOptions мы ищем таску KotlinJvmCompile для того, чтобы предоставить возможность
//сконфигурировать в лямбде block параметры kotlin-компилятора под JVM-таргет.

fun Project.kotlinJvmCompilerOptions(block: KotlinJvmCompilerOptions.() -> Unit) {
    tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions(block)
    }
}
