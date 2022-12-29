package ru.otus.application

import CalcData
import CalcResult
import io.ktor.http.HttpStatusCode
import io.ktor.resources.*
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.autohead.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.resources.get
import io.ktor.server.resources.put
import io.ktor.server.resources.Resources
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*
import kotlinx.serialization.Serializable

fun HTML.index() {
    head {
        title("Hello from Ktor!")
    }
    body {
        div {
            +"Hello from Ktor"
        }
        div {
            id = "root"
        }
        script(src = "/static/kmp-lesson.js") {}
    }
}

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1", module = Application::myApplicationModule).start(wait = true)
}

fun Application.myApplicationModule() {
    install(AutoHeadResponse)
    install(CallLogging)
    install(Resources)
    install(ContentNegotiation) {
        jackson()
    }

    routing {
        get("/") {
            call.respondHtml { index() }
        }
        get<UserParams> {
            call.respondText("User: ${it.id} ${it.name}")
        }
        put<UserParams> {
            call.respondText("User changed: ${it.id} ${it.name}")
        }
        calculate()

        static("/static") {
            resources()
        }
    }
}

fun Routing.calculate() {
    post("/calc/sum") {
        val request = call.receive<CalcData>()
        val result = CalcResult(request.a + request.b, "sum")
        call.respond(result)
    }
}

@Serializable
@Resource("/user/{id}")
class UserParams(val id: String, val name: String?)