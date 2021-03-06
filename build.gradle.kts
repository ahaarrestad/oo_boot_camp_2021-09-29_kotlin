repositories {
    // Use Maven Local for personal tools to use
    mavenLocal()

    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    kotlin("jvm") version "1.5.21"

}
