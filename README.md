# pict4java
Use the library PICT(created by Microsoft) from Java.

[![](https://img.shields.io/badge/GitHub%20Package%20Registry-enable-brightgreen.svg?logo=github)](https://github.com/korosuke613/pict4java/packages/69597) [![codecov](https://codecov.io/gh/korosuke613/pict4java/branch/master/graph/badge.svg)](https://codecov.io/gh/korosuke613/pict4java)


## Setup

### Install dynamic library
1. Download libraris(`libpict.so`, `libpict.dylib`) this [URL](https://github.com/korosuke613/pict4java/releases/tag/pict%40096352f).
2. Put download files to `resources` directory.

### Install pict4java

#### for Gradle
Add the following code to `build.gradle`.([Authenticating to GitHub Packages](https://help.github.com/en/github/managing-packages-with-github-packages/configuring-gradle-for-use-with-github-packages#authenticating-to-github-packages))
```gradle:build.gradle
plugins {
    id "net.linguica.maven-settings" version "0.5"
}

repositories {
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/korosuke613/pict4java")
        credentials {
            username = "Your GitHub username"
            password = "Your GitHub access token"
        }
    }
}

dependencies {
    implementation "com.github.korosuke613:pict4java:v2.0.0"
}
```
