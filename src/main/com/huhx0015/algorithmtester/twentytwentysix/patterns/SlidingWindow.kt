package com.huhx0015.algorithmtester.twentytwentysix.patterns

/**
 * Pattern: Sliding Window
 * Data Structure: Arrays
 *
 *  * ------------------------------------------------------------------------------------------------------------------
 *
 * 🚦 Step 1: Trigger Words → Think Sliding Window
 *
 * If the problem mentions:
 *
 * “substring” / “subarray”
 * “contiguous”
 * “longest / shortest”
 * “at most k” / “at least k”
 * “replace / flip / remove k elements”
 *
 * 👉 Immediately consider Sliding Window
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🧩 Step 2: Identify the Type
 *
 * ✅ 1. Variable Window (MOST COMMON)
 *
 * Clue phrases:
 *
 * “longest substring without…”
 * “at most k…”
 * “no duplicates”
 * “valid window”
 *
 * 👉 Use:
 *
 * while (window is invalid) {
 *     left++
 * }
 *
 * 👉 Examples:
 *
 * Longest Substring Without Repeating Characters
 * Longest Repeating Character Replacement
 * Max Consecutive Ones III
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 📏 2. Fixed Window Size
 *
 * Clue phrases:
 *
 * “subarray of size k”
 * “average of k elements”
 * “maximum sum of size k”
 *
 * 👉 Use:
 *
 * if (right - left + 1 > k) {
 *     left++
 * }
 *
 * 👉 Examples:
 *
 * Maximum Sum Subarray of Size K
 * Sliding Window Maximum
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🔢 3. Sum-Based Window
 *
 * Clue phrases:
 *
 * “sum <= target”
 * “minimum size subarray sum”
 * “running total”
 *
 * 👉 Use:
 *
 * sum += nums[right]
 *
 * while (sum > target) {
 *     sum -= nums[left]
 *     left++
 * }
 *
 * 👉 Examples:
 *
 * Minimum Size Subarray Sum
 * Subarrays with Sum ≤ K
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🔤 4. Frequency Map / Counting
 *
 * Clue phrases:
 *
 * “anagram”
 * “permutation”
 * “character replacement”
 * “count of characters”
 *
 * 👉 Use:
 *
 * val map = mutableMapOf<Char, Int>()
 *
 * 👉 Examples:
 *
 * Minimum Window Substring
 * Find All Anagrams in a String
 * Permutation in String
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * ⚖️ Step 3: Sliding Window vs Similar Patterns
 * 🆚 Sliding Window vs Two Pointers
 * Pattern	Use When
 * Sliding Window	Contiguous + dynamic resizing
 * Two Pointers	Sorted arrays OR moving inward (not maintaining a window)
 *
 * 👉 Example:
 *
 * Sorted array + target sum → Two pointers
 * Subarray longest condition → Sliding window
 * 🆚 Sliding Window vs Prefix Sum
 * Pattern	Use When
 * Sliding Window	Positive numbers / controllable shrinking
 * Prefix Sum	Negative numbers OR exact sum counts
 *
 * 👉 Example:
 *
 * sum == k with negatives → Prefix Sum
 * sum <= k with positives → Sliding Window
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🧠 Step 4: Core Template (Memorize This)
 * var left = 0
 *
 * for (right in nums.indices) {
 *     // expand window
 *
 *     while (window is invalid) {
 *         // shrink window
 *         left++
 *     }
 *
 *     // update result
 * }
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * ⚡ Step 5: What Changes Per Problem?
 *
 * Only 3 things change:
 *
 * Part	What You Customize
 * Expand	Add element (map, sum, set)
 * Condition	What makes window invalid
 * Result	max / min / count
 *
 * Everything else is identical.
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🔥 Instant Pattern Recognition (Interview Speed Mode)
 *
 * When reading a problem, run this:
 *
 * Is it contiguous?
 * → Yes → keep going
 * Am I finding longest/shortest/count?
 * → Yes → sliding window likely
 * Can I shrink the window logically?
 * → Yes → LOCK IN sliding window
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * ❌ When NOT to Use Sliding Window
 *
 * Avoid sliding window if:
 *
 * Array contains negative numbers (for sum problems)
 * Problem asks for all combinations/subsets
 * It’s not contiguous
 * Requires exact matching across whole array
 */
class SlidingWindow {

    fun slidingWindow(nums: IntArray): Int {
        var left = 0 // Left pointer: start of the sliding window
        var result = 0 // Stores the final answer (e.g., max length, min length, etc.)

        // Map to track frequency of elements inside the current window
        // Only needed for problems involving counts (e.g., duplicates, anagrams)
        val windowMap = mutableMapOf<Int, Int>()

        // Right pointer expands the window one element at a time
        for (right in nums.indices) {
            val current = nums[right] // Current element entering the window

            // 1. Expand window (include right pointer)
            // Add/update the frequency of the current element
            windowMap[current] = windowMap.getOrDefault(current, 0) + 1

            // 2. Shrink window if condition is violated
            // This loop ensures the window remains valid
            while ( true /* replace with window is invalid */) {
                val leftVal = nums[left] // Element that will be removed from the window

                // Decrease frequency of the leftmost element
                windowMap[leftVal] = windowMap[leftVal]!! - 1

                // If frequency becomes 0, remove it from the map to keep it clean
                if (windowMap[leftVal] == 0) {
                    windowMap.remove(leftVal)
                }

                left++ // Move left pointer forward to shrink the window
            }

            // 3. Update result (max/min/length/etc.)
            // Example here: tracking the maximum window size
            // right - left + 1 gives the current window length
            result = maxOf(result, right - left + 1)
        }

        return result // Return the computed result
    }
}