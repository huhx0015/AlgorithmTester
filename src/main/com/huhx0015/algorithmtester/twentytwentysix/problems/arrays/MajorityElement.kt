package com.huhx0015.algorithmtester.twentytwentysix.problems.arrays

/**
 * Leetcode.io
 *
 * Problem: Majority Element
 * Difficulty: Easy
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times in the array. You may assume that the
 * majority element always exists in the array.
 *
 * Example 1:
 * Input: nums = [5,5,1,1,1,5,5]
 * Output: 5
 *
 * Example 2:
 * Input: nums = [2,2,2]
 * Output: 2
 *
 * Constraints:
 *
 * 1 <= nums.length <= 50,000
 * -1,000,000,000 <= nums[i] <= 1,000,000,000
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
object MajorityElement {

    @JvmStatic fun main(args: Array<String>) {
        val input1 = intArrayOf(5, 5, 1, 1, 1, 5, 5)
        val input2 = intArrayOf(2, 2, 2)
        val result1 = majorityElement(nums = input1)
        val result2 = majorityElement(nums = input2)

        println("Majority Element: Majority element for ${input1.toList()} is $result1\n")
        println("Majority Element: Majority element for ${input2.toList()} is $result2")
    }

    fun majorityElement(nums: IntArray): Int {
        if (nums.isEmpty()) {
            println("Majority Element: nums is empty, returning 0")
            return 0
        }

        val elementCountMap: HashMap<Int, Int> = HashMap() // HashMap used to keep count of elements.
        var largestElementCountPair: Pair<Int, Int> = Pair(nums[0], 0) // References the element with the highest count.

        // Loops through the nums array, updating elementCountMap and largestElementCountPair.
        for (i in 0 until nums.size) {
            val currentNums = nums[i]
            val currentElementCount = elementCountMap[currentNums] ?: 0

            println("Majority Element: FOR: Current index i is $i, current num value is $currentNums, current element for num is $currentElementCount")

            if (currentElementCount > largestElementCountPair.second) {
                largestElementCountPair = Pair(currentNums, currentElementCount)
                println("Majority Element: FOR: New largest element count value found, element is $currentNums with count $currentElementCount")
            }
            elementCountMap[currentNums] = currentElementCount + 1
        }

        println("Majority Element: Largest element is ${largestElementCountPair.first} with count ${largestElementCountPair.second}")
        return largestElementCountPair.first
    }
}