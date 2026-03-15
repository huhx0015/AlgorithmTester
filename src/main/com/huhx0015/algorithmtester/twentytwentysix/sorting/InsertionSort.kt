package com.huhx0015.algorithmtester.twentytwentysix.sorting

/**
 * NeetCode.io
 *
 * Insertion Sort
 * Difficult: Easy
 * Implement Insertion Sort and return intermediate states.
 *
 * Insertion Sort is a simple sorting algorithm that builds the sorted list one element at a time, from left to right. It works by repeatedly taking an element from the unsorted portion and inserting it into its correct position in the sorted portion of the list.
 *
 * Objective:
 *
 * Given a list of key-value pairs, sort the list by key using Insertion Sort. Return a list of lists showing the state of the array after each insertion. If two key-value pairs have the same key, maintain their relative order in the sorted list.
 *
 * Input:
 *
 * pairs - a list of key-value pairs, where each key-value has an integer key and a string value. (0 <= pairs.length <= 100).
 * Example 1:
 *
 * Input:
 * pairs = [(5, "apple"), (2, "banana"), (9, "cherry")]
 *
 * Output:
 * [[(5, "apple"), (2, "banana"), (9, "cherry")],
 *  [(2, "banana"), (5, "apple"), (9, "cherry")],
 *  [(2, "banana"), (5, "apple"), (9, "cherry")]]
 * Notice that the output shows the state of the array after each insertion. The last state is the final sorted array. There should be pairs.length states in total.
 *
 * Example 2:
 *
 * Input:
 * pairs = [(3, "cat"), (3, "bird"), (2, "dog")]
 *
 * Output:
 * [[(3, "cat"), (3, "bird"), (2, "dog")],
 *  [(3, "cat"), (3, "bird"), (2, "dog")],
 *  [(2, "dog"), (3, "cat"), (3, "bird")]]
 * In this example, you can observe that the pairs with key=3 ("cat" and "bird") maintain their relative order, illustrating the stability of the Insertion Sort algorithm.
 */
object InsertionSort {

    @JvmStatic fun main(args: Array<String>) {
        val inputIntArray1 = intArrayOf(2, 3, 4, 1, 6)
        val inputIntArray2 = intArrayOf(6, 4, 3, 2, 1)

        println("insertSort (IntArray) starting, array is: ${inputIntArray1.toSet()}")
        val sortIntArray1 = insertionSort(inputIntArray1)
        println("insertSort (IntArray) completed, sorted array is: ${sortIntArray1.toSet()}")
        println("---------------------------------------------")

        println("insertSort (IntArray) starting, array is: ${inputIntArray2.toSet()}")
        val sortIntArray2 = insertionSort(inputIntArray2)
        println("insertSort (IntArray) completed, sorted array is: ${sortIntArray2.toSet()}")
    }

    // insertionSort(): Insertion sort for IntArray inputs with return type IntArray.
    fun insertionSort(array: IntArray): IntArray {

        // The i pointer points at the element we are currently inserting into the sorted portion of the
        // array.
        // The j pointer starts off one index to the left of i.
        for (i in 1 until array.size) {
            println("insertionSort (IntArray): i (Current pointer): $i")
            var j = i - 1
            println("insertionSort (IntArray): j (Second pointer): $j")

            // Our goal is to find the position that arr[i] should be inserted into the sorted portion of the array.
            // We continue swapping it with arr[j] until we find the correct position.
            // After each swap we shift j to the left by 1.
            // We stop once the element is greater than or equal to the element to its left.
            while (j >= 0 && array[j + 1] < array[j]) {
                val temp = array[j + 1]
                println("insertionSort (IntArray): temp updated to array[j + 1] ${array[j + 1]}: $temp")

                array[j + 1] = array[j]
                println("insertionSort (IntArray): array [j + 1] updated, now: ${array[j]}")

                array[j] = temp
                println("insertionSort (IntArray): array [j] updated to be equal to temp $temp, now: ${array[j]}, advancing to next while loop.\n")

                j-- // Decrements j to advance the while loop.
            }
        }
        return array
    }

    // insertionSort(): Insertion sort for MutableList<Pair> with return type List<List<Pair>.
//    fun insertionSort(pairs: MutableList<Pair>): List<List<Pair>> {
//
//    }
}