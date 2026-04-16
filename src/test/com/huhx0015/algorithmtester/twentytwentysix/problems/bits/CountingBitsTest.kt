package com.huhx0015.algorithmtester.twentytwentysix.problems.bits

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CountingBitsTest {

    @Test
    fun testCountingBits() {
        val result1 = CountingBits.countBits(num = 23)
        Assertions.assertEquals(4, result1)

        val result2 = CountingBits.countBits(num = 4)
        Assertions.assertEquals(1, result2)

        val result3 = CountingBits.countBits(num = 100)
        Assertions.assertEquals(3, result3)
    }
}