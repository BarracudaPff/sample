package ru.otus.otuskotlin.m5l3

class ShellSort : SortAlgorithm<Int> {
    override fun sort(arr: ArrayList<Int>) {
        var d = arr.size / 2
        while (d > 0) {
            for (i in d until arr.size) {
                var j = i
                while (j >= d && arr[j] < arr[j - d]) {
                    arr.swap(j, j - d)
                    j -= d
                }
            }

            d /= 2
        }
    }
}