package ru.otus.otuskotlin.m5l3.ex8

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test


internal data class Entry(
    var x: Int = 0,
    var y: Int = 0,
    var message: String? = null)

internal class SetTest {
    private val mapper = ObjectMapper()

    @Test
    fun readWriteSingle() {
        val str = mapper.writeValueAsString(Entry(1, 2, "Hello"))
        println(str)

        val obj = mapper.readValue(str, Entry::class.java)
        println(obj)

        val map = mapper.readValue(str, HashMap::class.java)
        println(map)
    }

    @Test
    fun readWriteArray() {
        val str = mapper.writeValueAsString(
            listOf(
                Entry(1, 2, "Hello"),
                Entry(3, 4, "world")))
        println(str)

        val arrOfObj = mapper.readValue(str, object : TypeReference<List<Entry>>() {})
        println(arrOfObj)

        val arr = mapper.readValue(str, ArrayList::class.java)
        println(arr)
    }

}