package ru.otus.otuskotlin.m5l3

class QuickSort : SortAlgorithm<Int> {
    override fun sort(arr: ArrayList<Int>) {
        doSort(arr, 0, arr.size - 1)
    }

    fun doSort(arr: ArrayList<Int>, left: Int, right: Int) {
        if (left > right) return

        val pillar = arr[(left + right) / 2]

        var iLeft = left
        var jRight = right

        while (iLeft <= jRight) {
            while (arr[iLeft] < pillar)
                iLeft++
            while (arr[jRight] > pillar)
                jRight--

            if (iLeft <= jRight) {
                arr.swap(iLeft, jRight)
                iLeft++
                jRight--
            }
        }
        if (left < jRight) {
            doSort(arr, left, jRight)
        }
        if (right > iLeft) {
            doSort(arr, iLeft, right)
        }
    }
}