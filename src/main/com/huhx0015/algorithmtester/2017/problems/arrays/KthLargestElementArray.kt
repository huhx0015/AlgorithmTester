package main.com.huhx0015.algorithmtester.problems.arrays

import java.util.Arrays
import java.util.PriorityQueue

/**
 * LeetCode

 * 215. Kth Largest Element in an Array

 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not
 * the kth distinct element.

 * FURTHER EXPLANATION: Imagine the array being sorted first. Then find the kth from the last. That is the largest
 * element in the array.

 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.

 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.

 * Reference: https://leetcode.com/problems/kth-largest-element-in-an-array/#/description

 */
object KthLargestElementArray {

    @JvmStatic fun main(args: Array<String>) {

        val testArray = intArrayOf(3, 2, 1, 5, 6, 4)
        val testK = 2

        val largestElement = findKthLargest(testArray, testK)
        println("Largest Element: " + largestElement)
    }

    // Finds kth using built-in sort.
    fun findKthLargestUsingSort(nums: IntArray?, kth: Int): Int {

        // Input check.
        if (nums == null || kth > nums.size) {
            println("ERROR: Invalid input.")
            return -1
        }

        Arrays.sort(nums)
        return nums[nums.size - kth]
    }

    // Finds kth using PriorityQueue.
    fun findKthLargest(nums: IntArray, kth: Int): Int {

        val queue = PriorityQueue<Int>()

        for (`val` in nums) {
            println("Current Value: " + `val`)

            queue.offer(`val`) // Inserts element into priority queue (like push).

            if (queue.size > kth) {
                val pollValue = queue.poll() // The method call returns and removes head of the queue.
                println("Poll Value: " + pollValue)
            }

            val peekValue = queue.peek()
            println("Peek Value: " + peekValue + "\n")
        }
        return queue.peek()
    }
}
