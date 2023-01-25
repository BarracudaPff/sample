package services.db

import User
import db.DbConnector

class UserDbService {
    suspend fun getAll(): List<User> {
        // select * from users
        return DbConnector.users
    }

    suspend fun getById(id: String): User? {
        return DbConnector.users.find { it.id == id }
    }

    suspend fun store(user: User): User {
        DbConnector.users.add(user)
        return user
    }

    suspend fun delete(id: String) {
        DbConnector.users.removeIf { it.id == id }
    }
}
