plugins {
    kotlin("multiplatform") version "1.6.10"
    id("com.android.library") version "7.0.3"
    kotlin("plugin.serialization") version "1.6.10"
    `maven-publish`
    id("com.github.ben-manes.versions") version "0.42.0"
    id("se.patrikerdes.use-latest-versions") version "0.2.18"
}

group = "com.mewsic"
version = "1.0.1"

repositories {
    mavenCentral()
    google()
}

kotlin {
    android {
        publishLibraryVariants("release")
    }
    js(IR) {
        browser()
        nodejs()
    }
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api("io.ktor:ktor-client-core:2.0.0")
                api("io.ktor:ktor-client-content-negotiation:2.0.0")
                api("io.ktor:ktor-serialization-kotlinx-json:2.0.0")
                api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
            }
        }

        val androidMain by getting {
            dependencies {
                api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")
                api("io.ktor:ktor-client-cio:2.0.0")
            }
        }

        val jvmMain by getting {
            dependencies {
                api("io.ktor:ktor-client-cio:2.0.0")
            }
        }

        val jsMain by getting {
            dependencies {
                api("io.ktor:ktor-client-js:2.0.0")
            }
        }
    }
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 31
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

tasks.named("publish") {
    dependsOn("build")
}

if (project.ext.has("mavenToken")) {
    println(project.ext["mavenToken"])
    publishing {
        repositories {
            maven {
                name = "Host"
                url = uri("https://maven.martmists.com/releases")
                credentials {
                    username = "mewsic"
                    password = project.ext["mavenToken"]!! as String
                }
            }
        }

        publications.withType<MavenPublication> {

        }
    }
} else if (System.getenv("CI") == "true") {
    publishing {
        repositories {
            maven {
                name = "Host"
                url = uri(System.getenv("GITHUB_TARGET_REPO")!!)
                credentials {
                    username = "mewsic"
                    password = System.getenv("DEPLOY_KEY")!!
                }
            }
        }

        publications.withType<MavenPublication> {
            if (System.getenv("DEPLOY_TYPE") == "snapshot") {
                version = System.getenv("GITHUB_SHA")!!
            }
        }
    }
}
