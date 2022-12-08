package ru.otus.otuskotlin.m5l3.ex9

import org.junit.jupiter.api.Test
import java.util.*

internal class TreeMapTest {
    @Test
    fun create() {
        val m1: Map<String, Int> = TreeMap<String, Int>().apply {
            put("Vasya", 123)
            put("Petya", 341)
            put("Astra", 222)
        }

        println(m1)
    }

}