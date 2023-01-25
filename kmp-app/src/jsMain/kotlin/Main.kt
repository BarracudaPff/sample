import actions.UserListAction
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import react.FC
import react.Props
import react.create
import react.dom.client.createRoot
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.useState
import web.dom.document
import web.window.window

val scope = MainScope()

val client = HttpClient {
    install(ContentNegotiation) {
        json()
    }
    defaultRequest {
        header("key", "value")
    }
}

val root = kotlinx.browser.window.location.origin

object UserService {
    suspend fun getAll(): UserListAction.Response.Success {
        val res = client.post("$root/users/list")
        return res.call.body<UserListAction.Response.Success>()
    }
}

fun main() {
    window.onload = {
        console.log("!#")
        val container = document.getElementById("root")!!

        createRoot(container).render(
            div.create {
                child(listOfUsers.create {
                })
            }
        )
    }
}

val listOfUsers = FC<Props> {
    var users by useState<List<User>?>(null)


    div {
        +"H!ello"
    }
    button {
        onClick = {
            scope.launch {
                val newUsers = UserService.getAll()
                users = newUsers.users
            }
        }
        +"Get all users"
    }
    div {
        +"Hello"
    }
    div.create {
        users?.forEach { user ->
            child(div.create {
                +(user.nameFirst + " " + user.nameSecond)
            })
        }
    }
}
