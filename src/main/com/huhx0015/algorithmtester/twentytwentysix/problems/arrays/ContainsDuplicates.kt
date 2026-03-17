package com.huhx0015.algorithmtester.twentytwentysix.problems.arrays

/**
 * NeetCode.io
 *
 * Problem: Contains Duplicate
 * Difficulty: Easy
 *
 * Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [1, 2, 3, 3]
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [1, 2, 3, 4]
 *
 * Output: false
 */
object ContainsDuplicates {

    @JvmStatic fun main(args: Array<String>) {
        val input1 = intArrayOf(1, 2, 3, 3)
        val input2 = intArrayOf(1, 2, 3, 4)

        val result1 = hasDuplicate(input1)
        println("Contains Duplicate: Duplicate for input1: $result1\n")
        val result2 = hasDuplicate(input2)
        println("Contains Duplicate: Duplicate for input2: $result2")
    }

    // hasDuplicate(): Time Complexity: O(n) | Space Complexity: O(n)
    fun hasDuplicate(nums: IntArray): Boolean {
        println("Contains Duplicates: Starting hasDuplicate with input nums...")
        val valueHashMap: HashSet<Int> = hashSetOf() // Initializes a HashSet to store the values as we traverse the nums array.

        for (i in nums.indices) {
            val currentValue = nums[i] // The currentValue in nums array at position i.
            println("Contains Duplicates: Current loop i $i with currentValue $currentValue from nums[i]")

            // Check the valueHashMap to see if the current value exists. If not, we store the value in the valueHashMap.
            if (valueHashMap.contains(currentValue)) {
                println("Contains Duplicates: Found a duplicate value at i $i with currentValue $currentValue a duplicate in valueHashMap $valueHashMap")
                return true
            }
            println("Contains Duplicates: Adding currentValue $currentValue to the valueHashMap: ${valueHashMap}")
            valueHashMap.add(currentValue) // Adds the currentValue to the HashSet.
        }

        println("Contains Duplicates: Failed to find a duplicate in nums.")
        return false
    }
}