package ru.otus.otuskotlin.m4l4

data class BigNumber(val x: Double)

operator fun BigNumber?.plus(other: BigNumber?): BigNumber {
    val a = this?.x ?: 0.0
    val b = other?.x ?: 0.0

    return BigNumber(a + b)
}

fun main() {
    println(
        BigNumber(1.0) + BigNumber(2.0)
    )

//    val str1: String = null + null
//    val str2: BigNumber = null + null

    println(null)
    println(null + null)
}
