package ru.otus.otuskotlin.m5l1

interface Mammal {
    val name: String
}

class Panda : Mammal {
    override val name: String = "Panda"
}

class Bear : Mammal {
    override val name: String = "Bear"
}

class Tiger : Mammal {
    override val name: String = "Tiger"
}

class Box<T>(val value: T)

inline fun <reified T : Mammal> T.getLocation(): String {
    val kClass = T::class

    return if (kClass == Box::class) {
        "in box"
    } else {
        "$name is unknown"
    }
}

fun main() {
    var animals = listOf(
        Panda(),
        Bear(),
        Tiger(),
    ).map {
        Box(it)
    }
    animals = animals.shuffled()
    val animalKClass = animals::class

    println(
        animals.first().value.getLocation()
    )
}
