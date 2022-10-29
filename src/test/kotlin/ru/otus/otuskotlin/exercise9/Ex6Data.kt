package ru.otus.otuskotlin.exercise9

import kotlin.test.Test

data class Point(val x: Int, val y: Int)

class PointTest {
    @Test
    fun test1() {
        val p1 = Point(1, 2)
        val p2 = Point(1, 2)
        println(p1)
        println(p1 == p2)

        val p3 = p1.copy(y = 10)
        println(p3)

        val (x, y) = p1
        println("x=$x y=$y")
    }
}