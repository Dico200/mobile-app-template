import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
}

allprojects {
    group = "productions.dico"
    version = "0.0.1"

    repositories {
        jcenter()
        mavenCentral()
        maven("https://maven.google.com")

        /*
        maven("https://kotlin.bintray.com/kotlinx/")
        maven("https://kotlin.bintray.com/kotlin-dev/")
        maven("https://dl.bintray.com/kotlin/ktor/")
        */
    }
}

subprojects {

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf(
                "-XXLanguage:+InlineClasses",
                "-XXLanguage:+NewTypeInference",
                "-Xuse-experimental=kotlin.Experimental"
            )
        }
    }

}