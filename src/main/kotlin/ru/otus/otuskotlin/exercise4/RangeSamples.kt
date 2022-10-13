package ru.otus.otuskotlin.exercise4

fun main() {
    val characters = 'a'.rangeTo('z')

    val isPresent1 = 'f' in characters // true
    val isPresent2 = 'f' in 'a'.rangeTo('c') // false


    val result = 7
    when (result) {
        in 0..5 -> print("1..5")
        in 5..10 -> print("5..10")
        else -> print("error")
    }

    // Same things
    val characters1 = 'a'.rangeTo('z')
    val characters2 = 'a'..'z'


    val intRange = 1..450
    val first = intRange.first // 1
    val last = intRange.last // 450

    for (i in intRange) {
        print(i)
    }
    for (i in 1..450) {
        print(i)
    }

    val intProgression = 1..450 step 10
    val intStep = intRange.step // 10

    val longProgression = 10L downTo 1L
    val longStep = longProgression.step // -1

    val charProgression = 'a'..'z'
    val charStep = charProgression.step // 1

}
