package ru.otus.otuskotlin.m3l4.ex9

import kotlin.reflect.KFunction0
import kotlin.reflect.KProperty0

data class Vector2D(val x: Int, val y: Int) {
}

fun main() {
    val vector = Vector2D(10, 20)
    println(vector::class.members.forEach { println(it) })

    println("----")

    val toString: KFunction0<String> = vector::toString
    println(toString.name)
    println(toString.invoke())

    println("----")

    val x: KProperty0<Int> = vector::x
    println(x.name)
    println(x.get())
}