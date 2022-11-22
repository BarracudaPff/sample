package ru.otus.otuskotlin.m4l1

import kotlin.math.abs

fun onlyPositiveValues(it: Int): Int {
    return if (it > 0) it else 0
}

fun main() {
    val numbers = listOf(
        1, 2, 5, -8, 2, 0, 6, 448, -3, 35,
    )

    println(numbers.first())
    println(numbers.first { it < 0 })
    println(numbers.count { it == 0 })
    println(numbers.sum()) // same v1
    println(numbers.sumOf { it }) // same v1
    println(numbers.sumOf { if (it > 0) it else 0 }) // same v2
    println(numbers.sumOf(::onlyPositiveValues)) // same v2
    println(numbers.sumOf { abs(it) })

//    println(numbers.sumOf(::onlyPositiveValues))
//    println(numbers.sumOf { onlyPositiveValues(it) })

    println("=".repeat(99))

//    numbers.forEach {
//        println(it)
//    }
//    numbers.forEach(::println)

    println(numbers.map { it > 0 })
    val res = numbers.let {
        it.max()
    }.let {
        it.takeIf { it > 0 }?.let {
            it * 2
        } ?: -1
    }

    println(res)
}
