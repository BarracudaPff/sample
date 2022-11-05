package ru.otus.otuskotlin.m3l3.ex4

interface Test {
    var result: Long
        get() = 42
        set(value) {
            println("setted $value")
        }
}
