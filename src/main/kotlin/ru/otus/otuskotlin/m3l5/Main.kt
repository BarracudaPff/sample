package ru.otus.otuskotlin.m3l5

import java.io.File

fun divide(a: Double, b: Double): Double {
    return a / b
}

fun findLetter(line: String, letter: Char): Char {
    val indexOfLetter = line.indexOf(letter)

    return try {
        line[indexOfLetter]
    } catch (e: Exception) {
        println("Can't find such index")
        '-'
    }
}

fun main() {
//    val string = "Some line"
//    val char = 'w'
//
//    println(findLetter(string, char))

    val file = File("/Users/Kirill.Krylov/IntelliJRepository/202209-okb-exercises/text1.text")

    try {
        val text = file.readText()
        println("text len: ${text.length}")
    } catch (e: Exception) {
        println("Text is not found")
        e.printStackTrace()
    } finally {
        println("File is closing...")
    }

    println("Exit")
}
