
plugins {
    id("kotlin-multiplatform")
}

kotlin {
    targets {
        fromPreset(presets.jvm, "jvm")
        fromPreset(presets.iosX64, "ios")
    }
}

