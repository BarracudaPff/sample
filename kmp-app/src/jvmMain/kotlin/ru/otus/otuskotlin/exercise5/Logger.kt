package ru.otus.otuskotlin.exercise5

import kotlinx.coroutines.delay

actual class Logger actual constructor() {
    actual fun log(message: String) {
        println("JVM log: $message")
    }
}

actual class ApiService actual constructor() {
    actual suspend fun call(): String {
        delay(1000)
        return "JVM call"
    }
}