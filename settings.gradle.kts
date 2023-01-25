rootProject.name = "okb-exercises"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://kotlin.bintray.com/kotlinx")
    }
    plugins {
        // Using `by` is a simplification of line:
        // val kotlinVersion = settings.extra.properties["kotlinVersion"].toString()
        val kotlinVersion: String by settings

        kotlin("jvm") version kotlinVersion
        kotlin("multiplatform") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
    }
}

include("kmp-app")
