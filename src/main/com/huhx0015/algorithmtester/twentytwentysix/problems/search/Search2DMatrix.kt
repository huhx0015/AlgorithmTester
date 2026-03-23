package com.huhx0015.algorithmtester.twentytwentysix.problems.search

/**
 * Problem: Search a 2D Matrix
 * Difficulty: Medium
 *
 * You are given an m x n 2-D integer array matrix and an integer target.
 *
 * Each row in matrix is sorted in non-decreasing order.
 * The first integer of every row is greater than the last integer of the previous row.
 * Return true if target exists within matrix or false otherwise.
 *
 * Can you write a solution that runs in O(log(m * n)) time?
 *
 * Example 1:
 * Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 10
 *
 * Output: true
 *
 * Example 2:
 * Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 15
 *
 * Output: false
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10000 <= matrix[i][j], target <= 10000
 */
object Search2DMatrix {

    @JvmStatic fun main(args: Array<String>) {
        val inputMatrix = arrayOf(
            intArrayOf(1, 2, 4, 8),
            intArrayOf(10, 11, 12, 13),
            intArrayOf(14, 20, 30, 40)
        )
        val target1 = 10
        val target2 = 15

        val result1 = searchMatrix(matrix = inputMatrix, target = target1)
        println("Search 2D Matrix result for $target1 was $result1\n")

        val result2 = searchMatrix(matrix = inputMatrix, target = target2)
        println("Search 2D Matrix result for $target2 was $result2\n")
    }

    // searchMatrix(): Time Complexity: O (m * log n) | Space Complexity: O(1)
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        matrix.forEach { array ->
            // Performs the binarySearch on each array in the matrix.
            val searchResult = binarySearch(array = array, target = target)

            // If searchResult is true, the boolean value is returned early.
            if (searchResult) {
                println("Search 2D Matrix: searchMatrix has finished, target was found.")
                return true
            }
        }
        println("Search 2D Matrix: searchMatrix has finished, target was not found.")
        return false
    }

    // binarySearch(): Helper function that uses binary search to search for the target in the IntArray.
    fun binarySearch(array: IntArray, target: Int): Boolean {
        var leftPointer = 0 // Left pointer of the array.
        var rightPointer = array.size - 1 // Right pointer of the array.

        // Loops while the leftPointer is less than or equal to rightPointer.
        while (leftPointer <= rightPointer) {
            val midPointer = (leftPointer + rightPointer) / 2
            val midValue = array[midPointer]
            println("Search 2D Matrix: Binary Search: midPointer is $midPointer, midValue is $midValue")

            when {
                target > midValue -> {
                    leftPointer = midPointer + 1
                    println("Search 2D Matrix: Binary Search: target $target greater than midValue $midValue, leftPointer $leftPointer updated")
                }
                target < midValue -> {
                    rightPointer = midPointer - 1
                    println("Search 2D Matrix: Binary Search: target $target less than midValue $midValue, rightPointer $rightPointer updated")
                }
                else -> {
                    println("Search 2D Matrix: Binary Search: target $target was found in this array, returning true")
                    return true
                }
            }
        }

        println("Search 2D Matrix: Binary Search: target $target was not found in this array, returning false")
        return false
    }
}
