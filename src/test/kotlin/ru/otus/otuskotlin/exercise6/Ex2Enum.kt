package ru.otus.otuskotlin.exercise6

import org.junit.jupiter.api.Test

enum class Level {
    HIGH,
    MIDDLE,
    LOW,
    //OFF,
}

internal class Ex2Enum {
    @Test
    fun enumExample() {
        var level = Level.HIGH;
        println(level)

        when(level) {
            Level.HIGH -> println("high level")
            Level.MIDDLE -> println("middle level")
            Level.LOW -> println("low level")
        }

        when(level) {
            Level.LOW -> println("low level")
            else -> println("other level")
        }

        if (level != Level.HIGH)
            println("OMG")

    }

    @Test
    fun nullable() {
        var level: Level? = Level.HIGH;
        println(level)

        level = null

        when(level) {
            Level.HIGH -> println("high level")
            Level.MIDDLE -> println("middle level")
            Level.LOW -> println("low level")
            null -> println("null")
        }
    }

    @Test
    fun methods() {
        var level = Level.valueOf("MIDDLE");
        println(level)
        println(level.ordinal)

        try {
            level = Level.valueOf("UNKNOWN");
        } catch (e : Exception) {
            println(e)
        }

        println(Level.values().contentToString())
        println(Level.values()[1])
    }
}