package com.huhx0015.algorithmtester.twentytwentysix.search

import com.huhx0015.algorithmtester.twentytwentysix.search.BinaryRange.binarySearch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryRangeTest {

    @Test
    fun testBinaryRange() {
        val low = 1
        val high = 100

        val result = binarySearch(low = low, high = high)
        assertEquals(10, result)
    }
}