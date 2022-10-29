package ru.otus.otuskotlin.exercise9
import java.time.LocalDate

fun someMethod(a: Int): (Int) -> Int {
    return { a + it }
}

fun otherMethod(a: Int): Any {
    class Inner {
        override fun toString() = "a: $a"
    }

    return Inner()
}

fun main() {
    val func = someMethod(10)
    println(func(5))

    val obj = otherMethod(15)
    println(obj)
}