package com.huhx0015.algorithmtester.twentytwentysix.search

import com.huhx0015.algorithmtester.twentytwentysix.search.BinarySearch.binarySearch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinarySearchTest {

    @Test
    fun testBinarySearch() {
        val inputIntArray = intArrayOf(1, 2, 3, 4, 23, 50, 78, 3000, 5000)
        val target1 = 23
        val target2 = 3
        val target3 = 77
        val target4 = 3000

        val result1 = binarySearch(arr = inputIntArray, target = target1)
        val result2 = binarySearch(arr = inputIntArray, target = target2)
        val result3 = binarySearch(arr = inputIntArray, target = target3)
        val result4 = binarySearch(arr = inputIntArray, target = target4)

        assertEquals(4, result1)
        assertEquals(2, result2)
        assertEquals(-1, result3)
        assertEquals(7, result4)
    }
}