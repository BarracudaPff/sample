package ru.otus.otuskotlin.m3l6

interface MovableM {
    val speedM: Double
}

interface MovableKM {
    val speedKM: Double
}

class CustomCar : MovableM {
    override val speedM = 123.0
}

// KM -> M
class MovableAdapter(val car: MovableM) : MovableKM {
    override val speedKM = convertMPHtoKMH(car.speedM)

    private fun convertMPHtoKMH(mph: Double): Double {
        return mph * 1.60934
    }
}

fun main() {
    val myCustomCar = CustomCar()
    val adapter = MovableAdapter(myCustomCar)

    println(adapter.car.speedM)
    println(adapter.speedKM)
}