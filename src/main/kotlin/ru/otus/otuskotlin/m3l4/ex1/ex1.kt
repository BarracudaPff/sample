package ru.otus.otuskotlin.m3l4.ex1

class SomeComplexClass {
    private val property = 42

    private fun doSomething(): Entry = Entry(this)

    fun f() {
        doSomething().g()
        //doSomething().nestedProperty
    }

    private class Entry(val sc: SomeComplexClass) {
        private val nestedProperty = 42
        fun g() {
            println(sc.property)
        }
    }

    data class Nested(val i: Int)
}

fun main() {
    val complex = SomeComplexClass()
    complex.f()

    val nested = SomeComplexClass.Nested(42)

}