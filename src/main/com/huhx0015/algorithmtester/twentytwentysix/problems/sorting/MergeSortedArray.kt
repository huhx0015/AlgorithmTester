package com.huhx0015.algorithmtester.twentytwentysix.problems.sorting

/**
 * Problem: Merge Sorted Array
 * Difficulty: Easy
 *
 * You are given two integer arrays nums1 and nums2, both sorted in non-decreasing order, along with two integers m and n, where:
 *
 * m is the number of valid elements in nums1,
 * n is the number of elements in nums2.
 * The array nums1 has a total length of (m+n), with the first m elements containing the values to be merged, and the last n elements set to 0 as placeholders.
 *
 * Your task is to merge the two arrays such that the final merged array is also sorted in non-decreasing order and stored entirely within nums1.
 * You must modify nums1 in-place and do not return anything from the function.
 *
 * Example 1:
 *
 * Input: nums1 = [10,20,20,40,0,0], m = 4, nums2 = [1,2], n = 2
 *
 * Output: [1,2,10,20,20,40]
 * Example 2:
 *
 * Input: nums1 = [0,0], m = 0, nums2 = [1,2], n = 2
 *
 * Output: [1,2]
 * Constraints:
 *
 * 0 <= m, n <= 200
 * 1 <= (m + n) <= 200
 * nums1.length == (m + n)
 * nums2.length == n
 * -1,000,000,000 <= nums1[i], nums2[i] <= 1,000,000,000
 *
 *
 */
object MergeSortedArray {

    @JvmStatic fun main(args: Array<String>) {
        val inputIntArray1 = intArrayOf(10, 20, 20, 40, 0, 0)
        val inputIntArray2 = intArrayOf(1, 2)
        val m = 4
        val n = 2
        merge(nums1 = inputIntArray1, m = m, nums2 = inputIntArray2, n = n)
    }

    // merge(): Uses the three pointer strategy. Time Efficiency: O(m +n) | Space Efficiency: O(1)
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        println("MergeSortedArray: Starting with nums1 ${nums1.toSet()} with number of elements $m, nums2 ${nums2.toSet()} with size $n.")
        if (nums1.isEmpty() && nums2.isEmpty()) return // Early return if both arrays are empty.
        if (m + n > nums1.size) return // If the combined sum of m + n is greater than the size of nums1, return early.

        // Use a three pointer iteration.
        var pointer1 = m - 1 // Points to the last valid element in nums1 (index m - 1)
        var pointer2 = n - 1 // Points to the last element in nums2 (index n - 1)
        var pointer3 = m + n - 1 // Points to the last position in nums1 (index m + n - 1)
        println("MergeSortedArray: pointer1: $pointer1, pointer2: $pointer2, pointer3: $pointer3")

        while (pointer1 >= 0 && pointer2 >= 0) {
            println("MergeSortedArray: WHILE 1: nums1[pointer1]: ${nums1[pointer1]} | nums2[pointer2]: ${nums2[pointer2]} | pointer3: $pointer3")

            // Compare elements at pointer1 and pointer2, places the larger element at position pointer3
            // Move pointers accordingly, continue until one array is exhausted
            if (nums1[pointer1] > nums2[pointer2]) {
                val value = nums1[pointer1]
                nums1[pointer3] = value
                pointer1--
                println("MergeSortedArray: WHILE 1: nums1[pointer1] > nums2[pointer2], placed $value at nums1[$pointer3].")
            } else {
                val value = nums2[pointer2]
                nums1[pointer3] = value
                pointer2--
                println("MergeSortedArray: WHILE 1: nums1[pointer1] <= nums2[pointer2], placed $value at nums1[$pointer3].")
            }
            pointer3--
        }

        // If nums2 still has elements, they are smaller than everything else and should be moved to the front.
        while (pointer2 >= 0) {
            val value = nums2[pointer2]
            val destIndex = pointer3
            nums1[pointer3] = value
            pointer2--
            pointer3--
            println("MergeSortedArray: WHILE 2: Copying element $value from nums2 to nums1[$destIndex].")
        }

        println("MergeSortedArray complete, sorted array is: ${nums1.toSet()}")
    }
}