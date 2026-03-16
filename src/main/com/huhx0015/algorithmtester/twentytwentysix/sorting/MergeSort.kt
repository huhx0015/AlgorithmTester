package com.huhx0015.algorithmtester.twentytwentysix.sorting

import com.huhx0015.algorithmtester.twentytwentysix.sorting.InsertionSort.Pair

/**
 * NeetCode.io
 *
 * Merge Sort
 * Difficulty: Medium
 * Implement Merge Sort.
 *
 * Merge Sort is a divide-and-conquer algorithm for sorting an array or list of elements. It works by recursively dividing the unsorted list into n sub-lists, each containing one element. Then, it repeatedly merges sub-lists to produce new sorted sub-lists until there is only one sub-list remaining.
 *
 * Objective:
 *
 * Given a list of key-value pairs, sort the list by key using Merge Sort. If two key-value pairs have the same key, maintain their relative order in the sorted list.
 *
 * Input:
 *
 * pairs - a list of key-value pairs, where each key-value has an integer key and a string value. (0 <= pairs.length <= 100).
 * Example 1:
 *
 * Input:
 * pairs = [(5, "apple"), (2, "banana"), (9, "cherry"), (1, "date"), (9, "elderberry")]
 *
 * Output:
 * [(1, "date"), (2, "banana"), (5, "apple"), (9, "cherry"), (9, "elderberry")]
 * Note: As you can see, the solution is always stable. The two pairs with the key 9 maintained their relative positions.
 *
 * Example 2:
 *
 * Input:
 * pairs = [(3, "cat"), (2, "dog"), (3, "bird")]
 *
 * Output:
 * [(2, "dog"), (3, "cat"), (3, "bird")]
 */
object MergeSort {

    @JvmStatic fun main(args: Array<String>) {
        val inputIntArray1 = intArrayOf(2, 3, 4, 1, 6)
        val inputIntArray2 = intArrayOf(6, 4, 3, 2, 1)

        println("mergeSort (IntArray) starting, array is: ${inputIntArray1.toSet()}")
        val sortIntArray1 = mergeSort(inputIntArray1, 0, inputIntArray1.size - 1)
        println("mergeSort (IntArray) completed, sorted array is: ${sortIntArray1.toSet()}")
        println("---------------------------------------------")

        println("mergeSort (IntArray) starting, array is: ${inputIntArray2.toSet()}")
        val sortIntArray2 = mergeSort(inputIntArray2, 0, inputIntArray1.size - 1)
        println("mergeSort (IntArray) completed, sorted array is: ${sortIntArray2.toSet()}")

        println("---------------------------------------------")

        val inputPairArray1 = mutableListOf(
            Pair(5, "apple"),
            Pair(2, "banana"),
            Pair(9, "cherry"),
        )
        val inputPairArray2 = mutableListOf(
            Pair(3, "cat"),
            Pair(3, "bird"),
            Pair(2, "dog"),
        )

        println("mergeSort (List<Pair>) starting...")
        mergeSort(inputPairArray1)
        println("mergeSort (List<Pair>) completed, array sorted.")
        println("---------------------------------------------")

        println("mergeSort (List<Pair>) starting...")
        mergeSort(inputPairArray2)
        println("mergeSort (List<Pair>) completed, array sorted.")
    }

    // Pair: Defines a simple Pair with Int key and String value.
    class Pair(var key: Int, var value: String)

    // mergeSort(): Time Complexity: O(n log n) | Space Complexity: O(n)
    fun mergeSort(array: IntArray, leftIndex: Int, rightIndex: Int): IntArray {
        println("\nmergeSort (IntArray): array size is ${array.size}, leftIndex: $leftIndex, rightIndex: $rightIndex")

        // Checks the leftIndex against the rightIndex first, if so, then mergeSort is recursively called on both halves
        // of the array, then is merged using the merge function.
        if (leftIndex < rightIndex) {
            println("mergeSort (IntArray): leftIndex: $leftIndex is less than rightIndex: $rightIndex")

            val middleIndex = (leftIndex + rightIndex) / 2 // Find the middle point of array.
            println("mergeSort (IntArray): middleIndex: $middleIndex")

            mergeSort(array, leftIndex, middleIndex) // Sort left half.
            mergeSort(array, middleIndex + 1, rightIndex)  // Sort right half.

            // Merge won't be executed until both mergeSort calls are finished in their respective halves.
            merge(array, leftIndex, middleIndex, rightIndex) // Merge sorted halves.
        }
        return array
    }

    // merge(): Merges two subarrays of arr[].
    // First subarray is array[l..m]
    // Second subarray is array[m+1..r]
    // Uses the two-pointer pattern.
    private fun merge(array: IntArray, leftIndex: Int, middleIndex: Int, rightIndex: Int) {
        println("\nmergeSort (IntArray): Merge sorting completed on both halves, merge() called on array size ${array.size}, leftIndex: $leftIndex, middleIndex: $middleIndex rightIndex: $rightIndex")

        // Find lengths of two subarrays to be merged.
        val length1 = middleIndex - leftIndex + 1
        val length2 = rightIndex - middleIndex

        // Create temp arrays.
        val left = IntArray(length1)
        val right = IntArray(length2)

        // Copy the sorted left & right halves to temp arrays.
        for (i in 0 until length1) {
            left[i] = array[leftIndex + i]
        }

        for (j in 0 until length2) {
            right[j] = array[middleIndex + 1 + j]
        }

        // initial indexes of left and right sub-arrays
        var i = 0 // index for left
        var j = 0 // index for right
        var k = leftIndex // Initial index of merged subarray array

        // Merge the two sorted halves into the original array
        while (i < length1 && j < length2) {
            if (left[i] <= right[j]) {
                println("mergeSort (IntArray): MERGE: Value ${left[i]} at $i is less than or equal to right value ${right[j]} at $j.")
                array[k] = left[i]
                i++
            } else {
                println("mergeSort (IntArray): MERGE: Value ${left[i]} at $i is greater than to right value ${right[j]} at $j.")
                array[k] = right[j]
                j++
            }
            k++
        }
        // One of the halves will have elements remaining

        // Copy remaining elements of L[] if any
        while (i < length1) {
            println("mergeSort (IntArray): MERGE: Copying the left array of length1: $length1")
            array[k] = left[i]
            i++
            k++
        }

        // Copy remaining elements of R[] if any
        while (j < length2) {
            println("mergeSort (IntArray): MERGE: Copying the right array of length2: $length2")
            array[k] = right[j]
            j++
            k++
        }
    }

    // mergeSort(): Sorts the MutableList<Pair> using merge sort algorithm (divide & conqeur).
    fun mergeSort(pairs: MutableList<Pair>): MutableList<Pair> {
        println("\nmergeSort (List<Pair>): list size is ${pairs.size}")

        // Used to store the list of pairs when an insertion happens.
        val pairsStateList: MutableList<Pair> = mutableListOf()

        // Handle early return cases, if the pairs is empty or size 1.
        if (pairs.isEmpty()) return pairsStateList
        if (pairs.size == 1) {
            println("mergeSort (List<Pair>) Only 1 element is left in the list: ${pairs.first().key}, returning the pairs.")
            return pairs
        }

        val middleIndex = (pairs.size) / 2 // Divide the size of the pairs to get the middle index.

        // Use the Kotlin List `sublist` function to grab the halves.
        val leftHalf = pairs.subList(0, middleIndex) // Left half, starting from 0 index to middleIndex.
        val rightHalf = pairs.subList(middleIndex, pairs.size) // Right half, starting from middleIndex to end index.

        val leftSorted = mergeSort(pairs = leftHalf) // Recursive call on mergeSort with the leftHalf of the list.
        val rightSorted = mergeSort(pairs = rightHalf) // Recursive call on mergeSort with the rightHalf of the list.

        return merge(leftSorted, rightSorted)
    }

    // merge(): Merges the left and right MutableList<Pair> and returns the result.
    private fun merge(left: MutableList<Pair>, right: MutableList<Pair>): MutableList<Pair> {
        println("\nmergeSort (List<Pair>): MERGE: Merge sorting completed on both halves, merge() called on left list ${left.size} and right list ${right.size}")

        var i = 0
        var j = 0
        val result = mutableListOf<Pair>()

        // Merge the two sorted halves into the original array.
        while (i < left.size && j < right.size) {

            // Compares the left key and right key value. If the left key value is less than or equal, we increment the
            // left (i) pointer.
            // Otherwise if left key is greater than the right key value, we increment the right (j) pointer.
            if (left[i].key <= right[j].key) {
                println("mergeSort (List<Pair>): MERGE: Value ${left[i].key} at $i is less than or equal to right value ${right[j].key} at $j.")
                result.add(left[i])
                i++
            } else {
                println("mergeSort (List<Pair>): MERGE: Value ${left[i].key} at $i is greater than to right value ${right[j].key} at $j.")
                result.add(right[j])
                j++
            }
        }

        // Copy remaining elements of left[] if any.
        while (i < left.size) {
            println("mergeSort (List<Pair>): MERGE: Copying the left array: ${left.size}")
            result.add(left[i])
            i++
        }

        // Copy remaining elements of right[] if any.
        while (j < right.size) {
            println("mergeSort (List<Pair>): MERGE: Copying the right array: ${right.size}")
            result.add(right[j])
            j++
        }

        return result
    }
}