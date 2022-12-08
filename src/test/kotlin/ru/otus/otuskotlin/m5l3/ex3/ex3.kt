package ru.otus.otuskotlin.m5l3.ex3

import org.junit.jupiter.api.Test

data class MutableKey(var value: Int)

class BadHashKey(val a: Int, val b: Int) {
    override fun equals(other: Any?) = other is BadHashKey && other.a == a
    override fun hashCode() = a * 31 + b
}

internal class BadKeysTest {
    @Test
    fun mutableKey() {
        val k1 = MutableKey(10)
        val k2 = MutableKey(20)
        val m = mapOf(k1 to 20, k2 to 200)
        println(m[k1])

        k1.value = 22
        println(m[k1])
    }

    @Test
    fun badHashKey() {
        val k1 = BadHashKey(1, 2)
        val k2 = BadHashKey(10, 20)
        val k3 = BadHashKey(1, 5)
        val m = mapOf(k1 to 20, k2 to 200)
        println(m[k1])
        println(m[k3])
    }

}