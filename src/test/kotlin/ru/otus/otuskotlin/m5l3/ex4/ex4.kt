package ru.otus.otuskotlin.m5l3.ex4

import org.junit.jupiter.api.Test

internal class OrderTest {
    @Test
    fun order() {
        val m = mapOf("aa" to 1, "ea" to 5, "ba" to 2, "cc" to 3, "dd" to 4)
        m.forEach { (k, v) ->
            println("$k: $v")
        }
    }

    @Test
    fun noOrder() {
        val m = hashMapOf("aa" to 1, "ea" to 5, "ba" to 2, "cc" to 3, "dd" to 4)
        m.forEach { (k, v) ->
            println("$k: $v")
        }
    }
}