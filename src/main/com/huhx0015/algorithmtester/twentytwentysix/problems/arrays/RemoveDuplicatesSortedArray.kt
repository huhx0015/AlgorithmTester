package com.huhx0015.algorithmtester.twentytwentysix.problems.arrays

/**
 * NeetCode.io
 *
 * Problem: Remove Duplicates From Sorted Array
 * Difficulty: EASY
 * Pattern: Two-Pointer
 *
 * You are given an integer array nums sorted in non-decreasing order. Your task is to remove duplicates from nums in-place
 * so that each element appears only once.
 *
 * After removing the duplicates, return the number of unique elements, denoted as k, such that the first k elements of
 * nums contain the unique elements.
 *
 * Note:
 * The order of the unique elements should remain the same as in the original array.
 * It is not necessary to consider elements beyond the first k positions of the array.
 * To be accepted, the first k elements of nums must contain all the unique elements.
 * Return k as the final result.
 *
 * Return k as the final result.
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,3,4]
 *
 * Output: [1,2,3,4]
 * Explanation: You should return k = 4 as we have four unique elements.
 *
 * Example 2:
 *
 * Input: nums = [2,10,10,30,30,30]
 *
 * Output: [2,10,30]
 * Explanation: You should return k = 3 as we have three unique elements.
 *
 * Constraints:
 * 1 <= nums.length <= 30,000
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 *
 * Time Complexity: O(n) - we pass through the array once
 * Space Complexity: O(1) - we modify in-place with constant extra space
 *
 * The sorted property ensures duplicates are adjacent, so comparing with the previous element is sufficient
 */
object RemoveDuplicatesSortedArray {

    @JvmStatic fun main(args: Array<String>) {

        val input1 = intArrayOf(1, 1, 2, 3, 4)
        println("Input 1: ${input1.toList()}\n")
        val input1Result = removeDuplicates(input1)
        println("Unique elements: $input1Result\n")

        val input2 = intArrayOf(2, 10, 10, 30, 30, 30)
        println("Input 2: ${input2.toList()}\n")
        val input2Result = removeDuplicates(input2)
        println("Unique elements: $input2Result\n")
    }

    fun removeDuplicates(nums: IntArray): Int {
        // Handles empty array input, return 0.
        if (nums.isEmpty()) {
            println("Empty array, no unique elements.")
            return 0
        }

        var leftPointer = 1 // Sets the leftPointer to the minimum value (1).

        // Loop through nums array, starting from 1 until the size of nums array.
        for (rightPointer in 1 until nums.size) {
            // If the rightPointer position at nums is not equal than the previous rightPointer at nums value, this is a
            // unique value, so we update the nums IntArray at position leftPointer. Then the leftPointer position value
            // is incremented.
            if (nums[rightPointer] != nums[rightPointer - 1]) {
                nums[leftPointer] = nums[rightPointer]
                leftPointer++
                println("Unique value found, leftPointer: $leftPointer, index: $rightPointer")
            } else {
                println("Duplicate value found: ${nums[rightPointer]}, leftPointer: $leftPointer, index: $rightPointer")
            }
        }
        println("\nDuplicates removed, IntArray is: ${nums.toSet()}\n")
        return leftPointer
    }
}