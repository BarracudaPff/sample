package ru.otus.otuskotlin.exercise7

import kotlin.test.Test

internal class Ex2MultiDimensionLists {
    @Test
    fun createList() {
        val a = buildList {
            add(buildList {
                add("Hello")
                add("World")
            })
            add(buildList {
                add("a")
                add("b")
                add("c")
            })
        }

        println(a)
    }
}