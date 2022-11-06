package ru.otus.otuskotlin.m3l4.ex8

import kotlin.random.Random

class MappedState(
    state: MutableMap<String, String>
) {
    val id by state
    var name by state
    var description by state
}

class RandomInt {
    val value by lazy {
        println("value inited")
        Random.nextInt()
    }
}

fun main() {
    val map = mutableMapOf("id" to "42")
    val state = MappedState(map)
    println(state.id)
    state.name = "John"
    println(map)

    val random = RandomInt()
    println("Wa ere here")
    println(random.value)

}
