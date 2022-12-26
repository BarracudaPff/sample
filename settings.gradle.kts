rootProject.name = "okb-exercises"

pluginManagement {
    plugins {
//        val kotlinVersion = settings.extra.properties["kotlinVersion"].toString()
        val kotlinVersion: String by settings

        kotlin("jvm") version kotlinVersion
    }
}
