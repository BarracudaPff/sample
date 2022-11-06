package ru.otus.otuskotlin.m3l4.ex5

import java.math.BigDecimal

fun main() {
    val a = BigDecimal("10")
    val b = BigDecimal("20")
    val c = BigDecimal("30")

    println(a.add(b).multiply(c))

    println((a + b) * c)
}