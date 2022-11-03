package ru.otus.otuskotlin.m3l2.ex2

open class Figure(
    var x: Int = 0,
    var y: Int = 0)

class Rectangle(val width: Int, val height: Int) : Figure() {
    fun area(): Int = width * height
}

class Square(val side: Int) : Figure() {
    fun area(): Int = side * side
}

fun main() {
    val r = Rectangle(10, 20)
    r.x = 10

    val s = Square(5)
    s.x = 20
    println(r.x)
    println(s.x)
}