package ru.otus.otuskotlin.m3l3.ex9

interface Something {
    fun f()
    fun g()

    fun doIt() {
        f()
        g()
    }
}

class SomethingImpl : Something {
    override fun f() {
        println("SomethingImpl f()")
    }

    override fun g() {
        println("SomethingImpl g()")
    }
}

class Decorator(private val source: Something): Something by source {
    override fun f() {
        println("Decorator f()")
    }
}

fun main() {
    val d = Decorator(SomethingImpl())
    d.f()
    println("----")
    d.g()
    println("----")
    d.doIt()
}

class X : (Int, String ) -> Double {
    override fun invoke(p1: Int, p2: String): Double  = 0.0
}