package ru.otus.otuskotlin.exercise9
import java.time.LocalDate

class Cat(
    val name: String,
    val birthDate: LocalDate
) { }

data class DataClassCat(
    val name: String,
    val birthDate: LocalDate
) { }


fun main() {
    val rick = Cat(name = "Rick", LocalDate.now().minusYears(70))
    val morty = Cat(name = "Morty", LocalDate.now().minusYears(10))
    val jerry = Cat(name = "Jerry", LocalDate.now().minusYears(40))

    println(rick::class == morty::class && morty::class == jerry::class)
    println(rick::class)
}