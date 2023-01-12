package ru.otus.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

private const val REALM = "master"
private const val SECRET = "secret"
private const val AUDIENCE = "otus"

private suspend fun validate(call: ApplicationCall, credential: JWTCredential): Principal? =
    credential["name"]?.let { UserIdPrincipal(it) }

fun AuthenticationConfig.configureJwtAuth() {
    jwt("auth-jwt") {
        realm = REALM
        verifier(JWT
            .require(Algorithm.HMAC256(SECRET))
            .withAudience(AUDIENCE)
            .build())

        validate(::validate)
    }
}

fun Application.configureJwtAuthRouting() {
    routing {
        authenticate("auth-jwt") {
            get("/auth-jwt") {
                processHello("auth-jwt")
            }
        }
    }
}