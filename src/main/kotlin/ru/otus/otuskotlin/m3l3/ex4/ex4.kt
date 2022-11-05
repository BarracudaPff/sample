package ru.otus.otuskotlin.m3l3.ex4

interface Sum {
    val result: Long
    fun add(summand: Long)

    fun addAll(summands: Iterable<Long>) {
        summands.forEach { add(it) }
    }
}

class DefaultSum : Sum {
    override var result: Long = 0L
        private set

    override fun add(summand: Long) {
        result += summand
    }
}

fun main() {
    val s: Sum = DefaultSum()
    s.add(42)
    s.addAll(listOf(10, 20, 30))
    println(s.result)
}
