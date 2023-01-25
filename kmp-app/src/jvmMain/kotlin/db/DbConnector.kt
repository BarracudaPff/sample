package db

import Team
import User

object DbConnector {
    var users = mutableListOf<User>()
    var teams = mutableListOf<Team>()

    fun init() {
        //db stuff...
        users = mutableListOf()
        teams = mutableListOf()
    }

    //...
}
