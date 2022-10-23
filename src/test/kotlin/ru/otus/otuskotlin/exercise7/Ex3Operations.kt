package ru.otus.otuskotlin.exercise7

import kotlin.test.Test

internal class Ex3Operations {
    @Test
    fun example() {
        val a = listOf("Hello", "beautiful", "world", "42")

        val b = a
            .filter { it.toIntOrNull() == null }
            .map { it.uppercase() }
            .joinToString(" ")

        println(b)

        val m = StringBuilder()
        a.forEach { e ->
            if (e.toIntOrNull() == null) {
                if (!m.isEmpty()) m.append(' ')
                m.append(e.uppercase())
            }
        }
        println(m.toString())
    }

    @Test
    fun map() {
        val a = listOf("Hello", "beautiful", "world", "42")

        println(a.map { it.uppercase() })

        println(a.map { "world: $it" })

        println(a.map { it.toIntOrNull() })

        val b: List<Any> = a.map { it.toIntOrNull() ?: it }
        println(b)
        println(b[0].javaClass)
        println(b[3].javaClass)

        println(a.mapNotNull { it.toIntOrNull() })

    }

    @Test
    fun zip() {
        val a = listOf("Hello", "beautiful", "world", "42")
        val b = listOf(1, 2, 3, 4, 5)

        println(a.zip(b))

        println(a zip b)

        println(a.zip(b) { s, n -> "$s:$n" })
    }

    @Test
    fun flatten() {
        val a = listOf(listOf(1, 2), listOf(3, 4))
        println(a.flatten())
    }

    @Test
    fun flatMap() {
        val a = listOf(
            "Дойл" to listOf("Приключения Шеллока", "Собака Баскервилей"), // a to b = Pair(a, b)
            "Кристи" to listOf("Эркюль Пуаро", "Мисс Марпл")
        )

        println(a.flatMap { it.second })

        println(a.flatMap { authorAndBook ->
            authorAndBook.second.map { book -> "${authorAndBook.first}: $book" }
        })

        println(a.flatMap { authorAndBook ->
            authorAndBook.second.map { book -> authorAndBook.first to book }
        })
    }

    @Test
    fun chunked() {
        val a = listOf(listOf(1, 2), listOf(3, 4))
        println(a.flatten().chunked(3))
    }

    @Test
    fun joinToString() {
        val a = listOf("Hello", "beautiful", "world", "42")
        println(a.joinToString())
        println(a.joinToString(" "))

        println(a.joinToString("\n") {
            "Word: $it"
        })
    }

    @Test
    fun filter() {
        val a = listOf(1, 2, 22, 3, 7)
        println(a.filter { it % 2 == 0 })

        val matchAndRest = a.partition { it % 2 == 0 }
        println(matchAndRest)

        val (match, rest) = a.partition { it % 2 == 0 }
        println(match)
        println(rest)
    }

    @Test
    fun test() {
        val a = listOf(1, 2, 22, 3, 7)
        println(a.any { it > 20 })
        println(a.all { it > 20 })
        println(a.none { it > 40 })

        val matchAndRest = a.partition { it % 2 == 0 }
        println(matchAndRest)

        val (match, rest) = a.partition { it % 2 == 0 }
        println(match)
        println(rest)
    }

    @Test
    fun slice() {
        val a = listOf("a", "b", "c", "d", "e")
        println(a.slice( 1 .. 3))
        println(a.slice( 1 .. 4 step 2))
        println(a.slice( 4 downTo 1))
        println(a.slice( listOf(3, 2, 4)))

    }

    @Test
    fun plusMinus() {
        val a = listOf(1, 2, 22, 3, 7, 3)
        println(a + listOf(5, 6))
        println(a - listOf(2, 1, 3))
        println(a + 42)
        println(a - 3)
        println(a - 9)
    }

    @Test
    fun sorted() {
        val a = listOf(1, 42, 2, 22, -5, 3, 7, 10, -1)
        println(a.sorted())
        println(a.sortedDescending())

        println(a.sortedBy { it.toString() })

        println(a.sortedWith { a, b -> if (a < 10 && b < 10) 0 else a.compareTo(b) })
    }

    @Test
    fun aggregate() {
        val a = listOf(1, 42, 2, 22, -5, 3, 7, 10, -1)
        println(a.minOrNull())
        println(a.maxOrNull())
        println(a.average())
        println(a.sum())

        println(a.sortedDescending())

        println(a.sortedBy { it.toString() })

        println(a.sortedWith { a, b -> if (a < 10 && b < 10) 0 else a.compareTo(b) })
    }

    @Test
    fun reduce() {
        val a1 = listOf(1, 2, 3)
        val a2 = listOf(1)
        val a3 = listOf<Int>()

        println(a1.reduce { a, b -> a + b })  // 1 + 2 + 3
        println(a2.reduce { a, b -> a + b })  // просто вернет первый элемент

        try {
            println(a3.reduce { a, b -> a + b })
        } catch (e : Exception) {
            println(e)
        }
    }

    @Test
    fun fold() {
        val a1 = listOf(1, 2, 3)
        val a2 = listOf(1)
        val a3 = listOf<Int>()

        println(a1.fold(0) { a, b -> a + b }) // 0 + 1 + 2 + 3
        println(a2.fold(0) { a, b -> a + b }) // 0 + 1
        println(a3.fold(0) { a, b -> a + b }) // 0
    }

    @Test
    fun sequences() {
        val a = listOf("Hello", "beautiful", "world", "42")

        val b = a.asSequence()
            .filter { it.toIntOrNull() == null }
            .map { it.uppercase() }
            .joinToString(" ")

        val c = a
            .filter { it.toIntOrNull() == null }
            .map { it.uppercase() }
            .joinToString(" ")

        println(b)
        println(c)
    }
}