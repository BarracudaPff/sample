package ru.otus.otuskotlin.m3l3.ex8.a

sealed interface Figure

class Rectangle : Figure

open class Square : Figure

//class Circle : Figure

fun main() {
    val f: Figure = Rectangle()
    val x = when (f) {
        is Rectangle -> 1
        is Square -> 2
        // else -> -1
    }
}

