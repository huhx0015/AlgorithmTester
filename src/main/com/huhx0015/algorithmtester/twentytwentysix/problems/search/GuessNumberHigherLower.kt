package com.huhx0015.algorithmtester.twentytwentysix.problems.search

/**
 * Problem: Guess Number Higher Or Lower
 * Difficulty: Easy
 *
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 *
 * You call a pre-defined API int guess(int num), which returns three possible results:
 *
 * 0: your guess is equal to the number I picked (i.e. num == pick).
 * -1: Your guess is higher than the number I picked (i.e. num > pick).
 * 1: Your guess is lower than the number I picked (i.e. num < pick).
 * Return the number that I picked.
 *
 * Example 1:
 *
 * Input: n = 5, pick = 3
 *
 * Output: 3
 *
 * Example 2:
 *
 * Input: n = 15, pick = 10
 *
 * Output: 10
 *
 * Example 3:
 *
 * Input: n = 1, pick = 1
 *
 * Output: 1
 *
 * Constraints:
 * 1 <= pick <= n <= ((2^31)-1)
 *
 */
object GuessNumberHigherLower {

    var pick: Int = 1 // Simulates the system's hidden pick value, set before calling guessNumber().

    @JvmStatic fun main(args: Array<String>) {
        val input1 = 5
        val input2 = 15
        val input3 = 1

        pick = 3
        val result1 = guessNumber(n = input1)
        println("Guess Number Higher or Lower: The result for input $input1 with pick $pick is $result1\n")

        pick = 10
        val result2 = guessNumber(n = input2)
        println("Guess Number Higher or Lower: The result for input $input2 with pick $pick is $result2\n")

        pick = 1
        val result3 = guessNumber(n = input3)
        println("Guess Number Higher or Lower: The result for input $input3 with pick $pick is $result3\n")
    }

    // guessNumber(): Time Complexity: O(log n) | Space Complexity: O(1)
    fun guessNumber(n: Int): Int {
        var low = 1 // From the constraints, the lowest value is 1.
        var high = n // Given the lowest value constraint, n is the high value.

        while (low <= high) {
            val mid = low + (high - low) / 2 // Middle value between low and high.
            val guessValue = guess(mid) // Sets the value of the guess based on mid.
            println("Guess Number Higher or Lower: mid: $mid, low: $low, high: $high, guessValue: $guessValue")

            when {
                guessValue > 0 -> {
                    low = mid + 1
                    println("Guess Number Higher or Lower: guessValue $guessValue is greater than 0, updated low to $low")
                }
                guessValue < 0 -> {
                    high = mid - 1
                    println("Guess Number Higher or Lower: guessValue $guessValue is less than 0, updated high to $high")
                }
                else -> {
                    println("Guess Number Higher or Lower: Found the guessed number is $mid")
                    return mid // Found the guessed number, returning this value.
                }
            }
        }

        println("Guess Number Higher or Lower: Did not find the guessed number")
        return -1
    }

    // guess(): Helper function to determine the value using `pick`.
    fun guess(num: Int): Int = when {
        num > pick -> -1
        num < pick -> 1
        else -> 0
    }
}