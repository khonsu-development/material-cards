# Material Cards

Based on the work of Eugene Brusov.

http://eugenebrusov.com/using-of-constraintlayout-to-build-out-cardview-1-of-3/
https://github.com/eugenebrusov/android-cards

## Get started

In the root `build.gradle.kts`:

```kotlin
allprojects {
    repositories {
        // ...
        maven(url = "https://jitpack.io")
    }
}
```

In the app's `build.gradle.kts`, add the dependency:

```kotlin
dependencies {
    implementation("com.github.khonsu-development:material-cards:<latest-version>")
}
```
