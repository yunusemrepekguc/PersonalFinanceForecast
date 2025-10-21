package convention

import com.android.build.api.dsl.ApplicationExtension
import convention.CommonPluginConfig.configureAndroidCommon
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class PersonalFinanceAppApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            extensions.configure<ApplicationExtension> {
                configureAndroidCommon(this)

                defaultConfig {
                    applicationId = AndroidConfig.APPLICATION_ID
                    minSdk = AndroidConfig.MIN_SDK
                    targetSdk = AndroidConfig.TARGET_SDK
                    versionCode = AndroidConfig.VERSION_CODE
                    versionName = AndroidConfig.VERSION_NAME

                    testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER

                    vectorDrawables {
                        useSupportLibrary = true
                    }
                }

                buildTypes {
                    release {
                        isMinifyEnabled = true
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                    debug {
                        isMinifyEnabled = false
                    }
                }

                buildFeatures {
                    buildConfig = true
                }
            }

            extensions.configure<KotlinAndroidProjectExtension> {
                jvmToolchain(17)
            }
        }
    }
}