
buildscript {
    repositories {
        maven("https://maven.google.com")
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://dl.bintray.com/jetbrains/kotlin-native-dependencies")
    }

    dependencies {
        // Files.append("hello ${SimpleDateFormat().format(Date())}", file("$rootDir/gradle-log.txt"), StandardCharsets.UTF_8)
        // classpath("org.jetbrains.kotlin:kotlin-native-gradle-plugin:1.3.11")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.11")
    }
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://dl.bintray.com/jetbrains/kotlin-native-dependencies")
    }
}

rootProject.name = "holiday-itinerary-app"

enableFeaturePreview("GRADLE_METADATA")

fun includeProject(projectName: String) {
    include(projectName)
    project(":$projectName").projectDir = file("modules-$projectName".replace('-', File.separatorChar))
}

includeProject("shared")
includeProject("server")
includeProject("client-shared")
includeProject("client-android")
includeProject("client-ios")
