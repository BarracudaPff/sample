package ru.otus.otuskotlin.exercise5

class JVMSpec {

    @JvmName("customFoo")
    fun foo(): String {
        return "sample"
    }
}