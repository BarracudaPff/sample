import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories { mavenCentral() }

val kotestVersion = "5.4.1"
val jUnitJupiterVersion = "5.9.0"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.10")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.1")
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit5"))

    testImplementation("io.kotest:kotest-framework-engine:$kotestVersion")
    testImplementation("io.kotest:kotest-framework-datatest:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-params:$jUnitJupiterVersion")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
