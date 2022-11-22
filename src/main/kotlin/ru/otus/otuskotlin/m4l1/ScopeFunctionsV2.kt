package ru.otus.otuskotlin.m4l1

import kotlin.random.Random

data class Person(
    var name: String,
    var age: Int,
    var address: String,
)

fun main() {
    val person = Person("Petya", 32, "RF").also {
        println(it)
    }

    val res1: Int = person.let { it.age }
    val res2: Person = person.apply { this.age }

//    val res3: Person = person.also { it.age }
//    val res4: Unit = person.run {
//        println(this.age)
//    }
//    val res5: Unit = with(person) {
//        println(this.age)
//    }

    val seed: Int? = 123 // null - with random seed

//    val random = Random(seed)
    val random = seed?.let { Random(it) } ?: Random
    println(random.nextInt())
}
