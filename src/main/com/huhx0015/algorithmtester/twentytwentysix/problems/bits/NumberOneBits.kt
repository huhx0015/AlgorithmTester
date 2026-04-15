package com.huhx0015.algorithmtester.twentytwentysix.problems.bits

/**
 * Neetcode.io
 *
 * Problem: Number of 1 Bits
 * Difficulty: Easy
 *
 * You are given an unsigned integer n. Return the number of 1 bits in its binary representation.
 *
 * You may assume n is a non-negative integer which fits within 32-bits.
 *
 * Example 1:
 * Input: n = 00000000000000000000000000010111
 * Output: 4
 *
 * Example 2:
 * Input: n = 01111111111111111111111111111101
 * Output: 30
 */
object NumberOneBits {

    private const val VAL_MAX_BITS = 32 // Represents the max number of bits (32-bit) value for this problem.

    @JvmStatic fun main(args: Array<String>) {

    }

    fun hammingWeight(n: Int): Int {
        var numberOfOneBits = 0 // Used for keeping track of how many 1-bits were found.
        var number = n // Used to keep reference to the input value while looping through each bit, starting at `n`.

        // Loops through each bit until reaching 32-bits.
        for (i in 0 until VAL_MAX_BITS) {

            // Checks the current 'n' value by performing an AND (&) operation with 1.
            // AND: 1 & 1 == 1 | 0 & 1 == 0 | 1 & 0 == 0 | 0 & 0 == 0
            if (number and 1 == 1) {
                numberOfOneBits++
                println("Number of 1-Bits: FOR: Found a 1-bit at $number, incrementing count of 1-bits: $numberOfOneBits")
            }
            number = number shr 1 // Same as n / 2, shifts the bits to the right.
        }
        return numberOfOneBits
    }
}