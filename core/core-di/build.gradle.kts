plugins {
    id("personalfinanceapp.common")
    alias(libs.plugins.kotlin.ksp)
}

android {
    namespace = "com.yempe.personalfinanceforecast.core.di"
}

dependencies {

    implementation(project(":core:core-common"))
    // Hilt
    implementation(libs.hilt.core)
    ksp(libs.hilt.compiler)
}