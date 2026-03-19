package com.huhx0015.algorithmtester.twentytwentysix.sorting

object BucketSort {

    @JvmStatic fun main(args: Array<String>) {
        val inputIntArray1 = intArrayOf(2, 3, 4, 1, 6)
        val inputIntArray2 = intArrayOf(6, 4, 3, 2, 1)

        println("bucketSort (IntArray): Original array was ${inputIntArray1.toList()}")
        val resultIntArray1 = bucketSort(inputIntArray1)
        println("bucketSort (IntArray): Sorted array is: ${resultIntArray1.toList()}\n")

        println("bucketSort (IntArray): Original array was ${inputIntArray2.toList()}")
        val resultIntArray2 = bucketSort(inputIntArray2)
        println("bucketSort (IntArray): Sorted array is: ${resultIntArray2.toList()}")
    }

    // bucketSort(): Time Complexity: O(n + k) where k is the range of values
    fun bucketSort(array: IntArray): IntArray {
        if (array.isEmpty()) return array // Early return if array is empty.

        // Establishes a range of values from the array.
        val minVal = array.minOrNull()!!
        val maxVal = array.maxOrNull()!!
        val range = maxVal - minVal + 1
        val counts = IntArray(range)

        // Count the quantity of each val in array.
        for (value in array) {
            counts[value - minVal]++
        }

        // Fill each bucket in the original array.
        var i = 0
        for (n in counts.indices) {
            val actualValue = n + minVal
            for (j in 0 until counts[n]) {
                array[i] = actualValue
                i++
            }
        }
        return array
    }
}