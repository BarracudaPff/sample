package ru.otus.otuskotlin.m5l3

import kotlin.random.Random
import kotlin.system.measureTimeMillis

interface SortAlgorithm<T> {
    fun sort(arr: ArrayList<T>)
}

// Sort with bubble
fun bubble(arr: ArrayList<Int>) {
    val sort = BubbleSort()
    val time = measureTimeMillis {
        sort.sort(arr)
    }
    println("Bubble done for :$time")
}

// Sort with insertions
fun insertions(arr: ArrayList<Int>) {
    val sort = InsertionsSort()
    val time = measureTimeMillis {
        sort.sort(arr)
    }
    println("Insertions done for :$time")
}

// Sort with selection
fun selection(arr: ArrayList<Int>) {
    val sort = SelectionSort()
    val time = measureTimeMillis {
        sort.sort(arr)
    }
    println("Selection done for :$time")
}

// Sort with selection
fun shell(arr: ArrayList<Int>) {
    val sort = ShellSort()
    val time = measureTimeMillis {
        sort.sort(arr)
    }
    println("Shell done for :$time")
}

// Sort with selection
fun quick(arr: ArrayList<Int>) {
    val sort = QuickSort()
    val time = measureTimeMillis {
        sort.sort(arr)
    }
    println("Quick done for :$time")
}

// Sort with std
fun std(arr: ArrayList<Int>) {
//    val sort = QuickSort()
    val time = measureTimeMillis {
        arr.sort()
    }
    println("Std done for :$time")
}

fun ArrayList<Int>.swap(from: Int, to: Int): ArrayList<Int> {
    val temp = get(from)
    set(from, get(to))
    set(to, temp)

    return this
}

fun ArrayList<Int>.copyArr(): ArrayList<Int> {
    val newArr = ArrayList<Int>()
    newArr.addAll(toList())
    return newArr
}

fun main() {
    val N = 10_000
    val arr = ArrayList<Int>(N)

    for (i in 0 until N) {
        arr.add(Random.nextInt(0, 10000))
    }

    bubble(arr.copyArr())
    insertions(arr.copyArr())
    selection(arr.copyArr())
    shell(arr.copyArr())
    quick(arr.copyArr())
    std(arr.copyArr())
}

