package ru.otus.otuskotlin.m5l3

class BubbleSort : SortAlgorithm<Int> {
    override fun sort(arr: ArrayList<Int>) {
        val size = arr.size
        for (i in 0 until size) {
            for (j in 1 until size - i) {
                val el1 = arr[j - 1]
                val el2 = arr[j]

                if (el1 > el2) {
                    arr.swap(j, j - 1)
                }
            }
        }
    }
}
