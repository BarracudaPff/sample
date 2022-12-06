package ru.otus.otuskotlin.m5l1

data class Node<T>(
    val data: T,
    var next: Node<T>? = null
) {
    override fun toString(): String {
        return if (next != null) {
            "$data -> $next"
        } else {
            "$data"
        }
    }
}

class LinkedList<T> {
    var size = 0
    var head: Node<T>? = null
    var tail: Node<T>? = null

    override fun toString(): String {
        return head.toString()
    }

    fun add(value: T) {
        head = Node(value, next = head)
        if (tail == null) tail = head
        size++
    }
}

fun main() {
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)

    node1.next = node2
    node2.next = node3

    val list = LinkedList<Int>()
    list.add(3)
    list.add(2)
    list.add(1)

    println(list)

    val first = list.head?.data

    list.head // O(1)
    list.tail // O(1)
//    list.add(3.5, index = 2) // O(1)
}