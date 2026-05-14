plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.ktlint)
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

dependencies {
    implementation(libs.bundles.androidx.ui)
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
