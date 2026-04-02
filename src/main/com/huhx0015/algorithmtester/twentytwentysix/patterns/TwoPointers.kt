package com.huhx0015.algorithmtester.twentytwentysix.patterns

/**
 * Pattern: Two Pointer
 * Data Structure: Arrays
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🚦 Step 1: Trigger Words → Think Two Pointers
 *
 * If the problem mentions:
 *
 * “sorted array”
 * “find two numbers / pair / triplet”
 * “sum equals target”
 * “palindrome”
 * “in-place modification”
 * “remove duplicates”
 *
 * 👉 Immediately consider Two Pointers
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🧩 Step 2: Identify the Type
 *
 * 🔁 1. Opposite Ends (Most Common)
 *
 * 📌 Pattern
 * var left = 0
 * var right = nums.lastIndex
 *
 * while (left < right) {
 *     if (condition) {
 *         left++
 *         right--
 *     } else if (need bigger) {
 *         left++
 *     } else {
 *         right--
 *     }
 * }
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🧠 Recognition Clues
 * Array is sorted
 * Looking for pair with target sum
 * Comparing both ends
 * Want to narrow search space
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🔥 Classic Problems
 * Two Sum II (sorted)
 * Container With Most Water
 * 3Sum (outer loop + two pointers inside)
 * Trapping Rain Water (variant logic)
 * ⚡ Movement Rule (Critical Insight)
 * Situation	Move
 * Need bigger value	left++
 * Need smaller value	right--
 * Found valid pair	usually both
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🏃 2. Same Direction (Fast & Slow Pointers)
 *
 * 📌 Pattern
 * var left = 0
 *
 * for (right in nums.indices) {
 *     if (/* condition */) {
 *         nums[left] = nums[right]
 *         left++
 *     }
 * }
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🧠 Recognition Clues
 * “modify array in-place”
 * “remove duplicates”
 * “compress array”
 * “return new length”
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🔥 Classic Problems
 * Remove Duplicates from Sorted Array
 * Move Zeroes
 * Remove Element
 * ⚡ Mental Model
 * right → scans everything
 * left → builds valid result
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🔤 3. Palindrome / Symmetry
 *
 * 📌 Pattern
 * var left = 0
 * var right = s.lastIndex
 *
 * while (left < right) {
 *     if (s[left] != s[right]) return false
 *     left++
 *     right--
 * }
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🧠 Recognition Clues
 * “palindrome”
 * “mirror / symmetric”
 * compare front vs back
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🔥 Classic Problems
 * Valid Palindrome
 * Longest Palindromic Substring (helper)
 * Palindrome Linked List
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🔺 4. Nested Two Pointers (3Sum / kSum)
 *
 * 📌 Pattern
 * for (i in nums.indices) {
 *     var left = i + 1
 *     var right = nums.lastIndex
 *
 *     while (left < right) {
 *         val sum = nums[i] + nums[left] + nums[right]
 *
 *         if (sum == target) {
 *             left++
 *             right--
 *         } else if (sum < target) {
 *             left++
 *         } else {
 *             right--
 *         }
 *     }
 * }
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🧠 Recognition Clues
 * “triplets”
 * “three numbers sum”
 * “k numbers sum”
 * usually requires sorting first
 * ⚖️ Step 3: Two Pointers vs Sliding Window
 * Pattern	Use When
 * Two Pointers	Comparing elements at different positions
 * Sliding Window	Maintaining a valid contiguous window
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🔥 Quick Decision Rule
 *
 * Ask:
 *
 * 👉 “Am I maintaining a window?”
 * YES → Sliding Window
 * NO → keep going
 * 👉 “Am I comparing two indices?”
 * YES → Two Pointers
 * Example
 * Longest substring → Sliding Window
 * Pair sum in sorted array → Two Pointers
 * ⚖️ Step 4: Two Pointers vs Prefix Sum
 * Pattern	Use When
 * Two Pointers	Sorted + pair/triplet
 * Prefix Sum	Sum queries, negative numbers, exact counts
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * ❌ When NOT to Use Two Pointers
 *
 * Avoid if:
 *
 * Array is unsorted (unless you sort first)
 * Need all combinations/subsets
 * Requires global state (DP/graph)
 * ⚡ Step 5: Instant Pattern Recognition (Interview Mode)
 *
 * Run this mental checklist:
 *
 * Is the array sorted?
 * Am I looking for pairs/triplets?
 * Can I eliminate options by moving pointers?
 *
 * 👉 If YES → Two Pointers
 *
 * 🧠 Movement Heuristics (Memorize This)
 * For sums:
 * sum < target → move left++
 * sum > target → move right--
 * For area/max problems:
 * move the limiting factor (usually smaller value)
 * For in-place:
 * right scans, left writes
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🧩 Master Minimal Template
 *
 * var left = 0
 * var right = nums.lastIndex
 *
 * while (left < right) {
 *     val value = nums[left] + nums[right]
 *
 *     if (value == target) {
 *         // found answer
 *         left++
 *         right--
 *     } else if (value < target) {
 *         left++
 *     } else {
 *         right--
 *     }
 * }
 */
class TwoPointers {

    fun twoPointers(nums: IntArray): Int {
        var left = 0 // Pointer starting at the beginning
        var right = nums.lastIndex // Pointer starting at the end

        while (left < right) { // Continue until pointers meet
            val leftVal = nums[left] // Value at left pointer
            val rightVal = nums[right] // Value at right pointer

            // 1. Check condition (depends on problem)
            if ( true /* replace with condition met */) {
                // Do something (return, count, update result)

                left++ // Move left inward
                right-- // Move right inward
            } else if ( false /* replace with need a larger value */) {
                left++ // Move left to increase value
            } else {
                right-- // Move right to decrease value
            }
        }

        return -1 // Default return if needed
    }
}