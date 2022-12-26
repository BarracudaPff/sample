import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion: String by project
val kotestVersion: String by project
val jUnitJupiterVersion: String by project

plugins {
    kotlin("jvm")
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
//    maven("http://...")
//    maven {
//        url = uri("http://...")
//
//        credentials {
//            username = System.getenv("ENV_NAME")
//            password = System.getenv("ENV_PASS")
//        }
//    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.1")
    implementation("info.debatty", "java-string-similarity", "2.0.0")
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

kotlin {
}

application {
    mainClass.set("ru.otus.otuskotlin.ApplicationMainKt")
}

tasks {
    this.named("jar")
    withType<Jar> {
        manifest {
            attributes("Main-Class" to "ru.otus.otuskotlin.ApplicationMainKt")
        }
    }

    task<Jar>("fatJar") {
        archiveBaseName.set(project.name + "-fat-jar-" + project.version)
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE

        manifest {
            attributes("Main-Class" to "ru.otus.otuskotlin.ApplicationMainKt")
        }
        from(
            configurations.runtimeClasspath.get()
                .map { if (it.isDirectory) it else zipTree(it) }
        )
        with(named("jar").get() as CopySpec)
    }

    build {
        dependsOn("fatJar")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
