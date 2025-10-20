plugins {
    id("personalfinanceapp.kotlin.library")
    alias(libs.plugins.kotlin.ksp)
}

dependencies {
    // Coroutines
    implementation(libs.coroutines.core)

    // Hilt (Pure Kotlin)
    implementation(libs.hilt.core)
    ksp(libs.hilt.compiler)

    // Testing
    testImplementation(libs.junit)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.coroutines.test)
}