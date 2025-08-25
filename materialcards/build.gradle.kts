plugins {
    id("com.android.library")
    id("kotlin-android")
    id("org.jlleitschuh.gradle.ktlint") version "13.1.0"
    id("maven-publish")
}

group = "eu.khonsu.libraries"
version = "1.1-SNAPSHOT"

android {
    compileSdk = 36
    namespace = "eu.khonsu.libraries.materialcards"
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
    defaultConfig {
        minSdk = 21
        vectorDrawables.useSupportLibrary = true
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
    all {
        exclude("httpclient")
        exclude("commons-logging")
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.17.0")
    implementation("androidx.appcompat:appcompat:1.7.0")

    // Design elements
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")
    implementation("com.google.android.material:material:1.12.0")
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = project.group as String
            artifactId = "material-cards"
            version = project.version as String

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
