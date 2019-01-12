
plugins {
    id("kotlin-multiplatform")
}

kotlin {
    targets {
        fromPreset(presets.iosX64, "ios")
    }
}

