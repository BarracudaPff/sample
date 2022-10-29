package ru.otus.otuskotlin.exercise9

class Example7 {
    lateinit var some1: String
    var some2: String? = null

    fun set(x: String) {
        some1 = x
    }

    fun method() {
        println(some1)
        println(some2)
    }
}

fun main() {
    val e = Example7()
    //e.set("Hello")
    e.method()
}