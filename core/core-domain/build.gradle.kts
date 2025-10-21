plugins {
    id("personalfinanceapp.common")
}

android {
    namespace = "com.yempe.personalfinanceforecast.core.domain"
}

dependencies {

    implementation(project(":core:core-common"))
    implementation(libs.coroutines.core)

    testImplementation(libs.junit)
    testImplementation(libs.truth)
}