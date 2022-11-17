package ru.otus.otuskotlin.m3l5

import java.io.File

const val FILE_PATH = "src/main/kotlin/ru/otus/otuskotlin/m3l5/MainWithResult.kt"

fun main() {
    mainResultInsteadOfTryCatch()
    mainMultipleTryCatch()
}

fun mainResultInsteadOfTryCatch() {
    val res = Result.success(
        File(FILE_PATH)
    ).mapCatching { file ->
        file.readText()
    }.onFailure {
        println("Exception is failed")
    }.getOrNull()

    println(res)
}

fun mainMultipleTryCatch() {
    val text = try {
        File(FILE_PATH).readText()
    } catch (e: Exception) {
        "custom text"
    }

    val line3 = try {
        text.lines()[2]
    } catch (e: Exception) {
        "custom line"
    }

    val result = try {
        line3.take(10)
    } catch (e: Exception) {
        "custom result"
    }
}