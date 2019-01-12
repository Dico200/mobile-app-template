
plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

dependencies {
    //compile(project("client:logic"))
}

android {
    compileSdkVersion(28)
    buildToolsVersion = "28.0.3"

    defaultConfig {
        applicationId = "productions.dico.holiday.itinerary"
        minSdkVersion(18)
        targetSdkVersion(28)
        versionCode = 13
        versionName = "1.1.1"
        multiDexEnabled = true
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        val debug by getting
        val release by getting {
            isMinifyEnabled = false
        }
    }

    sourceSets {

    }
}