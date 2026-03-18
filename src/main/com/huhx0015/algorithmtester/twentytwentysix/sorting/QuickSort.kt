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

    @JvmStatic fun main(args: Array<String>) {
        val inputArray1 = intArrayOf(6, 2, 4, 1, 3)
        val inputArray2 = intArrayOf(7, 3, 7, 4, 5)

        val resultArray1 = quickSort(arr = inputArray1, s = 0, e = 4)
        println("QuickSort (Int Array): Original array was ${inputArray1.toSet()}, sorted array is ${resultArray1.toSet()}")

        val resultArray2 = quickSort(arr = inputArray2, s = 0, e = 4)
        println("QuickSort (Int Array): Original array was ${inputArray2.toSet()}, sorted array is ${resultArray2.toSet()}")
    }

    data class Pair(var key: Int, var value: String)

//    fun quickSort(pairs: MutableList<Pair>): MutableList<Pair> {
//
//    }

    // quickSort():
    // arr = array to be sorted
    // s = start index (beginning of the subarray you’re sorting)
    // e = end index (ending of the subarray you’re sorting)
    fun quickSort(arr: IntArray, s: Int, e: Int): IntArray {
        if (e - s + 1 <= 1) {
            return arr
        }

        val pivot = arr[e]
        var left = s // Pointer for left side.

        // Partition: Elements smaller than pivot on left side.
        for (i in s until e) {
            if (arr[i] < pivot) {
                val tmp = arr[left]
                arr[left] = arr[i]
                arr[i] = tmp
                left++
            }
        }

        // Move pivot in-between left & right sides.
        arr[e] = arr[left]
        arr[left] = pivot

        quickSort(arr, s, left - 1) // Recursive call to quick sort left side.
        quickSort(arr, left + 1, e) // Recursive call to quick sort right side.

        return arr
    }
}