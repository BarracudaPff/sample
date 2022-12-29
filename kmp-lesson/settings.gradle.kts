
rootProject.name = "kmp-lesson"

pluginManagement {
    plugins {
        val multiplatformVersionVersion: String by settings
        val pluginSerializationVersion: String by settings

        kotlin("multiplatform") version multiplatformVersionVersion apply false
        kotlin("plugin.serialization") version pluginSerializationVersion apply false
    }
}

