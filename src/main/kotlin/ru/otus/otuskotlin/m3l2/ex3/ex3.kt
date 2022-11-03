package ru.otus.otuskotlin.m3l2.ex3

open class Base(var x: Int) {

    constructor() : this(0) {
        println("Base()")
    }

    init {
        println("Base($x)")
    }
}

class Derived1 : Base {
    //var x = 0
    var y = 0

    constructor() {
        println("Derived1()")
    }

    constructor(x: Int) : super(x) {
        println("Derived1($x)")
    }
}

class Derived2() : Base() {

    init {
        println("Derived2()")
    }

    constructor(x: Int) : this() {
        this.x = x
        println("Derived2($x)")
    }
}

fun main() {
    Derived1()
    println("-----------")
    Derived1(10)
}
