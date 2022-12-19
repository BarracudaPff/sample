package ru.otus.otuskotlin.m5l3

import java.util.LinkedList

data class Node(val value: Int, val siblings: ArrayList<Node?> = ArrayList())

val nodes = mutableListOf<Node>()

fun bfs(node: Node?): Node? {
    if (node == null) return null

    val queue = LinkedList<Node>()
    queue.offer(node)

    val temp = Node(node.value)
    val map = hashMapOf(node to temp)

    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            var curent = queue.poll()

            curent.siblings.forEach {
                if (it != null) {
                    if (map[it] == null) {
                        map[it] = Node(it.value)
                        queue.offer(it)
                    }

                    map[curent]?.siblings?.add(map[it])
                }
            }
        }
    }

    return temp
}

fun main() {
//    val node1 = Node(1, null).also { nodes.add(it) }
//    val node2 = Node(2, node1).also { nodes.add(it) }
//    val node3 = Node(3, node2).also { nodes.add(it) }
//    val node4 = Node(4, node3).also { nodes.add(it) }
//    val node5 = Node(5, node1).also { nodes.add(it) }
//    val node6 = Node(6, node5).also { nodes.add(it) }
//    val node7 = Node(7, node6).also { nodes.add(it) }
//    val node8 = Node(8, node5).also { nodes.add(it) }
//    val node9 = Node(9, node1).also { nodes.add(it) }
//    val node10 = Node(10, node9).also { nodes.add(it) }


}
