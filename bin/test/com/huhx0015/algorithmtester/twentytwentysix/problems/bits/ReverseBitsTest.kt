package com.huhx0015.algorithmtester.twentytwentysix.problems.bits

import com.huhx0015.algorithmtester.twentytwentysix.problems.bits.ReverseBits.reverseBits
import com.huhx0015.algorithmtester.twentytwentysix.problems.bits.ReverseBits.reverseBitsRepeat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseBitsTest {

    @Test
    fun testReverseBits() {
        val result1 = reverseBits(n = 100)
        assertEquals(637534208, result1)

        val result2 = reverseBits(n = 1000)
        assertEquals(398458880, result2)
    }

    @Test
    fun testReverseBitsRepeat() {
        val result1 = reverseBitsRepeat(n = 100)
        assertEquals(637534208, result1)

        val result2 = reverseBitsRepeat(n = 1000)
        assertEquals(398458880, result2)
    }
}