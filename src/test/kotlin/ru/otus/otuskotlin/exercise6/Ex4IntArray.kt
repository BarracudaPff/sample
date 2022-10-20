package ru.otus.otuskotlin.exercise6

import org.junit.jupiter.api.Test

internal class Ex4IntArray {
    @Test
    fun createAndMethods() {
        val a = intArrayOf(1, 2, 42, 333)

        println(a)
        println(a.contentToString())

        a[2] = 3
        println(a[2])
        println(a.size)

        try {
            val c = a[10]
        } catch (e: Exception) {
            println(e)
        }
    }

    @Test
    fun createDynamic() {
        val a = IntArray(5) {
            it + 100
        }

        println(a.contentToString())

        val b = IntArray(5)
        println(b.contentToString())
    }

    @Test
    fun changeSize() {
        val a = intArrayOf(1, 2, 42, 333)

        val b = a.copyOf(5)
        b[4] = 444;

        println(a.contentToString())
        println(b.contentToString())
    }

    @Test
    fun createStringArray() {
        val a = arrayOf("Hello", "world")

        println(a.contentToString())

        a[0] = "Goodbye"
        println(a.contentToString())
    }

    @Test
    fun iteration() {
        val a = intArrayOf(1, 2, 42, 333)

        for (e in a)
            println(e)

        a.forEach { println(it) }
        a.forEachIndexed { i, e -> println("a[$i] = $e") }

        var i = 0
        while (i < a.size) {
            println("a[$i] = ${a[i]}")
            i += 1
        }

        for ((i, e) in a.withIndex())
            println("a[$i] = $e")

        val iterator = a.iterator()
        while (iterator.hasNext())
            println(iterator.nextInt())
    }
}