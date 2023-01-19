@file:Suppress("UNUSED_VARIABLE")

plugins {
    kotlin("multiplatform")
}

group "org.example"
version "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val kotlinVersion: String by project
val ktorVersion: String by project
val kotlinReact: String by project
val kotlinReactVersion = "17.0.2"

kotlin {
    jvm {
        withJava()
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js {
        browser()
    }

//    val nativeTarget = when (System.getProperty("os.name")) {
//        "Mac OS X" -> macosX64()
//        "Linux" -> linuxX64()
//        "Windows" -> mingwX64()
//        else -> throw IllegalArgumentException("Not supported")
//    }
//
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
            }
        }
        val jsMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-js:$ktorVersion")
                implementation("io.ktor:ktor-client-json-js:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization-js:$ktorVersion")
                implementation("org.jetbrains:kotlin-react:$kotlinReact")
                implementation("org.jetbrains:kotlin-react-dom:$kotlinReact")
                implementation(npm("react", "16.13.1"))
                implementation(npm("react-dom", "16.13.1"))
//                implementation(kotlin("stdlib-js"))
//                implementation(npm("lodash", "4.0.0"))
//                implementation(npm("is-sorted", "1.0.5"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("io.ktor:ktor-serialization:$ktorVersion")
                implementation("io.ktor:ktor-server-core:$ktorVersion")
                implementation("io.ktor:ktor-server-netty:$ktorVersion")
                implementation("ch.qos.logback:logback-classic:1.2.3")
                implementation("org.slf4j:slf4j-api:1.7.30")
                implementation("io.ktor:ktor-websockets:$ktorVersion")
//                implementation(kotlin("stdlib-jdk8"))
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
