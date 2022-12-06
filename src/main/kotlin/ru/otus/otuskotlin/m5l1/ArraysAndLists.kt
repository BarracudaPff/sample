package ru.otus.otuskotlin.m5l1

import kotlin.random.Random
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

fun main() {
    val random = Random
    val num = 1_000_000

    val array = arrayOf(1, 2, 3)
    val list = listOf(1, 2, 3)
    val arrayList = ArrayList<Int>()//arrayListOf(0)

    val res = measureTimeMillis {
        for (i in 0 until num) {
            arrayList.add(random.nextInt())
        }
    }

    println(res)
}


