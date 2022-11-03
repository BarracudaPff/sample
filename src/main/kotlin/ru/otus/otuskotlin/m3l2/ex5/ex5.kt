package ru.otus.otuskotlin.m3l2.ex5

class Figure(
    var x: Int = 0,
    var y: Int = 0)

class Rectangle(val width: Int, val height: Int) {
    private val figure = Figure()
    fun area(): Int = width * height

    var x by figure::x

    var y: Int
        get() = figure.y
        set(value) {
            figure.y = value
        }
}

class Square(val side: Int)  {
    private val figure = Figure()
    fun area(): Int = side * side

    var x by figure::x
    // var y by figure::y
}

fun main() {
    val r = Rectangle(10, 20)
    r.x = 10

    val s = Square(5)
    s.x = 20
    // s.y = 10
    println(r.x)
    println(s.x)
}