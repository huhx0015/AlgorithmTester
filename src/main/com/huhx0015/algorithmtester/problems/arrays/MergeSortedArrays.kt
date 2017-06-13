package main.com.huhx0015.algorithmtester.problems.arrays

import java.util.Arrays

/**
 * Created by Michael Yoon Huh on 5/8/2017.

 * Interview Cake

 * In order to win the prize for most cookies sold, my friend Alice and I are going to merge our Girl Scout Cookies
 * orders and enter as one unit.

 * Each order is represented by an "order id" (an integer).

 * We have our lists of orders sorted numerically already, in arrays. Write a function to merge our arrays of orders into
 * one sorted array.

 * Example:

 * int[] myArray     = new int[]{3, 4, 6, 10, 11, 15};
 * int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};

 * System.out.println(mergeArrays(myArray, alicesArray));
 * // prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]

 * URL: https://www.interviewcake.com/question/java/merge-sorted-arrays
 */
object MergeSortedArrays {

    // Run-time complexity should be O(x) - x representing all elements in array1 and array2.
    // Space-time complexity should be O(x) - x presenting all elemtns in array1 and array2.
    fun mergeSortedArrays(array1: IntArray, array2: IntArray): IntArray {

        val array1Size = array1.size
        val array2Size = array2.size
        val totalSize = array1Size + array2Size

        val mergedArrays = IntArray(totalSize) // Used for storing the merged array.

        // Used for tracking the position of both arrays while merging.
        var pointer1 = 0
        var pointer2 = 0

        // Compare each array elements by size and add them to the merged array.
        for (x in 0..totalSize - 1) {

            // If both pointers have not exceeded their respective array size, we compare the two array values.
            if (pointer1 < array1Size && pointer2 < array2Size) {

                // Compare the two array values. The smallest value is merged into the merged array.
                if (array1[pointer1] < array2[pointer2]) {
                    mergedArrays[x] = array1[pointer1]
                    pointer1++
                } else {
                    mergedArrays[x] = array2[pointer2]
                    pointer2++
                }
            } else if (pointer1 < array1Size) {
                mergedArrays[x] = array1[pointer1]
                pointer1++
            } else if (pointer2 < array2Size) {
                mergedArrays[x] = array2[pointer2]
                pointer2++
            }// If pointer for array 2 is less than the array2size, it is added to the merged array.
            // If pointer for array 1 is less than the array1size, it is added to the merged array.
        }

        return mergedArrays
    }

    // Merge sorted arrays using built-in methods, but this is O(n log n) in run time.
    fun mergeSortedArraysBuiltIn(myArray: IntArray, alicesArray: IntArray): IntArray {

        // Creates a larger array that has size of both arrays and then copies myArray into it.
        val mergedArray = Arrays.copyOf(myArray, myArray.size + alicesArray.size)

        // Copies alicesArray from 0 to the end position, into the merged array.
        System.arraycopy(alicesArray, 0, mergedArray, myArray.size, alicesArray.size)

        Arrays.sort(mergedArray) // Sorts the merged array using the built-in, quicksort like algorithm. O(n log(n))
        return mergedArray
    }

    @JvmStatic fun main(args: Array<String>) {

        val myArray = intArrayOf(3, 4, 6, 10, 11, 15)
        val alicesArray = intArrayOf(1, 5, 8, 12, 14, 19)

        //int[] mergedArray = mergeSortedArraysBuiltIn(myArray, alicesArray);
        val mergedArray = mergeSortedArrays(myArray, alicesArray)

        for (x in mergedArray) {
            println(x)
        }
    }
}
