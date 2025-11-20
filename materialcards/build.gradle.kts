plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android") version "2.2.21"
    id("org.jlleitschuh.gradle.ktlint") version "14.0.1"
    id("maven-publish")
}

group = "eu.khonsu.libraries"
version = "1.1-SNAPSHOT"

android {
    compileSdk = 36
    namespace = "eu.khonsu.libraries.materialcards"
    publishing {
        singleVariant("release") {}
    }
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
    implementation("androidx.appcompat:appcompat:1.7.1")

    // Design elements
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")
    implementation("com.google.android.material:material:1.13.0")
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
