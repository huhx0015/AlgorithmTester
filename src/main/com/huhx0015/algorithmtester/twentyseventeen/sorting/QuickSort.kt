package com.huhx0015.algorithmtester.twentyseventeen.sorting

/**
 * QuickSort

 * Source: http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html

 * Created by Michael Yoon Huh on 6/13/2017.
 */
object QuickSort {

    private var numbers: IntArray? = null
    private var number: Int = 0

    @JvmStatic
    fun main(args: Array<String>) {
        val inputArray1 = intArrayOf(7, 5, 3, 8)
        val inputArray2 = intArrayOf(45, 72, 3, 4, 59, 100)

        println("QuickSort (IntArray) starting, array is: ${inputArray1.toSet()}")
        sort(inputArray1)
        println("---------------------------------------------")

        println("QuickSort (IntArray) starting, array is: ${inputArray2.toSet()}")
        sort(inputArray2)
        println("---------------------------------------------")
    }

    fun sort(values: IntArray?) {

        // Check for empty or null array.
        if (values == null || values.isEmpty()) {
            return
        }
        this.numbers = values
        number = values.size
        quicksort(0, number - 1)

        println("QuickSort (IntArray) finished sorting, sorted array is: ${numbers?.toSet()}")
    }

    private fun quicksort(low: Int, high: Int) {
        var i = low
        var j = high

        // Get the pivot element from the middle of the list.
        val pivot = numbers!![low + (high - low) / 2]

        // Divide into two lists.
        while (i <= j) {

            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list.
            while (numbers!![i] < pivot) {
                i++
            }

            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list.
            while (numbers!![j] > pivot) {
                j--
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j.
            if (i <= j) {
                exchange(i, j)
                i++
                j--
            }
        }

        // Recursion.
        if (low < j)
            quicksort(low, j)
        if (i < high)
            quicksort(i, high)
    }

    private fun exchange(i: Int, j: Int) {
        val temp = numbers!![i]
        numbers!![i] = numbers!![j]
        numbers!![j] = temp
    }
}