package ru.otus.otuskotlin.m3l4.ex1

import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertEquals

data class Vector2D(val x: Int, val y: Int) {
}

internal class Vector2DTest {
    // Задание1 - реализуйте операторы, чтобы тесты ниже проходили
    // Можно консультироваться с https://kotlinlang.org/docs/operator-overloading.html
    @Test
    fun plus() {
        //assertEquals(Vector2D(10, 20), Vector2D(5, 15) + Vector2D(5, 5))
    }

    @Test
    fun unaryMinus() {
        //assertEquals(-Vector2D(10, -20), Vector2D(-10, 20))
    }

    @Test
    fun minus() {
        //assertEquals(Vector2D(10, 20), Vector2D(25, 15) - Vector2D(5, -5))
    }

    @Test
    fun times() {
        //assertEquals(Vector2D(10, 20), Vector2D(5, 10)  * 2)
    }

    @Test
    fun get() {
        /*val v = Vector2D(10, 20)
        assertEquals(10, v[0])
        assertEquals(20, v[1])*/
    }

    // КОНЕЦ задания 1

    // задание 2 - уберите data в Vector2D и реализуйте deconstruct
    @Test
    fun deconstruct() {
        val (x, y) = Vector2D(10, 20)
        assertEquals(10, x)
        assertEquals(20, y)
    }

}