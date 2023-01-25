import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion: String by project
val kotestVersion: String by project
val jUnitJupiterVersion: String by project


plugins {
    application
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

group = "org.example"
version = "1.0-SNAPSHOT"

val ktorVersion: String by project
val kotlinReact: String by project
val kotlinStyledVersion: String by project
val logbackVersion: String by project
val slf4jVersion: String by project
val kotlinSerialisation: String by project


kotlin {
    jvm {
        withJava()

        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    js(IR) {
        binaries.executable()
        browser {
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$kotlinSerialisation")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                implementation("io.ktor:ktor-serialization:$ktorVersion")
                implementation("io.ktor:ktor-server-core:$ktorVersion")
                implementation("io.ktor:ktor-server-netty:$ktorVersion")
                implementation("io.ktor:ktor-server-html-builder:$ktorVersion")
                implementation("ch.qos.logback:logback-classic:$logbackVersion")
                implementation("org.slf4j:slf4j-api:$slf4jVersion")
                implementation("io.ktor:ktor-websockets:$ktorVersion")
//                implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
//                implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
//                implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
//                implementation("org.postgresql:postgresql:$postgresVersion")
//                implementation("com.zaxxer:HikariCP:$hikariVersion")
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
                implementation("io.ktor:ktor-client-js:$ktorVersion")
                implementation("io.ktor:ktor-client-json-js:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization-js:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react:$kotlinReact")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:$kotlinReact")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:$kotlinStyledVersion")
                implementation(npm("react", "18.2.0"))
                implementation(npm("react-dom", "18.2.0"))
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
            }
        }
    }
}


tasks.named<Copy>("jvmProcessResources") {
    val jsBrowserDistribution = tasks.named("jsBrowserDistribution")
    from(jsBrowserDistribution)
}

