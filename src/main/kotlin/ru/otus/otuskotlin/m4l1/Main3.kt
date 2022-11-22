package ru.otus.otuskotlin.m4l1

class User(
    var name: String,
    var email: String,
    var age: Int
) {
    fun printAge() {
        println("User $name's age is $age")
    }

//    fun isGmail(): Boolean {
//
//    }
}

fun User.isGmail(): Boolean {
    return this.email.endsWith("@gmail.com")
}

// this - rudiment
fun main() {
    val user = User("Petya", "petya@gmail.com", 32).apply {
        email = "sample@email.com"
        name = "NewPetya"
        age = 42
    }

    user.printAge()

    println(user.isGmail())

    val isYandex: User.() -> Boolean = {
        this.email.endsWith("@yandex.ru")
    }

    val isCustomMail: User.(mailDomain: String) -> Boolean = {
        this.email.endsWith("@$it")
    }

    println(user.isYandex())
    println(user.isCustomMail("mail.ru"))
    println(user.isCustomMail("yahoo.com"))

    user.apply {
        this.email = "sample@email.com"
    }
}
