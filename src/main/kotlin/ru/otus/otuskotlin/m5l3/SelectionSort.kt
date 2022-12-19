package ru.otus.otuskotlin.m5l3

class SelectionSort : SortAlgorithm<Int> {
    override fun sort(arr: ArrayList<Int>) {
        for (i in 0 until arr.size - 1) {
            var selection = i

            for (j in i + 1 until arr.size) {
                if (arr[j] < arr[selection]) {
                    selection = j
                }
            }

            arr.swap(i, selection)
        }
    }
}