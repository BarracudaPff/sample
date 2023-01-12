package ru.otus

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import ru.otus.auth.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(Authentication) {
        configureBasicAuth()
        configureFormAuth()
        configureJwtAuth()
    }

    configureBasicAuthRouting()
    configureFormAuthRouting()
    configureJwtAuthRouting()

    configureErrorsRouting()
}
