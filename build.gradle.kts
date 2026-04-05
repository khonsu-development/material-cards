// Top-level build file where you can add configuration options common to all subprojects/modules.

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
