package ru.otus.otuskotlin.m5l3.ex2

import org.junit.jupiter.api.Test

internal class Map {
    @Test
    fun create() {
        val m1 = mapOf("Vasya" to 123, "Petya" to 341)
        val m2 = mutableMapOf("Vasya" to 123, "Petya" to 341)
        val m3 = mutableMapOf<String, Int>()

        println(m1)
        println(m2)
        println(m3)
    }

    @Test
    fun use() {
        val m1 = mapOf("Vasya" to 123, "Petya" to 341)
        val m2 = mutableMapOf("Vasya" to 123, "Petya" to 341)
        val m3 = mutableMapOf<String, Int>()

        println(m1["Vasya"])
        println(m1["Stepa"])

        m2["Stepa"] = 42
        println(m2["Stepa"])

        m3.putAll(m2)
        println(m3)
    }
}