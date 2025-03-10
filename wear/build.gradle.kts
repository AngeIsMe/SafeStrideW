plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.capstone.ssw"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.capstone.ssw"
        minSdk = 30
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {
    // Wearable support libraries
    implementation(libs.play.services.wearable)
    implementation(libs.androidx.wear)


    // Compose BOM for consistent versions
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.core.ktx) // Or latest
    implementation(libs.androidx.appcompat.v170) // Or latest
    implementation(libs.material.v1120) // Or latest - For Material Components
    implementation(libs.androidx.core.splashscreen) // Or latest - For Splash Screen

    // Compose UI and foundational libraries
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.wear.tooling.preview)

    // Wear Compose Material library
    implementation(libs.androidx.compose.material.v141)

    // Optional: Compose Material3 for modern Material themes
    implementation(libs.androidx.material3)

    // Lifecycle and activity support
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Splash Screen API
    implementation(libs.androidx.core.splashscreen)

    // Debugging and testing
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Reference the Wear app project
    wearApp(project(":wear"))
}
