package com.huhx0015.algorithmtester.twentytwentysix.problems.arrays

/**
 * NeetCode.io
 *
 * Remove Element
 * EASY
 *
 * You are given an integer array nums and an integer val. Your task is to remove all occurrences of val from nums
 * in-place.
 *
 * After removing all occurrences of val, return the number of remaining elements, say k, such that the first k elements
 * of nums do not contain val.
 *
 * Note:
 *
 * The order of the elements which are not equal to val does not matter.
 * It is not necessary to consider elements beyond the first k positions of the array.
 * To be accepted, the first k elements of nums must contain only elements not equal to val.
 * Return k as the final result.
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,3,4], val = 1
 *
 * Output: [2,3,4]
 * Explanation: You should return k = 3 as we have 3 elements which are not equal to val = 1.
 *
 * Example 2:
 *
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 *
 * Output: [0,1,3,0,4]
 * Explanation: You should return k = 5 as we have 5 elements which are not equal to val = 2.
 *
 * Constraints:
 *
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */

object RemoveElement {

    @JvmStatic fun main(args: Array<String>) {
        val inputArray1 = intArrayOf(1, 1, 2, 3, 4)
        val inputValueToRemove1 = 1

        println("Removing $inputValueToRemove1 from ${inputArray1.toList()}, remaining elements ${removeElement(nums = inputArray1, valueToRemove = inputValueToRemove1)}\n")

        val inputArray2 = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
        val inputValueToRemove2 = 2

        println("Removing $inputValueToRemove2 from ${inputArray2.toList()}, remaining elements ${removeElement(nums = inputArray1, valueToRemove = inputValueToRemove2)}")
    }

    fun removeElement(nums: IntArray, valueToRemove: Int): Int {
        if (nums.isEmpty()) return 0 // If the IntArray is empty, we return 0, since there are no unique elements.
        var pointer = 0 // Pointer to track the position of elements that are NOT valueToRemove.

        for ((index, value) in nums.withIndex()) {
            if (value != valueToRemove) {
                nums[pointer] = value // Move the valid element to the 'pointer' position
                pointer++ // Increment the count of valid elements
                println("Value $value at index $index does not match value to remove $valueToRemove. Pointer is now $pointer")
            } else {
                println("Value $value at index $index matches value to remove $valueToRemove, skipping.")
            }
        }
        return pointer
    }
}