package ru.otus.otuskotlin.m3l2.ex4

open class Base {
    var x = someFunc()
    var y = 5

    init {
        println("Base ()")
        printVars()
    }

    private fun someFunc(): Int {
        println("Base x init")
        printVars()
        return 42
    }

    fun printVars() {
        this as Derived
        println("  x=$x, y=$y, q=$q, w=$w, s=$s")
    }
}

class Derived : Base() {
    var q = someFunc()
    var w = 5
    val s: String? = "Hello"

    init {
        println("Derived ()")
        printVars()
    }

    private fun someFunc(): Int {
        println("Derived q init")
        printVars()
        return 42
    }
}

fun main() {
    Derived()
}
