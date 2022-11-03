package ru.otus.otuskotlin.m3l2.ex7

open class Figure() {
    open fun area(): Int = throw RuntimeException("Мы переделаем это на следующем занятии")
}

class Rectangle(val width: Int, val height: Int) : Figure() {
    override fun area(): Int = width * height
}

class Square(val side: Int) : Figure() {
    override fun area(): Int = side * side
}

fun figureWithMaxSquare(a: Figure, b: Figure): Figure {
    return if (a.area() > b.area()) a else b
}

fun figureWithMaxSquareNaive(a: Figure, b: Figure): Figure {
    fun figureArea(a: Figure) : Int =
        when (a) {
            is Square -> a.area()
            is Rectangle -> a.area()
            else -> throw RuntimeException("Unknown figure")
        }

    return if (figureArea(a) > figureArea(b)) a else b
}

fun main() {
    val r = Rectangle(10, 20)
    val s = Square(15)
    println(figureWithMaxSquare(r, s))
}