import actions.TeamCreateAction
import actions.UserCreateAction
import actions.UserDeleteAction
import actions.UserListAction
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*
import services.TeamService
import services.UserService
import services.db.TeamDbService
import services.db.UserDbService

fun main() {
    val port = System.getenv("PORT")?.toInt() ?: 9090

    embeddedServer(Netty, port) {
        install(ContentNegotiation) {
            json()
        }

        routing {
            get("/") {
                call.respondText(
                    this::class.java.classLoader.getResource("index.html")!!.readText(),
                    ContentType.Text.Html,
                )
            }
            get("/sample") {
                call.respondHtml(HttpStatusCode.OK) {
                    head {
                        title {
                            +"Sample site"
                        }
                        link {
                            rel = "stylesheet"
                            href = "style.css"
                        }
                    }
                    body {
                        h2 {
                            +"Hello!"
                        }
                        script(src = "/kmp-app.js") {}
                    }
                }
            }
            static("/") {
                resources()
            }

            val teamDbService = TeamDbService()
            val userDbService = UserDbService()

            val userService = UserService(teamDbService, userDbService)
            val teamService = TeamService(teamDbService, userDbService)

            route("users") {
                post("list") {
                    val data = userService.list()
                    call.respond(data)
                }
                post("create") {
                    val req = call.receive<UserCreateAction.Request>()
                    val data = userService.create(req)
                    call.respond(data)
                }
                post("delete") {
                    val req = call.receive<UserDeleteAction.Request>()
                    val data = userService.delete(req)
                    call.respond(data)
                }
            }

            route("teams") {
                post("create") {
                    val req = call.receive<TeamCreateAction.Request>()
                    val data = teamService.create(req)
                    call.respond(data)
                }
            }
        }

    }.start(wait = true)
}

