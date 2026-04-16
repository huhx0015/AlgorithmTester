package com.huhx0015.algorithmtester.twentytwentysix.problems.bits

/**
 * Neetcode.io
 *
 * Problem: Counting Bits
 * Difficulty: Easy
 *
 * Given an integer n, count the number of 1's in the binary representation of every number in the range [0, n].
 *
 * Return an array output where output[i] is the number of 1's in the binary representation of i.
 *
 * Example 1:
 * Input: n = 4
 * Output: [0,1,1,2,1]
 *
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 *
 * Constraints:
 *
 * 0 <= n <= 1000
 *
 * Example:
 *
 * 23 -> 10111
 *
 * // First bit was a 1, increment count and shift to the right.
 * 10111 & 00001 -> 00001
 *
 * // First bit was a 1, increment count and shift to the right.
 *
 * 01011 & 00001 -> 00001
 *
 * // We again get a 1, so increment count and shift to the right.
 *
 * 00101 & 00001 -> 00001
 *
 * // We get a 0, so we only shift to the right, leaving the count untouched.
 *
 * 00010 & 00001 -> 00000
 *
 * // We get a 1, so we shift to the right and increment the count.
 * 00001 & 00001 -> 00001
 */
object CountingBits {

    @JvmStatic fun main(args: Array<String>) {
        val result1 = countBits(num = 23)
        println("Count Bits: Result: $result1\n")

        val result2 = countBits(num = 44)
        println("Count Bits: Result: $result2\n")

        val result3 = countBits(num = 100)
        println("Count Bits: Result: $result3\n")

        val result4 = countingBits(n = 4)
        println("Counting Bits: Result: ${result4.toList()}")
    }

    // countingBits(): Counts the number of 1-bits from 0 to n and return an IntArray.
    fun countingBits(n: Int): IntArray {
        val countArray = IntArray(n + 1) // Stores the 1-bit count of each value in the IntArray.

        // Loops until n value has been reached, calculating the 1-bit count of each value.
        for (i in 0 until n + 1) {
            val bitCount = countBits(num = i)
            println("Counting Bits: FOR: Bit count for $i is $bitCount")
            countArray[i] = bitCount
        }

        return countArray
    }

    // countBits(): Counts the number of 1 bits in an single Int value.
    fun countBits(num: Int): Int {
        var n = num
        var count = 0

        while (n > 0) {
            if ((n and 1) == 1) {
                count++
                println("Count Bits: WHILE: Adding to the count: $count")
            }
            n = n shr 1 // same as n / 2
            println("Count Bits: WHILE: Shifting bits to the right by 1, n is now: $n")
        }

        println("Count Bits: Finished, count for n $n is $count")
        return count
    }

    fun operations() {
        // AND
        var n = 1 and 1

        // OR
        n = 1 or 0

        // XOR
        n = 0 xor 1

        // NOT (negation)
        n = n.inv()

        // Bit Shifting
        n = 1
        n = n shl 1
        n = n shr 1
    }
}