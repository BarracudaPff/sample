package ru.otus.otuskotlin.m3l3.ex1

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

open class Figure {
    open fun area(): Int = throw RuntimeException()
}

class Square(val side: Int): Figure() {
    override fun area(): Int {
        return side * side
    }
}

class Rectangle(val height: Int, val width: Int): Figure() {
    override fun area(): Int {
        return width * height
    }
}

fun areaDiff(a: Figure, b: Figure) = a.area() - b.area()


class Ex1Test {
    // задание 1 - сделайте Figure и Figure.area abstract
    @Test
    fun polymorphism() {
        val r: Figure = Rectangle(10, 20)
        val s: Figure = Square(10)
        assertTrue { r is Figure }
        assertFalse { r is Square }
        assertEquals(r.area(), 200)
        assertEquals(s.area(), 100)
        assertEquals(areaDiff(r, s), 100)
    }
}