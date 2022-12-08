package ru.otus.otuskotlin.m5l3.ex5

import org.junit.jupiter.api.Test

internal class ViewTest {
    @Test
    fun view() {
        val m = mutableMapOf("aa" to 1, "ea" to 5, "ba" to 2, "cc" to 3, "dd" to 4)
        val entries = m.entries
        val keys = m.keys
        println(entries)

        entries.removeIf { it.key == "aa"}
        println("map after remove: $m")
        println("keys after remove: $keys")

        m["xx"] = 42
        println("entries after insert: $entries")
        println("keys after insert: $keys")
    }
}