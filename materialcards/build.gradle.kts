plugins {
    kotlin("android")
    id("com.android.library")
    id("kotlin-android")
    id("org.jlleitschuh.gradle.ktlint") version "10.2.1"
    id("maven-publish")
}

group = "eu.khonsu.libraries"
version = "1.0-SNAPSHOT"

android {
    compileSdk = 31
    buildToolsVersion = "30.0.3"

    defaultConfig {
        minSdk = 21
        targetSdk = 31
        vectorDrawables.useSupportLibrary = true
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

java {
    withSourcesJar()
    withJavadocJar()
}


// afterEvaluate {
//     publishing {
//         publications {
//             // Creates a Maven publication called "release".
//             create<MavenPublication>("release") {
//                 // Applies the component for the release build variant.
//                 from(components["release"])
//
//                 // You can then customize attributes of the publication as shown below.
//                 groupId = "eu.khonsu.libraries"
//                 artifactId = "material-cards"
//                 version = "1.0-SNAPSHOT"
//             }
//         }
//     }
// }

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
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")

    // Design elements
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("com.google.android.material:material:1.5.0")
}
