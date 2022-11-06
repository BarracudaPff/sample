package ru.otus.otuskotlin.m3l4.ex6

class X(val n: Int = 42) {
    operator fun component1() = n
    operator fun component2() = "Hello"
}


fun main() {
    val (num, str) = X()
    println("$num $str")

    listOf(X(1), X(2)).forEach { (num, str) -> println("$num $str") }

    val map = mapOf(1 to "A", 2 to "B")
    map.forEach { (no, str) -> println("$no $str") }

    for ((no, str) in map) {
        println("$no $str")
    }
}
