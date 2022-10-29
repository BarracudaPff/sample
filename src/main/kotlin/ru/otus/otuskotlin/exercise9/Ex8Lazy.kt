package ru.otus.otuskotlin.exercise9

fun someLongFun(): String {
    println("someLongFun")
    return "Hello world"
}

class Example8 {
    val someComplexString: String by lazy { someLongFun() }
}

fun main() {
    val e = Example8()
    println("Get someComplexString")
    println(e.someComplexString)

}