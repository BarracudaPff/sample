package ru.otus.otuskotlin.exercise5

data class User(
    val id: String,
    val name: String,
    val age: Int,
)

class Service {
    fun doSmth() {
        println("Doing...")
    }
}

expect class Logger() {
    fun log(message: String)
}

expect class ApiService() {
    suspend fun call(): String
}
