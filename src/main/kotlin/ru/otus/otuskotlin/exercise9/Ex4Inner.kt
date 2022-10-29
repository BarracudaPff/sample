package ru.otus.otuskotlin.exercise9
import java.time.LocalDate

class Outer {
    private val bar: Int = 1
    var member: Int = 5

    inner class Inner {
        fun foo() = bar
        fun getMember() = member
        fun setMember(m: Int) {
            member = m
        }
    }

    class Nested {
        // fun foo() = bar

    }

    fun createInner() = Inner()


}

fun main() {
    var o = Outer()
    var i = o.Inner()
    var i2 = o.createInner()
    var n = Outer.Nested()

    o.member = 10
    println(i.getMember())
    i.setMember(10)
    println(o.member)

}