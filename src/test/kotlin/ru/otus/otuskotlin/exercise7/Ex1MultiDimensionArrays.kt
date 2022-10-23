package ru.otus.otuskotlin.exercise7

import kotlin.test.Test
import kotlin.test.assertEquals

internal class Ex1MultiDimensionArrays {
    @Test
    fun createArray() {
        val a = Array(2) { row ->
            Array(if (row == 0) 2 else 3) { "" }
        }
        a[0][0] = "Hello"
        a[0][1] = "World"
        a[1][0] = "a"
        a[1][1] = "b"
        a[1][2] = "c"

        println(a.contentDeepToString())
    }

    private fun printArray(a: Array<IntArray>): String {
        // верните строку с содержимым этого массива, выполнив итерацию вручную, без использования contentToString
        // результат должен быть примерно таким
        // 10 11 12 13 14 15
        // 20 21 22 23 24 25
        // 30 31 32 33 34 35
        return "not realized"
    }

    @Test
    fun iterate() {
        val a = Array(3) { row -> IntArray(5) { col -> (row + 1) * 10 + col } }
        println(printArray(a))
        assertEquals(
            """
            10 11 12 13 14
            20 21 22 23 24
            30 31 32 33 34
            """.trimIndent(), printArray(a)
        )

        val b = Array(3) { row -> IntArray(2 + row) { col -> (row + 1) * 10 + col } }
        println(printArray(b))
        assertEquals(
            """
            10 11
            20 21 22
            30 31 32 33
            """.trimIndent(), printArray(b)
        )

    }


}