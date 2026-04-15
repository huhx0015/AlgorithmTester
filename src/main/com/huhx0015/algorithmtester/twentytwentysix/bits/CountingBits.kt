package com.huhx0015.algorithmtester.twentytwentysix.bits

/**
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

    // countBits(): Count the number of 1 bits in an int.
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
}