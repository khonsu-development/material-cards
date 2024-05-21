// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.4.1")
        classpath("org.jetbrains.kotlin:kotlin-android-extensions:1.9.24")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.24")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        google()
        maven(url = "https://jitpack.io")
        mavenCentral()
    }
}

tasks.register<Delete>("clean").configure {
    delete(getLayout().buildDirectory)
}

val materialVersion = "1.2.1"
