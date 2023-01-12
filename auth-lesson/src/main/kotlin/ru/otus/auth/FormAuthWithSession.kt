package ru.otus.auth

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import io.ktor.util.pipeline.*
import kotlinx.html.*
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

/*
  Надо еще обеспечить удаление старых сессий. В реальной жизни используется что-то внешнее вроде Редиса
 */
private val sessionStorage = ConcurrentHashMap<String, UserIdPrincipal>()

data class UserSession(val sessionId: String)

private suspend fun validateSession(call: ApplicationCall, session: UserSession): Principal? =
    sessionStorage[session.sessionId]

private suspend fun validateLogin(call: ApplicationCall, credential: UserPasswordCredential): Principal? =
    if (checkUserPassword(credential.name, credential.password)) UserIdPrincipal(credential.name) else null

fun AuthenticationConfig.configureFormAuth() {
    session<UserSession>("auth-session") {
        validate(::validateSession)
        challenge {
            call.respondRedirect("/auth-form/login")
        }
    }

    form("auth-form") {
        userParamName = "username"
        passwordParamName = "password"
        validate(::validateLogin)
        challenge {
            call.respond(HttpStatusCode.Unauthorized, "Credentials are not valid")
        }
    }
}

private fun Application.configureSession() {
    install(Sessions) {
        cookie<UserSession>("user_session") {
            cookie.path = "/"
            cookie.maxAgeInSeconds = 30
        }
    }

    routing {
        authenticate("auth-form") {
            post("/auth-form/login") {
                val principal = call.principal<UserIdPrincipal>()!!
                val sessionId = UUID.randomUUID().toString()
                sessionStorage[sessionId] = principal
                call.sessions.set(UserSession(sessionId))

                call.respondRedirect("/auth-session")
            }
        }
        get("/auth-form/login") {
            call.respondHtml {
                body {
                    form(action = "/auth-form/login", encType = FormEncType.applicationXWwwFormUrlEncoded, method = FormMethod.post) {
                        p {
                            +"Username:"
                            textInput(name = "username")
                        }
                        p {
                            +"Password:"
                            passwordInput(name = "password")
                        }
                        p {
                            submitInput() { value = "Login" }
                        }
                    }
                }
            }
        }
    }
}

fun Application.configureFormAuthRouting() {
    configureSession()

    routing {
        authenticate("auth-session") {
            get("/auth-session") {
                processHello("auth-session")
            }
        }
    }
}