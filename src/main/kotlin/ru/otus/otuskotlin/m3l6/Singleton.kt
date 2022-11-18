package ru.otus.otuskotlin.m3l6

object Database {
    var isConnected = false
        private set

    fun connect() {
        if (isConnected) return
        isConnected = true

        println("Connected")
    }

//    companion object {
//        getInstance()
//    }
}

fun main() {
    val db = Database
    println(Database.isConnected)
    db.connect()
    println(db.isConnected)


    val db1 = Database

    println(db1.isConnected)
}
