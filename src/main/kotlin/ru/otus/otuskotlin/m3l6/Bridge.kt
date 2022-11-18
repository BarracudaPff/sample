package ru.otus.otuskotlin.m3l6

interface Color {
    val cssValue: String
}

class Yellow : Color {
    override val cssValue = "yellow"
}

class Red : Color {
    override val cssValue = "red"
}

interface Shape {
    val color: Color
    val type: String
}

class Circle(override val color: Color) : Shape {
    override val type = "circle"
}

class Rectangle(override val color: Color) : Shape {
    override val type = "rectangle"
}

fun main() {
    val redCircle = Circle(Red())
    val yellowCircle = Circle(Yellow())
    val yellowRectangle = Rectangle(Yellow())

    println(redCircle.color.cssValue)
    println(redCircle.type)
}
