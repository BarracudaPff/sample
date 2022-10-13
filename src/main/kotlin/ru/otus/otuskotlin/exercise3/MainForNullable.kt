package ru.otus.otuskotlin.exercise3

fun main() {
    val myVariable: String = "One line"

    println(myVariable)
    println(myVariable.length)

    /////////

    var myNewLine: String? = null

    println(myNewLine)
    println(myNewLine?.length)
    myNewLine = "one two three"
    println(myNewLine?.length)
    myNewLine = null
    println(myNewLine?.length)

    var myLine: String? = null
//    println(myLine!!.length) // error

    println(myLine?.length ?: -1)
    myLine = "12345"
    println(myLine?.length ?: -1)
}
