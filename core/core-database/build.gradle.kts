plugins {
    id("personalfinanceapp.common")
}

android {
    namespace = "com.yempe.personalfinanceforecast.core.database"
}

dependencies {
    implementation(libs.coroutines.core)
}