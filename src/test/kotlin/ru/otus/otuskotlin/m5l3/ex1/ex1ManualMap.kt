package ru.otus.otuskotlin.m5l3.ex1

import org.junit.jupiter.api.Test

class ManualMap<K, V>(
    private val data: List<Pair<K, V>>
) : Map<K, V> {
    override val entries: Set<Map.Entry<K, V>>
        get() = TODO("Not yet implemented")
    override val keys: Set<K>
        get() = TODO("Not yet implemented")
    override val size: Int
        get() = data.size
    override val values: Collection<V>
        get() = TODO("Not yet implemented")

    override fun containsKey(key: K) = data.any { it.first == key }

    override fun containsValue(value: V) = data.any { it.second == value }

    override fun get(key: K): V? = data.find {it.first == key }?.second

    override fun isEmpty() = data.isEmpty()
}

internal class ManualMapTest {
    @Test
    fun test() {
        val map = ManualMap(listOf("Vasya" to 123456, "Petya" to 654321))
        println(map["Vasya"])
        println(map["Stepa"])
        println("Petya" in map)
    }
}