package ru.otus.otuskotlin.exercise5

import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.dom.appendText
import kotlinx.coroutines.delay

fun main() {
    window.onload = {
        val span = document.createElement("span")
        span.appendText("Hello World!")

        document.body?.appendChild(span)
    }
}

actual class Logger {
    actual fun log(message: String) {
        console.log("LOGGING: $message")
    }
}

actual class ApiService actual constructor() {
    actual suspend fun call(): String {
        delay(1000)
        return "JS call"
    }
}
