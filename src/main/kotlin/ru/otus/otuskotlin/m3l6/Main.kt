package ru.otus.otuskotlin.m3l6

class User(
    val id: Int,
    val name: String,
    val phone: String,
)

class AdminNotificationService {
    fun sendNotification(user: User) {
        println("Sending notification...")
    }
}

class AdminUserService {
    fun deleteUser(user: User) {
        println("Deleting user...")
    }

    fun updateUser(user: User) {
        println("Update user...")
    }
}
