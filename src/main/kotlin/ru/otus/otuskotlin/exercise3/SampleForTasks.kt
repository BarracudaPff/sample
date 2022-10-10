package ru.otus.otuskotlin.exercise3

import java.util.*

// Will not work in play.kotlinlang.org, but works in IDE
fun main() {
    val input = Scanner(System.`in`) // init scanner
    val a = input.nextInt() // read integer from console
    val b = input.nextInt() // read another integer from console

    val res = a + b // compute result

    println(res) // output result
}
