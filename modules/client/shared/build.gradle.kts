import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

plugins {
    id("kotlin-multiplatform")
}

kotlin {

    targets {
        fromPreset(presets.jvm, "jvm")
        fromPreset(presets.iosX64, "ios")
    }

    sourceSets {

        val commonMain by getting {
            dependencies {

            }
        }

    }

}