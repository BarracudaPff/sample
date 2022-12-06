package ru.otus.otuskotlin.m5l1

class BinaryNode<T>(val value: T) {
    var left: BinaryNode<T>? = null
    var right: BinaryNode<T>? = null
}

fun <T : Comparable<T>> BinaryNode<T>.add(value: BinaryNode<T>) = add(value.value)

fun <T : Comparable<T>> BinaryNode<T>.add(value: T) {
    if (value > this.value) {
        if (this.right == null) {
            this.right = BinaryNode(value)
        } else {
            this.right!!.add(value)
        }
    } else if (value < this.value) {
        if (this.left == null) {
            this.left = BinaryNode(value)
        } else {
            this.left!!.add(value)
        }
    }
}

fun <T> BinaryNode<T>.visit(): List<T> {
    val left = left?.visit() ?: emptyList()
    val right = right?.visit() ?: emptyList()

    return left + listOf(value) + right
}

fun main() {
    val node4 = BinaryNode(4)
    val node1 = BinaryNode(1)
    val node2 = BinaryNode(2)
    val node6 = BinaryNode(6)
    val node5a = BinaryNode(5)
    val node3 = BinaryNode(3)
    val node5b = BinaryNode(5)

    node4.apply {
        add(node2)
        add(node1)
        add(node5b)
        add(node6)
        add(node5a)
        add(node3)
    }

    println(node4.visit())
}
