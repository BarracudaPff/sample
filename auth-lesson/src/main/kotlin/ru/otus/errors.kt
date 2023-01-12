package ru.otus

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

class RequestError(msg: String): RuntimeException(msg)

fun Application.configureErrorsRouting() {
    /*install(StatusPages) {
        exception<RequestError> { call, cause ->
            call.respondText(text = "400: $cause", status = HttpStatusCode.BadRequest)
        }
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }*/

    routing {
        get("/error") {
            when (call.parameters["valid"]) {
                "1" -> call.respondText("All ok")
                "2" -> throw RequestError("Request error")
                else -> throw RuntimeException("Server Error")
            }
        }
    }
}