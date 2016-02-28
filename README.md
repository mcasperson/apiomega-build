To make use of this plugin, add the following to the build.gradle file:

```
buildscript {
    repositories {
        mavenLocal()
    }
    dependencies {
        classpath 'com.apiomega:build:0.0.1-SNAPSHOT'
    }
}

apply plugin: 'com.apiomega.apiwar'
```