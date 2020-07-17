# README

The companion example project to my blog post ["How To: Sorting and Reporting Your Dependencies Versions with Gradle"](https://ed-george.github.io/articles/15-07-2020/gradle-sorting-reporting)

# Run a dependency report 📋

Use the command `./gradlew dependencyUpdates` to run this project's report. You can see the HTML output from this in the `/reports` folder.

To modify the output of this report, see the `dependency-update.gradle` file.

# App dependencies 🤝

All dependencies and their versions are stored in `versions.gradle` before being grouped in `version-groups.gradle`.

The app's modules can then use dependencies in their `build.gradle` files in the following way:

```
// Module specific Dependencies
dependencies {
    kotlin()
    network()
    testing()
}
```

# Reporting issues 🐛

Found a bug or a problem on a specific feature? Open an issue on Github issues

# Contributing 🛠

I welcome contributions and discussion for bug fixes. It is recommended to file an issue first to prevent unnecessary efforts, but feel free to put in pull requests in the case of trivial changes. In any other case, please feel free to open discussion and I will get back to you when possible.
