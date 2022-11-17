package ru.otus.otuskotlin.m3l5.ex2

class DivideByZeroException(
    val value: Double
) : ArithmeticException("you can't divide $value by zero") {
    fun getMyValue(): Double {
        return value
    }
}

fun divide(a: Double, b: Double): Double {
    if (b < 0) throw NullPointerException()
    if (b == 0.0) throw DivideByZeroException(a)

    return a / b
}

fun main() {
    try {
        println(divide(1.0, -10.0))
    } catch (e: NullPointerException) {
        println("Custom null exception caught")
    } catch (e: ArithmeticException) {
        println("Custom arithmetic exception caught")
    } catch (e: Exception) {
        println("all exceptions")
    }


    println("".firstOrNull() ?: "No first element")
}
