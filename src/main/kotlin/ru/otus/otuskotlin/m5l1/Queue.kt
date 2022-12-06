package ru.otus.otuskotlin.m5l1

interface Queue<T> {
    val size: Int
        get

    fun add(element: T)

    fun remove(): T
}

open class ListQueue<T> : Queue<T> {
    protected val list = mutableListOf<T>()

    override val size
        get() = list.size

    override fun add(element: T) {
        list.add(element)
    }

    override fun remove(): T {
        return list.removeAt(0)
    }

    override fun toString(): String {
        return list.toString()
    }
}

class Stack<T> : ListQueue<T>() {
    override fun remove(): T {
        return list.removeLast()
    }
}

fun main() {
    val queue = Stack<Int>()

    queue.add(3).also { println(queue) }
    queue.add(5).also { println(queue) }
    queue.remove().also { println(queue) }
    queue.add(8).also { println(queue) }
    queue.add(6).also { println(queue) }
    queue.add(3).also { println(queue) }
    queue.remove().also { println(queue) }
    queue.add(-3).also { println(queue) }
    queue.remove().also { println(queue) }
    queue.remove().also { println(queue) }
    queue.remove().also { println(queue) }
}
