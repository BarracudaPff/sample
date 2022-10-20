package ru.otus.otuskotlin.exercise6

import org.junit.jupiter.api.Test

enum class RGB(val code: Int, val colorName: String? = null, var counter: Int = 0) {
    RED(0xFF0000, "red"),
    BLACK (0x000000, "black"),
    SOME_STRANGE(0x1122FF),
    ;
}

fun getRGBByColorName(name: String): RGB? {
    for (e in RGB.values())
        if (e.colorName == name) return e
    return null
}

internal class Ex3Enum {
    @Test
    fun example() {
        println(getRGBByColorName("red"))

        println(RGB.RED.code)

        RGB.RED.counter += 42 // так обычно не делают, хранят только константы
        println(RGB.RED.counter)
        println(RGB.BLACK.counter)
    }
}