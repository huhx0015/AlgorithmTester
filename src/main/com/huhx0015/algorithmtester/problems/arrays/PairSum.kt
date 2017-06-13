package main.com.huhx0015.algorithmtester.problems.arrays

import java.awt.*
import java.util.HashMap

/**
 * Created by Michael Yoon Huh on 5/22/2017.
 *
 * Find all unique pairs in the array that are the sum of the magic number. All numbers in the array are unique.
 *
 * input: [1,3,5,7]
 * output: [1,3] [3,5] [5,7]
 */
object PairSum {

    @JvmStatic fun main(args: Array<String>) {
        val inputArray = intArrayOf(1, 3, 5, 7)
        findPairsBruteForce(inputArray, 8)
    }

    // O(n) Solution:
    fun findPairs(nums: IntArray, magicNum: Int) {

        if (nums.size < 2) {
            return
        }

        val set = HashMap<Int, Boolean>()

        for (i in nums.indices) {
            set.put(i, true)
        }

        // Remove the x from the set. If number was already used, we mark it as false.
        for (i in 0..set.size - 1) {
            val x = magicNum - nums[i] // Finds the difference and sees if that number exists.

            if (set.containsKey(x) && set[x] as Boolean) {
                println("[" + nums[i] + "," + x + "]")
                set.put(x, false) // Marks the value as already being used.
            }
        }
    }

    // Bruteforce Method
    // Runtime: O(n^2)
    fun findPairsBruteForce(nums: IntArray, magicNum: Int) {

        if (nums.size < 2) {
            return
        }

        val sumPairs = HashMap<Point, Boolean>()

        for (i in nums.indices) {
            for (j in i + 1..nums.size - 1) {
                if (nums[i] + nums[j] == magicNum) {
                    if (magicNum - nums[i] == nums[j]) {
                        val point = Point(nums[i], nums[j])
                        sumPairs.put(point, true)
                    }
                }
            }

            for ((key) in sumPairs) {
                println("[" + key.x + "," + key.y + "]")
            }
        }
    }
}
