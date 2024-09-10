plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.luaramartins.lightningbitcoinapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.luaramartins.lightningbitcoinapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        signingConfig = signingConfigs.getByName("debug")
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation ("androidx.activity:activity-compose:1.8.2")
    implementation (platform("androidx.compose:compose-bom:2022.10.00"))
    implementation ("androidx.compose.ui:ui")
    implementation ("androidx.compose.ui:ui-graphics")
    implementation ("androidx.compose.ui:ui-tooling-preview")
    implementation ("androidx.compose.material3:material3-android:1.2.0-rc01")

    implementation ("androidx.compose.ui:ui:1.3.1")
    implementation ("androidx.compose.material:material:1.3.1")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.3.1")
    implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0")

    implementation("androidx.navigation:navigation-compose:2.8.0-alpha01")
    implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    implementation ("com.google.accompanist:accompanist-pager:0.12.0")
    implementation("io.coil-kt:coil-compose:2.4.0")

    implementation ("androidx.compose.runtime:runtime-livedata:1.0.0-beta01")

    implementation("io.insert-koin:koin-android:3.4.0")
    implementation("io.insert-koin:koin-core:3.4.0")
    implementation("io.insert-koin:koin-android-compat:3.4.0")
    implementation ("io.insert-koin:koin-androidx-compose:3.4.0")

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.google.code.gson:gson:2.8.6")

    implementation ("com.squareup.okhttp3:okhttp:4.2.1")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.2.1")
    implementation ("com.squareup.okhttp3:okhttp-urlconnection:4.2.1")

    implementation ("com.google.accompanist:accompanist-swiperefresh:0.28.0")

    implementation ("com.airbnb.android:lottie-compose:6.0.0")

}