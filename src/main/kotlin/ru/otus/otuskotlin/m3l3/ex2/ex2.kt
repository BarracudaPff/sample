package ru.otus.otuskotlin.m3l3.ex2

abstract class Animal {

    abstract val name: String

    abstract fun voice(): String
    fun describeMe() = "I am $name"
}

class Cat(override val name: String): Animal() {
    override fun voice(): String = "Meow"
}

class Dog(override val name: String) : Animal() {
    override fun voice() = "ARGH"

}

fun main() {
    // val a = Animal()
    val animals = listOf(Cat("barsik"), Dog("tuzik"))

    animals.forEach { println(it.describeMe() + ": " + it.voice()) }
}