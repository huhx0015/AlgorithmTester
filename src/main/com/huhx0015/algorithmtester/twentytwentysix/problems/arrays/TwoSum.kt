package com.huhx0015.algorithmtester.twentytwentysix.problems.arrays

/**
 * Problem: Two Sum
 * Difficulty: Easy
 *
 * Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
 *
 * You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
 *
 * Return the answer with the smaller index first.
 *
 * Example 1:
 *
 * Input:
 * nums = [3,4,5,6], target = 7
 *
 * Output: [0,1]
 * Explanation: nums[0] + nums[1] == 7, so we return [0, 1].
 *
 * Example 2:
 *
 * Input: nums = [4,5,6], target = 10
 *
 * Output: [0,2]
 * Example 3:
 *
 * Input: nums = [5,5], target = 10
 *
 * Output: [0,1]
 * Constraints:
 *
 * 2 <= nums.length <= 1000
 * -10,000,000 <= nums[i] <= 10,000,000
 * -10,000,000 <= target <= 10,000,000
 * Only one valid answer exists.
 *
 */
object TwoSum {

    @JvmStatic fun main(args: Array<String>) {
        val inputArray1 = intArrayOf(3, 4, 5, 6)
        val inputTarget1 = 7

        val output1 = twoSum(nums = inputArray1, target = inputTarget1)
        println("Two Sum: Two Sum Pair is: ${output1.toSet()}\n")

        val outputBruteForce1 = twoSumBruteForce(nums = inputArray1, target = inputTarget1)
        println("Two Sum (Brute Force): Two Sum Pair is: ${outputBruteForce1.toSet()}\n")

        val inputArray2 = intArrayOf(4, 5, 6)
        val inputTarget2 = 10

        val output2 = twoSum(nums = inputArray2, target = inputTarget2)
        println("Two Sum: Two Sum Pair is: ${output2.toSet()}\n")

        val outputBruteForce2 = twoSumBruteForce(nums = inputArray2, target = inputTarget2)
        println("Two Sum (Brute Force): Two Sum Pair is: ${outputBruteForce2.toSet()}\n")

        val inputArray3 = intArrayOf(5, 5)
        val inputTarget3 = 10

        val output3 = twoSum(nums = inputArray3, target = inputTarget3)
        println("Two Sum: Two Sum Pair is: ${output3.toSet()}\n")

        val outputBruteForce3 = twoSumBruteForce(nums = inputArray3, target = inputTarget3)
        println("Two Sum (Brute Force): Two Sum Pair is: ${outputBruteForce3.toSet()}\n")
    }

    // twoSum(): Using HashMap solution to store all values. Time complexity: O(n) | Space complexity: O(n)
    fun twoSum(nums: IntArray, target: Int): IntArray {
        println("Two Sum: Starting with nums ${nums.toSet()} with target $target")

        // HashMap used to store the values of the nums array as we traverse through it.
        val numsValueMap: HashMap<Int, Int> = hashMapOf()

        for (i in 0 until nums.size) {
            // Difference Value Logic: For each number nums[i], we look for target - nums[i] in the map.
            val differenceValue = target - nums[i] // Subtracts the target value from nums[i].
            println("Two Sum: i is $i with target $target - nums[i] ${nums[i]} = complement value of $differenceValue")

            if (numsValueMap.containsKey(differenceValue)) {
                // We return [map[differenceValue], i] to ensure smaller index comes first.
                val twoSumPair = intArrayOf(numsValueMap[differenceValue]!!, i)
                println("Two Sum: Found the two sum pair [$differenceValue, $i] that sums up to target: $target")
                return twoSumPair
            }
            numsValueMap[nums[i]] = i // Updates the numsValueMap as we traverse through it.
        }
        return intArrayOf() // Returns an empty IntArray indicating that no two sum pair that sums up to target was found.
    }

    // twoSumBruteForce(): Brute Force approach. Time complexity: O(n²) | Space complexity: O(1)
    // INPUT: nums: Array of integers
    // INPUT: target: Integer value
    // OUTPUT: indices i and j where nums[i] + nums[j] == target and i != j
    // ASSUMPTION: Every input has exactly one pair of indicies i and j that satisfy the condition.
    // APPROACH: Brute Force
    fun twoSumBruteForce(nums: IntArray, target: Int): IntArray {
        println("Two Sum (Brute Force): Starting with nums ${nums.toSet()} with target $target")

        for (i in 0 until nums.size) {
            println("Two Sum (Brute Force): Loop for i at $i...")

            // j starts at 1 so that it is ahead of i and due to the condition i != j, so it we don't need to start the
            // loop with i = 0 and j = 0.
            for (j in 1 until nums.size) {
                // Checks if i not equal to j first.
                if (i != j) {
                    val currentSum = nums[i] + nums[j] // Current sum of nums[i] + nums[j]
                    println("Two Sum (Brute Force): currentSum: $currentSum, is it equal to target: $target")

                    if (currentSum == target) {
                        val twoSumPair = intArrayOf(i, j)
                        println("Two Sum (Brute Force): Found the two sum pair [$i, $j] that sums up to target: $target")
                        return twoSumPair // We found the two sum pair, so we return early.
                    }
                } else {
                    println("Two Sum (Brute Force): i $i is equal to j $j, proceeding to next loop for j...")
                }
            }
        }

        return intArrayOf() // Returns an empty IntArray indicating that no two sum pair that sums up to target was found.
    }
}