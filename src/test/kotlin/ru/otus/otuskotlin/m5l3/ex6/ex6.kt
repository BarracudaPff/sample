package ru.otus.otuskotlin.m5l3.ex6

import org.junit.jupiter.api.Test

private data class User(
    val id: Int,
    val name: String,
    val course: Int,
)

private val users = listOf(
    User(3, "Vasya", 4),
    User(42, "Stepa", 3),
    User(24, "Petya", 1),
    User(64, "Sergey", 3),
    User(3, "Kolya", 3),
)

internal class OperationsTest {
    @Test
    fun get() {
        val m = mutableMapOf("aa" to 1, "ea" to 5, "ba" to 2, "cc" to 3, "dd" to 4)

        println("aa= " + m["aa"])
        println("xx= " + m["xx"])
        println("yy= " + m.getOrDefault("yy", "default"))
        println("vv= " + m.getOrElse("vv") {
            println("some computation")
            42
        })

        println("nn= " + m.getOrPut("nn") {
            64
        })
        println("nn next attempt= " + m["nn"])

        m.remove("aa")
        println("m after remove aa= $m")
    }

    @Test
    fun plus() {
        var a = mapOf(1 to 10, 2 to 20)
        val b = mapOf(1 to 11, 3 to 31)
        val c = a + b // 1 to 11, 2 to 20, 3 to 31
        val d = a + (3 to 31) // 1 to 10, 2 to 20, 3 to 31
        val m = mutableMapOf(1 to 10, 2 to 20)

        println(c)
        println(d)

        a += 1 to 2
        m += 1 to 2
    }

    @Test
    fun minus() {
        var a = mapOf(1 to 10, 2 to 20, 3 to 31)
        val b = a - 1
        val c = a - setOf(2, 3, 4)

        a -= 1

        val m = mutableMapOf(1 to 10, 2 to 20, 3 to 30)
        m -= 1
        println("m remove 3: " + m.remove(3))
        println("m remove 4: " + m.remove(4))

        println(a)
        println(b)
        println(c)
        println(m)
    }

    @Test
    fun associate() {
        val a: Map<Int, String> = users.associate { it.id to it.name }
        val b: Map<Int, User> = users.associateBy { it.id }
        val c: Map<Int, String> = users.associateBy({ it.id }, { it.name.lowercase() })
        val d: java.util.HashMap<Int, User> = users.associateByTo(HashMap()) { it.id }

        val e: Map<Int, User> = users.associateBy { it.course } // повторяющиеся ключи - останется последний
        println(e)
    }

    @Test
    fun grouping() {
        val a: Map<Int, List<User>> = users.groupBy { it.course }
        println("a: $a")

        val b: Map<Int, Int> = users.groupingBy { it.course }.eachCount()
        println("b: $b")

        val c = users
            .groupingBy { it.name.first() }
            .fold(0 to 0) { (sum, count), element -> // пара из (сумма, кол-во)
                (sum + element.course) to (count + 1)
            }
            .mapValues { it.value.first / it.value.second } // находим среднее
        println("c: $c")
    }
}