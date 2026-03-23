package com.huhx0015.algorithmtester.twentytwentysix.search

import com.huhx0015.algorithmtester.twentytwentysix.search.SearchRange.binarySearch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SearchRangeTest {

    @Test
    fun testSearchRange() {
        val low = 1
        val high = 100

        val result = binarySearch(low = low, high = high)
        assertEquals(10, result)
    }
}