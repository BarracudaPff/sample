package ru.otus.auth

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

private suspend fun validate(call: ApplicationCall, credential: UserPasswordCredential): Principal? =
    if (checkUserPassword(credential.name, credential.password)) UserIdPrincipal(credential.name) else null

suspend fun PipelineContext<Unit, ApplicationCall>.processHello(method: String) {
    val userName = call.principal<UserIdPrincipal>()?.name ?: "unknown"
    call.respondText("Hello, $userName. You use $method")
}

fun AuthenticationConfig.configureBasicAuth() {
    basic("auth-basic") {
        realm = "Access to the '/basic/' path"

        validate(::validate)
    }
}

fun Application.configureBasicAuthRouting() {
    routing {
        authenticate("auth-basic") {
            get("/auth-basic") {
                processHello("auth-basic")
            }
        }
    }
}