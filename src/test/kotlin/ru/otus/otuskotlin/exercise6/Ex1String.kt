package ru.otus.otuskotlin.exercise6

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class Ex1String {
    @Test
    fun createString() {
        val s0 = "hello"
        val s1: String = "hello\n\\nworld"

        val s2 = """
            hello\r\n
            world
        """
        val s3 = """
            |hello
            |world
            |""".trimMargin()

        println(s1)
        println("-------")
        println(s2)
        println("-------")
        println(s3)
    }

    @Test
    fun stringIsImmutable() {
        val s = "hello"
        // s[1] = "w";
        val s2 = s.replace("he", "qwer")

        println(s)
        println(s2)
    }

    @Test
    fun stringContainsFromChars() {
        val s = "hello"
        val c: Char = s[1]
        println(c)
        println(s.length)

        for (e in s)
            println(e)
    }

    @Test
    fun charIsNotLetter() {
        val s = "😂q"
        println("Length " + s.length)
        println("Chars ${s[0]}${s[1]}${s[2]}")
        println(s)

        println("Codepoints count " + s.codePointCount(0, s.length))
        println("Char codes ${s[0].code} ${s[1].code} ${s[2].code}")
        println("Codepoint 0: " + s.codePointAt(0))
        println("Codepoint 1: " + s.codePointAt(2))
    }

    @Test
    fun concatenation() {
        val one = "Hello"
        val two = "world"
        val s = one + ' ' + two + 42
        println(s)

        // val x = 42 + " is a number"
        val x = 42.toString() + " is a number"

        val q = "2+2=" + 2 + 2 // ?
        val w = "2*2=" + 2 * 2 // ?
        //println(q)
        //println(w)
    }

    @Test
    fun concatenationStringBuilder() {
        var dontDoThis = ""
        for (i in 1..10000)
            dontDoThis += "i=$i\n"
        println(dontDoThis.length)

        val b = StringBuilder()
        for (i in 1..10000)
            b.append("i=").append(i).append('\n')
        val s = b.toString()
        println(s.length)
    }

    @Test
    fun stringTemplates() {
        val one = "Hello"
        val two = "world"
        val s = "$one $two 42"
        println(s)

        println("2+2=${2 + 2}")

        println("----------")

        fun x(a: () -> Unit) {
            a()
        }

        println("dont do this ${
            x {
                for (i in 1 .. 3)
                    println("i = $i")
            }
        }")
    }

    @Test
    fun stringMethods() {
        val s:String = "Hello world";
        println(s.length)
        println(s.startsWith("Hello"))
        println(s.startsWith("hello", true))
        println(s.indexOf("world"))
        println(s.indexOf("qwer"))
        println(s.replace("Hello", "Goodbye"))
        println(s.replace("[eo]".toRegex(), "_"))
    }
}