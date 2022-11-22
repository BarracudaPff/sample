package ru.otus.otuskotlin.m4l1

// DO NOT!
fun main() {
    fun customFoo(): () -> () -> (a: Int, c: Int) -> () -> (b: Int) -> () -> Unit {
        return { { { a, c -> { { {} } } } } }
    }

    val res = customFoo()()()(3, 5)()(4)
}
