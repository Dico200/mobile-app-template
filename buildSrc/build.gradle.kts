
plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    jcenter()
    maven("https://maven.google.com")
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.11")
    compile("com.android.tools.build:gradle:3.2.1")
}