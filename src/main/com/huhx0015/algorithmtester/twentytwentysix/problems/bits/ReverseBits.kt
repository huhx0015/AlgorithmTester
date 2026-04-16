package com.huhx0015.algorithmtester.twentytwentysix.problems.bits

/**
 * Neetcode.io
 *
 * Problem: Reverse Bits
 * Difficulty: Easy
 * Topics
 * Company Tags
 * Hints
 * Given a 32-bit unsigned integer n, reverse the bits of the binary representation of n and return the result.
 *
 * Example 1:
 *
 * Input: n = 00000000000000000000000000010101
 *
 * Output:    2818572288 (10101000000000000000000000000000)
 * Explanation: Reversing 00000000000000000000000000010101, which represents the unsigned integer 21, gives us 10101000000000000000000000000000 which represents the unsigned integer 2818572288.
 */
object ReverseBits {

    private const val VAL_MAX_BITS = 32 // Represents the max number of bits (32-bit) value for this problem.

    @JvmStatic fun main(args: Array<String>) {
        val result1 = reverseBits(n = 100)
        println("Reverse Bits: Result is $result1\n")

        val result2 = reverseBitsRepeat(n = 100)
        println("Reverse Bits: Result is $result2\n")
    }

    // reverseBits(): Defines a function that returns n with its 32 bits reversed.
    // Time Complexity: O(1) | Space Complexity: O(1)
    fun reverseBits(n: Int): Int {
        var res = 0 // Stores the final reversed-bit result as we build it.
        var num = n // Keeps a local copy of the input value for bit extraction.

        for (i in 0 until VAL_MAX_BITS) { // Iterates through all bit positions from 0 to 31.
            val bit = (num shr i) and 1 // Extracts the bit at position i from num.
            res = res or (bit shl (VAL_MAX_BITS - 1 - i)) // Places that bit into its mirrored position in res.
        }

        println("Reverse Bits: Reversed bits of $n is $res")
        return res // Returns the completed reversed-bit integer.
    }

    // reverseBitsRepeat(): Uses Kotlin repeat function for reversing the bits of the input `n`.
    // Time Complexity: O(1) | Space Complexity: O(1)
    fun reverseBitsRepeat(n: Int): Int {
        var input = n // Create a mutable copy so we can shift bits out one by one.
        var reversed = 0 // Accumulate the reversed-bit result here.

        repeat(VAL_MAX_BITS) { // Process exactly 32 bits for a 32-bit integer.
            reversed = reversed shl 1 // Make room on the right by shifting current result left.
            reversed = reversed or (input and 1) // Append input's least-significant bit to the result.
            input = input ushr 1 // Move the next input bit into the least-significant position.
        }

        println("Reverse Bits (Repeat): Reversed bits of $n is $reversed")
        return reversed // Return the integer whose bits are reversed.
    }
}