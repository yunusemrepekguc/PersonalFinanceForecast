// buildSrc/src/main/kotlin/convention/PersonalFinanceAppKotlinLibraryPlugin.kt
package convention

import convention.CommonPluginConfig.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project

class PersonalFinanceAppKotlinLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("java-library")
                apply("org.jetbrains.kotlin.jvm")
            }

            configureKotlinJvm()
        }
    }
}