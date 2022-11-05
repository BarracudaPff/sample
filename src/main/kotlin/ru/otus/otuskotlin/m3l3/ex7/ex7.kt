package ru.otus.otuskotlin.m3l3.ex7

class Scheduler {
    fun executeLater(task: Task) {
        task.invokeAndCatch()
    }
}

fun interface Task {
    fun invoke()

    fun invokeAndCatch() {
        try {
            invoke()
        } catch (e: Exception) {
            println(e)
        }
    }
}

fun main() {
    val s = Scheduler()
    val t = Task { println("Hello") }
    t.invoke()

    s.executeLater { println("Hello from lamdba") }

    s.executeLater(object : Task {
        override fun invoke() {
            println("Hello from object")
        }

        override fun invokeAndCatch() {
            invoke()
        }
    })
}