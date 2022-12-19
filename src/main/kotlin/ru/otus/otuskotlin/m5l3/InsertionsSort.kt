package ru.otus.otuskotlin.m5l3

class InsertionsSort : SortAlgorithm<Int> {
    override fun sort(arr: ArrayList<Int>) {
        var position: Int
        val size = arr.size

        for (i in 1 until size) {
            val value = arr[i]
            position = i

            while (0 < position && value < arr[position - 1]) {
                arr.swap(position, position - 1)
                position--
            }
        }
    }
}