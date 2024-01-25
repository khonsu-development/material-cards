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

## How to create a new artefact on Jitpack

JitPack is an easy-to-use package repository for Git. It is where this Android design library is
published.

In order to publish the latest version of this library on Jitpack:

1. Go to https://jitpack.io/#khonsu-development/material-cards
2. Click on "Get it", next to the desired version.
