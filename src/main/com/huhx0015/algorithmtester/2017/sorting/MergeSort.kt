package main.com.huhx0015.algorithmtester.sorting

/**
 * Created by Michael Yoon Huh on 4/24/2017.

 * http://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html#mergesort
 */
object MergeSort {

    fun sort(array: IntArray) {
        mergesort(array, 0, array.size - 1)
    }

    // Big(O) Complexity: Best:	Ω(n log(n)) | Average:	Θ(n log(n))	| Worst: O(n log(n)) | Space Complexity:	O(n)
    fun mergesort(array: IntArray, low: Int, high: Int) {

        // Checks if low is smaller than high, if not then the array is sorted.
        if (low < high) {

            // Gets the index of the element which is in the middle.
            val middle = (low + high) / 2

            // Sorts the left side of the array.
            mergesort(array, low, middle)

            // Sorts the right side of the array.
            mergesort(array, middle + 1, high)

            // Combines them both.
            merge(array, low, middle, high)
        }
    }

    private fun merge(array: IntArray, low: Int, middle: Int, high: Int) {

        val helper = IntArray(array.size)

        // Copy both parts into the helper array.
        for (i in low..high) {
            helper[i] = array[i]
        }

        var i = low
        var j = middle + 1
        var k = low

        // Copy the smallest values from either the left or the right side back
        // to the original array.
        while (i <= middle && j <= high) {

            if (helper[i] <= helper[j]) {
                array[k] = helper[i]
                i++
            } else {
                array[k] = helper[j]
                j++
            }
            k++
        }

        // Copy the rest of the left side of the array into the target array.
        while (i <= middle) {
            array[k] = helper[i]
            k++
            i++
        }
    }
}
