package com.huhx0015.algorithmtester.twentytwentysix.sorting

/**
 * Problem: Quick Sort
 * Difficulty: Medium
 *
 * Implement Quick Sort.
 *
 * Quick Sort is a divide-and-conquer sorting algorithm that works by partitioning an array into two smaller sub-arrays based on a pivot element. The elements less than the pivot go to the left sub-array and those greater go to the right sub-array. The algorithm then recursively sorts the sub-arrays.
 *
 * Objective:
 *
 * Given a list of key-value pairs, sort the list by key using Quick Sort. For each partitioning step:
 *
 * Use the right-most element as the pivot.
 * Elements less than the pivot should be placed to the left of the pivot, and elements greater than or equal to the pivot should be placed to the right of the pivot.
 * The correctness of your solution will be determined based on these requirements.
 *
 * Input:
 *
 * pairs - a list of key-value pairs, where each key-value has an integer key and a string value. (0 <= pairs.length <= 100).
 * Example 1:
 *
 * Input:
 * pairs = [(3, "cat"), (2, "dog"), (3, "bird")]
 *
 * Output:
 * [(2, "dog"), (3, "bird"), (3, "cat")]
 * Note: As you can see, the solution is not necessarily stable. The two pairs with the key 3 have switched their relative positions.
 *
 * Example 2:
 *
 * Input:
 * pairs = [(5, "apple"), (9, "banana"), (9, "cherry"), (1, "date"), (9, "elderberry")]
 *
 * Output:
 * [(1, "date"), (5, "apple"), (9, "elderberry"), (9, "cherry"), (9, "banana")]
 *
 * The partition step takes O(n). O(n) time and we do this for every level of the recursion tree. The number of levels
 * in the recursion tree is O(log n).
 * O(log n), but only in the best case.
 * Worst Case: O(n^2), if pivot ends up being the smallest or largest element.
 *
 * Stability: Quicksort is not a stable algorithm because it exchanges non-adjacent elements.
 */
object QuickSort {

    data class Pair(var key: Int, var value: String)

    @JvmStatic fun main(args: Array<String>) {
        val inputArray1 = intArrayOf(6, 2, 4, 1, 3)
        val inputArray2 = intArrayOf(7, 3, 7, 4, 5)
        val inputPairs1: MutableList<Pair> = mutableListOf(Pair(1, "cat"), Pair(2, "dog"), Pair(3, "bird"))
        val inputPairs2: MutableList<Pair> = mutableListOf(Pair(5, "apple"), Pair(9, "apple"), Pair(9, "cherry"), Pair(9, "banana"))

        val resultArray1 = quickSort(arr = inputArray1, s = 0, e = 4)
        println("QuickSort (IntArray): Original array was ${inputArray1.toSet()}, sorted array is ${resultArray1.toSet()}\n")

        val resultArray2 = quickSort(arr = inputArray2, s = 0, e = 4)
        println("QuickSort (IntArray): Original array was ${inputArray2.toSet()}, sorted array is ${resultArray2.toSet()}\n")

        val resultPairs1 = quickSort(pairs = inputPairs1)
        println("QuickSort (Pairs): Original pair was ${inputPairs1.toSet()}, sorted array is ${resultPairs1.toSet()}\n")

        val resultPairs2 = quickSort(pairs = inputPairs2)
        println("QuickSort (Pairs): Original pair was ${inputPairs2.toSet()}, sorted array is ${resultPairs2.toSet()}\n")
    }

    // quickSort(): Pairs implementation.
    // Time Complexity: Best Case: O(n) * O(log n) = O(n log n) | Worst Case: O(n^2)
    // Space Complexity: O(1)
    fun quickSort(pairs: MutableList<Pair>): MutableList<Pair> {
        if (pairs.isEmpty()) return pairs

        // Call the helper function sort() to perform quick sort on pairs.
        sort(pairs = pairs, startingIndex = 0, endingIndex = pairs.size - 1)
        return pairs
    }

    // sort(): Helper function to quickSort to perform the quick sort algorithm on pairs.
    fun sort(pairs: MutableList<Pair>, startingIndex: Int, endingIndex: Int) {
        println("quickSort (Pairs): sort() called with startingIndex $startingIndex, endingIndex $endingIndex")

        if (endingIndex - startingIndex + 1 <= 1) {
            println("quickSort (Pairs): Finished sorting array with $endingIndex - $startingIndex + 1 <= 1 condition met.")
            return
        }

        val pivot = pairs[endingIndex]
        var left = startingIndex
        println("quickSort (Pairs): Pivot: $pivot | left: $left")

        for (i in startingIndex until endingIndex) {
            if (pairs[i].key < pivot.key) {
                val temp = pairs[left]
                pairs[left] = pairs[i]
                pairs[i] = temp
                left++
            }
        }

        pairs[endingIndex] = pairs[left]
        pairs[left] = pivot

        sort(pairs = pairs, startingIndex = startingIndex, endingIndex = left - 1)
        sort(pairs = pairs, startingIndex = left + 1, endingIndex = endingIndex)

        return
    }

    // quickSort(): IntArray implementation.
    // arr = array to be sorted
    // s = start index (beginning of the subarray you’re sorting)
    // e = end index (ending of the subarray you’re sorting)
    fun quickSort(arr: IntArray, s: Int, e: Int): IntArray {
        println("quickSort (IntArray): Sorting array with start index $s and end index $e.")

        if (e - s + 1 <= 1) {
            println("quickSort (IntArray): Finished sorting array with $e - $s + 1 <= 1 condition met.")
            return arr
        }

        val pivot = arr[e] // Pivot set to the end index value of the array.
        var left = s // Pointer for left side.
        println("quickSort (IntArray): Pivot: $pivot | left: $left")

        // Partition: Elements smaller than pivot on left side.
        for (i in s until e) {

            // Compare Each Element to Pivot: If current element is smaller than pivot, it belongs on the left side.
            if (arr[i] < pivot) {

                // Swap: current element arr[i] with the element at left
                val temp = arr[left]
                arr[left] = arr[i]
                arr[i] = temp

                println("quickSort (IntArray): FOR: temp: $temp | arr[left]: ${arr[left]} | arr[i]: ${arr[i]}")
                left++
            }
        }

        // Move pivot in-between left & right sides.
        arr[e] = arr[left]
        arr[left] = pivot
        println("quickSort (IntArray): Moving pivot in-between left & right sides: arr[e]: ${arr[e]} | arr[left]: ${arr[left]}")

        quickSort(arr, s, left - 1) // Recursive call to quick sort left side.
        quickSort(arr, left + 1, e) // Recursive call to quick sort right side.

        return arr
    }
}