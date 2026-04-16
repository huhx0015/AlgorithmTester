package com.huhx0015.algorithmtester.twentytwentysix.problems.bits

import com.huhx0015.algorithmtester.twentytwentysix.problems.bits.NumberOneBits.hammingWeight
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOneBitsTest {

    @Test
    fun testNumberOneBits() {
        val result1 = hammingWeight(n = 11110000)
        assertEquals(10, result1)

        val result2 = hammingWeight(n = 10000001)
        assertEquals(9, result2)
    }
}