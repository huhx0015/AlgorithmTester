package com.huhx0015.algorithmtester.twentytwentysix.search

import com.huhx0015.algorithmtester.twentytwentysix.search.BinarySearchRange.binarySearch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinarySearchRangeTest {

    @Test
    fun testBinarySearchRange() {
        val low = 1
        val high = 100

        val result = binarySearch(low = low, high = high)
        assertEquals(10, result)
    }
}