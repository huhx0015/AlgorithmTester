package com.huhx0015.algorithmtester.twentytwentysix.bits

import com.huhx0015.algorithmtester.twentytwentysix.bits.CountingBits.countBits
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountingBitsTest {

    @Test
    fun testCountingBits() {
        val result1 = countBits(num = 23)
        assertEquals(4, result1)

        val result2 = countBits(num = 4)
        assertEquals(1, result2)

        val result3 = countBits(num = 100)
        assertEquals(3, result3)
    }
}