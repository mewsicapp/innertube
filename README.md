# Innertube
An innertube library for Kotlin/Multiplatform, made for and used by mewsic.

**This is just a rough port of the python library [innertube](https://github.com/tombulled/innertube), and has no additional features.**


## Usage

### Gradle

```kotlin
repositories {
    maven("https://maven.martmists.com/releases")
    maven("https://maven.martmists.com/snapshots")  // For getting builds of a specific commit 
}

dependencies {
    implementation("com.mewsic:innertube:1.0.1")
}
```

### Example

> Note: Due to the size of the response data as well as the large differences between client types, no handing of the data requested is shown. 

```kotlin
suspend fun main() {
    val client = InnertubeClient(Client.ANDROID_MUSIC)
    client.config()  // Inform google this is the same session
    val searchData = client.search("Daft Punk")
    val playerData = client.player("ZFZM6jDTWd4")
}
```
