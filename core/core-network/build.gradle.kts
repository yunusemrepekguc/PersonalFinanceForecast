plugins {
    id("personalfinanceapp.common")
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.yempe.personalfinanceforecast.core.network"
}

dependencies {
    implementation(project(":core:core-common"))

    // Network
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)

    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    //Coroutines
    implementation(libs.coroutines.android)
}