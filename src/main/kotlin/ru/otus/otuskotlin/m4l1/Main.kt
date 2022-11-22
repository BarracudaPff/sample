package ru.otus.otuskotlin.m4l1

fun main() {
//    fun sum(nums: List<Int>): Int {
//        var sum = 0
//
//        for (num in nums) {
//            sum += num
//        }
//
//        return sum
//    }
//
//    val function1 = ::sum
    val function: (nums: List<Int>) -> Int = {
        var sum = 0

        for (num in it) {
            sum += num
        }

        sum
    }

    val numbers = listOf(
        1, 2, 92, 5, 5, 8, 2
    )

    val sumOfNumbers = function(numbers)

    println("Sum of numbers is $sumOfNumbers.")
}
