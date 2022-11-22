package ru.otus.otuskotlin.m4l1

fun main() {
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val mul: (Int, Int) -> Int = { x, y -> x * y }
    val div: (Int, Int) -> Int = { x, y -> x / y }
    val minus: (Int, Int) -> Int = { x, y -> x - y }

    val numA = 123
    val numB = 321

    var operations = listOf(sum, mul, div, minus)
    operations = operations.shuffled()

    for (operation in operations) {
        computeOperation(numA, numB, operation) // operation(numA, numB)
    }
}

fun computeOperation(a: Int, b: Int, op: (Int, Int) -> Int) {
    val res = op(a, b)
    println(res)
}
