package ru.otus.otuskotlin.m3l4.ex4

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    //override fun apply(t: Int, u: Int): Int = TODO("Not realized")
    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
}

fun main() {
    val operator: IntBinaryOperator = IntArithmetics.PLUS

    println(operator.applyAsInt(10, 20))
}