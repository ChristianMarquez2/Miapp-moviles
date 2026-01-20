plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    // 1. Asegúrate de que este namespace sea IGUAL al de tu MainActivity.kt
    namespace = "com.example.miapp"
    compileSdk = 36

    // 2. CORRECCIÓN: El SDK estable actual es 34 o 35.
    // Cambiar 36 por 35 (Android 15) o 34 (Android 14)

    defaultConfig {
        applicationId = "com.example.miapp"

        // 3. CORRECCIÓN: minSdk 35 es demasiado alto (solo funcionaría en Android 15).
        // Lo normal es usar 24 o 26 para que funcione en la mayoría de celulares.
        minSdk = 26

        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    // 4. CORRECCIÓN: Para proyectos modernos de Compose, se recomienda Java 17 o 11.
    // Cambiamos a Java 17 que es el estándar actual de Android Studio Jellyfish/Koala.
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))

    // Fixed references here:
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Pruebas
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))

    // Fixed references here:
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)




    // CameraX (Versión estable)
    val camerax_version = "1.3.4"
    implementation("androidx.camera:camera-core:$camerax_version")
    implementation("androidx.camera:camera-camera2:$camerax_version")
    implementation("androidx.camera:camera-lifecycle:$camerax_version")
    implementation("androidx.camera:camera-view:$camerax_version")
    implementation("com.google.android.gms:play-services-location:21.1.0")

    // Accompanist Permissions (Versión compatible con las librerías anteriores)
    implementation("com.google.accompanist:accompanist-permissions:0.34.0")
}