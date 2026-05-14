# AGENTS.md -- Material Cards

Guidance for AI agents working on this codebase.

## Project overview

**Material Cards** is an Android library that provides a collection of pre-built Material Design
card view components. Each card is a custom `CardView` subclass with a `ConstraintLayout`-based XML
layout and configurable styled attributes. The library is published via JitPack and consumed by
multiple Android apps (World of Alphabets, World of Communism, World of Dinosaurs, World of Tea).

## Tech stack

- **Language:** Kotlin, JVM 17.
- **Build:** Gradle (Kotlin DSL), version catalog in `gradle/libs.versions.toml`.
- **Android:** compileSdk 36, minSdk 21; single library module `:materialcards`.
- **Dependencies:** AndroidX (core-ktx, appcompat, constraintlayout), Material Components.
- **Linting:** ktlint (IntelliJ IDEA code style).
- **Publishing:** Maven Publish plugin; distributed via JitPack
  (`com.github.khonsu-development:material-cards`).

## Codebase layout

| Path                                               | Purpose                                                  |
|----------------------------------------------------|----------------------------------------------------------|
| `materialcards/`                                   | Single Android library module.                           |
| `materialcards/src/main/kotlin/.../materialcards/` | Kotlin source: CardView subclasses and extensions.       |
| `materialcards/src/main/res/layout/`               | XML layouts for each card variant.                       |
| `materialcards/src/main/res/values/attrs.xml`      | Custom styled attributes (`declare-styleable`) per card. |
| `materialcards/src/main/res/values/`               | Colors, dimensions, strings, styles.                     |
| `materialcards/src/main/res/drawable/`             | Vector drawables (icons, background placeholder).        |

## Card view catalog

| Class      | Description                                                         |
|------------|---------------------------------------------------------------------|
| CardView1  | Media 16:9 and supporting text.                                     |
| CardView2  | Avatar, media 16:9, supporting text, action buttons.                |
| CardView4  | Image, title, subtitle, expandable supporting text, action buttons. |
| CardView5  | Title, subtitle, supporting text, actions, supplemental actions.    |
| CardView6  | Media 16:9 and image action buttons.                                |
| CardView7  | Media 1:1, title, subtitle, actions, supplemental actions.          |
| CardView8  | Title, subtitle, supporting text, small image (right), actions.     |
| CardView8b | Same as CardView8 but with the image on the left.                   |
| CardView9  | Title, subtitle, supporting text, 1.5x image (right), actions.      |
| CardView10 | Title, subtitle, supporting text, 2x image (right), actions.        |
| CardView11 | Media 3x (tall) and image action buttons.                           |
| CardView12 | Title, subtitle, expandable supporting text.                        |

There is no CardView3; numbering skips from 2 to 4.

## Conventions

- **Style:** Follow ktlint and `.editorconfig` (IntelliJ IDEA style for `*.kt` / `*.kts`).
- **Dependencies:** Add and version via `gradle/libs.versions.toml`; reference with `libs.*` in
  build files.
- **Package:** Use `eu.khonsu.libraries.materialcards`.
- **Pattern:** Each card inflates its layout, binds views via `findViewById` in `initComponents()`,
  reads styled attributes in a `when` block, and exposes public getters/setters.
- **Visibility:** `@Suppress("MemberVisibilityCanBePrivate", "unused")` is intentional on card
  classes because they are a library API surface.
- **English:** Prefer US English.
- **Documentation:** Write concise documentation for the logic and end sentences with a period.

## Build and run

```bash
./gradlew build        # compile and lint
./gradlew ktlintCheck  # lint only
./gradlew clean        # clean build outputs
```

## Publishing

The library is published via JitPack. To release a new version, create a GitHub release and tag with
the version number. JitPack builds and publishes the AAR automatically.

Consumers add the dependency as:

```kotlin
implementation("com.github.khonsu-development:material-cards:<version>")
```

## CI

- **GitHub Actions:** `build.yml` (build on push), `dependency_submission.yml` (dependency graph on
  main), `dependabot_automerge.yml` (auto-merge Dependabot PRs).
- **Dependabot:** Weekly updates for Gradle and GitHub Actions dependencies; patch-level updates are
  ignored.

## When editing

- Follow the existing card pattern when adding a new card variant: Kotlin class extending
  `CardView`, XML layout, styled attributes in `attrs.xml`, and entries in `strings.xml` for preview
  text.
- Use safe calls (`?.`) consistently; avoid non-null assertions (`!!`).
- Reuse the `hideIf` / `hide` / `show` extensions from `extensions/ViewExtensions.kt` for
  conditional visibility.
- After editing Kotlin, ensure ktlint passes.
