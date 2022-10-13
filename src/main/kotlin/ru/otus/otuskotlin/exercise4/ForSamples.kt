package ru.otus.otuskotlin.exercise4

fun main() {
    val inner = 2
    if (inner in 1..4) { // equivalent of i >= 1 && i <= 4
        print(inner)
    }
    println("===")

    for (i in 1..4) print(i)
    println("")
    for (i in 4 downTo 1) print(i)
    println("===")

    for (i in 1..8 step 2) print(i)
    println("")
    for (i in 8 downTo 1 step 2) print(i)
    println("===")

    for (i in 1 until 10) print(i)
    println("")
    for (i in (1..4).reversed()) print(i)
    println("===")
}
