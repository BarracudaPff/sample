package ru.otus.otuskotlin.m4l3

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

fun power(a: Int, b: Int): Int {
    var sum = 1
    for (i in 0 until b) {
        sum *= a
    }
    return sum
}

class JunitParamsTestCase {
    @ParameterizedTest
    @MethodSource("numbers")
    fun `simple test`(a: Int, b: Int, result: Int) {
        val actual = power(a, b)
        Assertions.assertEquals(result, actual)
    }

    companion object {
        @JvmStatic
        fun numbers(): List<Arguments> {
            return listOf(
                Arguments.of(1, 1, 1),
                Arguments.of(2, 2, 4),
                Arguments.of(0, 8, 0),
                Arguments.of(10, 3, 1000),
                Arguments.of(-1, 4, 1),
                Arguments.of(-1, 4, 1),
                Arguments.of(-1, 4, 1),
                Arguments.of(-1, 4, 1),
            )
        }
    }
}
