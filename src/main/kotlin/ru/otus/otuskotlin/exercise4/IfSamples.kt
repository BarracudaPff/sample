package ru.otus.otuskotlin.exercise4

fun main() {
    val a = 10
    val b = 12

    var max1 = a
    if (a < b) max1 = b
    println(max1)

    // With else
    var max2: Int
    if (a > b) {
        max2 = a
    } else {
        max2 = b
    }
    println(max2)

    // As expression
    val max3 = if (a > b) a else b
    println(max3)

    val max4 = if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }
    println(max4)
}
