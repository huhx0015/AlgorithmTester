package com.huhx0015.algorithmtester.twentytwentysix.problems.arrays

/**
 * NeetCode.io
 *
 * Problem: Concatenation of Array
 * Difficulty: Easy
 *
 * You are given an integer array nums of length n. Create an array ans of length 2n where ans[i] == nums[i] and
 * ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
 *
 * Specifically, ans is the concatenation of two nums arrays.
 *
 * Return the array ans.
 *
 * Example 1:
 *
 * Input: nums = [1,4,1,2]
 *
 * Output: [1,4,1,2,1,4,1,2]
 * Example 2:
 *
 * Input: nums = [22,21,20,1]
 *
 * Output: [22,21,20,1,22,21,20,1]
 * Constraints:
 *
 * 1 <= nums.length <= 1000.
 * 1 <= nums[i] <= 1000
 */
object ConcatenationOfArray {

    @JvmStatic fun main(args: Array<String>) {
        val input1 = intArrayOf(1, 4, 1, 2)
        println("Input 1: ${input1.toList()}\n")
        val input1Result = getConcatenation(input1)
        println("Concatenated arrays: ${input1Result.toList()}\n")

        val input2 = intArrayOf(22, 21, 20, 1)
        println("Input 2: ${input2.toList()}\n")
        val input2Result = getConcatenation(input2)
        println("Concatenated arrays: ${input2Result.toList()}\n")
    }

    fun getConcatenation(nums: IntArray): IntArray {
        if (nums.isEmpty()) return nums // If nums is empty, return the original nums array.

        val newArray = IntArray(nums.size * 2) // Initialize a new IntArray that is double the size of nums.

        // Iterate through nums array, add all original elements to the newArray. At the same time, add the same value
        // at position index + nums.size (position of the second half of the array relative to the original).
        nums.forEachIndexed { index, value ->
            newArray[index] = value // Copy the original value to the same position in the new array.
            newArray[index + nums.size] = value // Copy the value to the second half of the new array.
        }
        return newArray
    }
}