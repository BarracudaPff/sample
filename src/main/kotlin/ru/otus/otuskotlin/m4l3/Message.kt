package ru.otus.otuskotlin.m4l3

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun getMessage(): String {
    return getMessage("my friend")
}

fun getMessage(name: String): String {
    val prefix = "Hello".let {
        if (name.uppercase() == name) it.uppercase() else it
    }

    return "$prefix, $name!"
}

fun getMessage(vararg name: String): String {
    return getMessage(name.joinToString(", "))
}

fun currentDate(): String {
    return LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME).also {
        println(it)
    }
}
