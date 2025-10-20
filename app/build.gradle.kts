plugins {
    id("personalfinanceapp.application")
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.yempe.personalfinanceforecast"

    buildFeatures {
        compose = true
    }
}

dependencies {
    //Core Android
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    //Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)

    //Dagger & Hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    ksp(libs.hilt.android.compiler)

    // ========== Navigation ==========
    implementation(libs.navigation.compose)

    //Retrofit
    implementation(libs.bundles.retrofit)

    //Room
    implementation(libs.bundles.room)
    ksp(libs.room.compiler)

    //Coroutines
    implementation(libs.bundles.coroutines)

    //WorkManager
    implementation(libs.workmanager)
    implementation(libs.workmanager.hilt)

    //Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.bundles.firebase)

    //Testing
    testImplementation(libs.junit)
    testImplementation(libs.coroutines.test)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    //Debug
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}