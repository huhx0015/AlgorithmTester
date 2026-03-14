package com.huhx0015.algorithmtester.twentytwentysix.problems.recursion

/**
 * NeetCode
 *
 * Problem: Climbing Stairs
 * Difficulty: Easy
 * Type: Recursive, Dynamic Programming
 *
 * You are given an integer n representing the number of steps to reach the top of a staircase. You can climb with either 1 or 2 steps at a time.
 *
 * Return the number of distinct ways to climb to the top of the staircase.
 *
 * Example 1:
 *
 * Input: n = 2
 *
 * Output: 2
 * Explanation:
 *
 * 1 + 1 = 2
 * 2 = 2
 * Example 2:
 *
 * Input: n = 3
 *
 * Output: 3
 * Explanation:
 *
 * 1 + 1 + 1 = 3
 * 1 + 2 = 3
 * 2 + 1 = 3
 * Constraints:
 *
 * 1 <= n <= 45
 *
 * Hint: Bottom Up Dynamic Programming Problem
 *
 * Visual Example: Think of a tree structure, with 1 or 2 as decisions.
 *
 *                            n = 5
 *                              0
 *                      1                  2
 *                  2         3         3       4
 *               3    4    4   *5    4   *5  *5  x
 *            4   *5 *5 x *5 x     *5 x
 *          *5 x
 *                          Answer = 8
 */
object ClimbingStairs {

    @JvmStatic fun main(args: Array<String>) {
        val climbStairsRecursive1 = climbStairsRecursive(1)
        println("Climb Stairs (Recursive) for n=1: $climbStairsRecursive1")

        val climbStairsRecursive2 = climbStairsRecursive(2)
        println("Climb Stairs (Recursive) for n=2: $climbStairsRecursive2")

        val climbStairsRecursive3 = climbStairsRecursive(3)
        println("Climb Stairs (Recursive) for n=3: $climbStairsRecursive3")

        val climbStairsRecursive4 = climbStairsRecursive(4)
        println("Climb Stairs (Recursive) for n=4: $climbStairsRecursive4")

        val climbStairsRecursive5 = climbStairsRecursive(5)
        println("Climb Stairs (Recursive) for n=5: $climbStairsRecursive5")

        val climbStairsDp1 = climbStairsDp(1)
        println("Climb Stairs (Dynamic Programming) for n=1: $climbStairsDp1")

        val climbStairsDp2 = climbStairsDp(2)
        println("Climb Stairs (Dynamic Programming) for n=2: $climbStairsDp2")

        val climbStairsDp3 = climbStairsDp(3)
        println("Climb Stairs (Dynamic Programming) for n=3: $climbStairsDp3")

        val climbStairsDp4 = climbStairsDp(4)
        println("Climb Stairs (Dynamic Programming) for n=4: $climbStairsDp4")

        val climbStairsDp5 = climbStairsDp(5)
        println("Climb Stairs (Dynamic Programming) for n=5: $climbStairsDp5")

        val climbStairsMemo1 = climbStairsMemoization(1)
        println("Climb Stairs (Memoization) for n=1: $climbStairsMemo1")

        val climbStairsMemo2 = climbStairsMemoization(2)
        println("Climb Stairs (Memoization) for n=2: $climbStairsMemo2")

        val climbStairsMemo3 = climbStairsMemoization(3)
        println("Climb Stairs (Memoization) for n=3: $climbStairsMemo3")

        val climbStairsMemo4 = climbStairsMemoization(4)
        println("Climb Stairs (Memoization) for n=4: $climbStairsMemo4")

        val climbStairsMemo5 = climbStairsMemoization(5)
        println("Climb Stairs (Memoization) for n=5: $climbStairsMemo5")
    }

    // Time Complexity: O(2n) | Space Complexity: O(n): Recursive "Fibonacci" Approach.
    fun climbStairsRecursive(n: Int): Int {
        // Base case: n = 0 (0 steps), n = 1 (1 step), n = 2 (2 steps)
        // Recursion stops here once n reaches these values.
        if (n <= 2) return n

        // Recursively call climbStairsRecursive for the next level in the tree.
        return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2)
    }

    // Time Complexity: O(n) | Space Complexity: O(1): Dynamic Programming
    fun climbStairsDp(n: Int): Int {
        // Base case: n = 0 (0 steps), n = 1 (1 step), n = 2 (2 steps)
        if (n <= 2) return n

        var oneStep = 2
        var twoSteps = 1

        for (i in 3..n) {
            val current = oneStep + twoSteps
            twoSteps = oneStep
            oneStep = current
        }

        return oneStep
    }

    // Time Complexity: O(n) | Space Complexity: O(n): Memoization
    fun climbStairsMemoization(n: Int): Int {
        val memoCache = IntArray(n + 1) { -1 }

        // Depth First Search helper function.
        fun dfs(i: Int): Int {
            if (i <= 2) return i // Base case: i = 0 (0 steps), i = 1 (1 step), i = 2 (2 steps)
            if (memoCache[i] != -1) return memoCache[i]

            memoCache[i] = dfs(i - 1) + dfs(i - 2) // Fibonacci pattern.
            return memoCache[i]
        }

        return dfs(n)
    }
}