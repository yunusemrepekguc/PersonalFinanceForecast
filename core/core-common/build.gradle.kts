plugins {
    id("personalfinanceapp.common")
}

android {
    namespace = "com.yempe.personalfinanceforecast.core.common"
}

dependencies {
    implementation(libs.coroutines.core)
}