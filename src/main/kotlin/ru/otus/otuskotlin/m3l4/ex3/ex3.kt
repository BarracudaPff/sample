package ru.otus.otuskotlin.m3l4.ex3

fun f(a: Int) : Iterable<Int> {
    val list = listOf(1, 2, 3, 42)

    class Local(b: Int): Iterable<Int> {
        private val updated = buildList {
            addAll(list)
            add(a)
            add(b)
        }

        override fun iterator() = updated.iterator()
    }

    val local1 = Local(10)
    val local2 = Local(20)
    return if (a < 5) local1 else local2
}

fun g(it: Iterator<Int>) {
    it.forEach { println(it) }
}

fun h() {
    val a = 42
    g(object: Iterator<Int> {
        var hasNext = true;
        override fun hasNext() = if (hasNext) {
            hasNext = false
            true
        } else false

        override fun next() = a
    })
}

fun main() {
    val result = f(60)
    println(result::class)
    println(result.joinToString { it.toString() })

    h()
}