package ru.otus.otuskotlin.m3l2.ex6

open class Figure

class Rectangle: Figure()

class Square: Figure()

fun main() {
    var s: Square = Square()
    var r: Rectangle = Rectangle()
    var f: Figure = Figure()
    var a: Any = Any()
    f = s
    f = r // 1
    a = f
    a = r
    r = f // работает за счет "смарт-каста" в строке 1
    r = f as Rectangle

    println(f is Rectangle)
}