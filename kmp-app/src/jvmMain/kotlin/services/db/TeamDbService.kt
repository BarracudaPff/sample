package services.db

import Team
import db.DbConnector

class TeamDbService {
    suspend fun getAll(): List<Team> {
        // select * from users
        return DbConnector.teams
    }

    suspend fun getById(id: String): Team? {
        return DbConnector.teams.find { it.id == id }
    }

    suspend fun store(user: Team): Team {
        DbConnector.teams.add(user)
        return user
    }

    suspend fun delete(id: String) {
        DbConnector.teams.removeIf { it.id == id }
    }
}
