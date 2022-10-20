package ru.otus.otuskotlin.exercise6

import org.junit.jupiter.api.Test

internal class Ex5List {
    @Test
    fun create() {
        val a = listOf(1, 2, 42)
        val b = buildList {
            add("Hello")
            add("world")
            set(0, "Goodbye")
            add(1, "cruel")
        }

        println(a)
        println(b)
    }

    @Test
    fun operations() {
        val a = listOf("Hello", "world")

        println(a)

        //a[0] = "goodbye"
        val w = a[1]
        val s = a.size

        println(a.size)
        println(a.all { it.length > 5 })
        println(a.any { it.contains("orld") })
        println(a.drop(1))
        println(a.dropLast(1))
        println(a.take(1))
        println(a.filter { it.length > 5 })
        println(a.find { it == "hello" })
        println(a.contains("hello"))
        println(a.getOrElse(3) { "unknown" })
    }


    @Test
    fun iteration() {
        val a = listOf(1, 2, 42, 333)

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
            println(iterator.next())
    }
}