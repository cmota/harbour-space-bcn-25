plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.compose)

  id("kotlin-parcelize")
  id("com.google.devtools.ksp")
  id("com.google.gms.google-services")

  kotlin("plugin.serialization") version "2.0.21"
}

android {
  namespace = "com.cmota.unsplash"
  compileSdk = 36

  defaultConfig {
    applicationId = "com.cmota.unsplash"
    minSdk = 24
    targetSdk = 36
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
}

dependencies {

  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.activity.compose)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.ui)
  implementation(libs.androidx.ui.graphics)
  implementation(libs.androidx.ui.tooling.preview)
  implementation(libs.androidx.material3)

  implementation(libs.retrofit)
  implementation(libs.converter.moshi)
  implementation(libs.moshi.kotlin)
  implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

  implementation("androidx.compose.runtime:runtime-livedata")

  implementation("io.coil-kt.coil3:coil-compose:3.2.0")
  implementation("io.coil-kt.coil3:coil-network-okhttp:3.2.0")

  implementation("androidx.navigation:navigation-compose:2.9.0")

  val roomVersion = "2.7.2"
  implementation("androidx.room:room-runtime:$roomVersion")
  ksp("androidx.room:room-compiler:$roomVersion")

  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")

  implementation(platform("com.google.firebase:firebase-bom:33.15.0"))
  implementation("com.google.firebase:firebase-auth-ktx")

  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  androidTestImplementation(platform(libs.androidx.compose.bom))
  androidTestImplementation(libs.androidx.ui.test.junit4)
  debugImplementation(libs.androidx.ui.tooling)
  debugImplementation(libs.androidx.ui.test.manifest)
}