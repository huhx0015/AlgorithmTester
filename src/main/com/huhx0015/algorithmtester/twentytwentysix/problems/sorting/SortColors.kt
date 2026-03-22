package com.huhx0015.algorithmtester.twentytwentysix.problems.sorting

import java.util.TreeMap

/**
 * Problem: Sort Colors
 * Difficulty: Medium
 *
 * You are given an array nums consisting of n elements where each element is an integer representing a color:
 *
 * 0 represents red
 * 1 represents white
 * 2 represents blue
 * Your task is to sort the array in-place such that elements of the same color are grouped together and arranged in the order: red (0), white (1), and then blue (2).
 *
 * You must not use any built-in sorting functions to solve this problem.
 *
 * Example 1:
 *
 * Input: nums = [1,0,1,2]
 *
 * Output: [0,1,1,2]
 * Example 2:
 *
 * Input: nums = [2,1,0]
 *
 * Output: [0,1,2]
 * Constraints:
 *
 * 1 <= nums.length <= 300.
 * 0 <= nums[i] <= 2.
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
object SortColors {

    // Constant values to represent the colors used in SortColors.
    private const val VAL_RED = 0
    private const val VAL_WHITE = 1
    private const val VAL_BLUE = 2

    @JvmStatic fun main(args: Array<String>) {
        val inputColorArrayDutch1 = intArrayOf(1, 0, 1, 2)
        val inputColorArrayDutch2 = intArrayOf(2, 1, 0)

        sortColors(inputColorArrayDutch1)
        println("inputColorArrayDutch1: ${inputColorArrayDutch1.toList()}\n")

        sortColors(inputColorArrayDutch2)
        println("inputColorArrayDutch1: ${inputColorArrayDutch2.toList()}\n")

        val inputColorArrayTreeMap1 = intArrayOf(1, 0, 1, 2)
        val inputColorArrayTreeMap2 = intArrayOf(2, 1, 0)

        sortColorsTreeMap(inputColorArrayTreeMap1)
        println("inputColorArrayTreeMap1: ${inputColorArrayDutch1.toList()}\n")

        sortColorsTreeMap(inputColorArrayTreeMap2)
        println("inputColorArrayTreeMap2: ${inputColorArrayDutch2.toList()}\n")
    }

    // sortColors(): Uses the three pointer solution, the Dutch National Flag algorithm.
    // Time Complexity: O(n) | Space Complexity: O(1)
    fun sortColors(nums: IntArray) {

        var lowPointer = 0 // Tracks where next 0 should go.
        var midPointer = 0 // Current element being examined.
        var highPointer = nums.size - 1 // Tracks where next 2 should go

        while (midPointer <= highPointer) {

            // If nums[mid] == 0, swap with low, increment both
            // If nums[mid] == 1, just increment mid
            // If nums[mid] == 2, swap with high, decrement high
            when (nums[midPointer]) {
                VAL_RED -> {
                    println("Sort Colors (Dutch): WHILE: nums[midPointer] was RED (0), so midPointer $midPointer and lowPointer $lowPointer positions are swapped.")

                    nums[midPointer] = nums[lowPointer]
                    nums[lowPointer] = 0
                    lowPointer++
                    midPointer++
                }
                VAL_WHITE -> {
                    println("Sort Colors (Dutch): WHILE: nums[midPointer] was WHITE (1), so midPointer $midPointer is incremented to ${midPointer + 1}.")
                    midPointer++
                }
                VAL_BLUE -> {
                    println("Sort Colors (Dutch): WHILE: nums[midPointer] was BLUE (2), so midPointer $midPointer and highPointer $highPointer positions are swapped.")

                    nums[midPointer] = nums[highPointer]
                    nums[highPointer] = 2
                    highPointer--
                }
            }
        }

        println("Sort Colors (Dutch): Sorting colors has been completed.")
    }

    // sortColorsTreeMap(): Tree Map solution for sorting colors. However, this solution performs two passes, not one
    // pass.
    // Time Complexity: O(n) + O(n) = 0(n) | Space Complexity: O(k) = O(3) -> O(1)
    // Even though TreeMap is normally O(log n), here it's effectively constant because of only 3 keys.
    fun sortColorsTreeMap(nums: IntArray) {
        if (nums.isEmpty()) return

        val colorMap: TreeMap<Int, Int> = TreeMap() // Keys are sorted in TreeMap, maps color value to color count.

        // Traverses through the nums array to build the colorMap (TreeMap), with values and counts.
        for (i in 0 until nums.size) {
            val currentValue = nums[i] // Retrieves the current value in nums. Should be 0, 1, 2
            val currentCount = colorMap[currentValue] ?: 0 // Retrieves the current color count based on currentValue.
            colorMap[currentValue] = currentCount + 1 // Update the count value for the corresponding color.

            println("Sort Colors (Tree Map): FOR: currentValue is $currentValue and currentCount is $currentCount.")
        }

        var indexPointer = 0 // Used for traversing through the nums array while being updated.

        // Loops through the colorMap TreeMap to reassign all values in nums IntArray.
        colorMap.forEach { (key, value) ->

            // Uses the repeat function to repeat the number of times of value (since this is the count) to update the
            // nums array.
            repeat(value) {
                nums[indexPointer] = key
                println("Sort Colors (Tree Map): REPEAT: Color $key and count $value, updated nums at position $indexPointer with $key")
                indexPointer++
            }
        }

        println("Sort Colors (Tree Map): Sorting colors has been completed.")
    }
}