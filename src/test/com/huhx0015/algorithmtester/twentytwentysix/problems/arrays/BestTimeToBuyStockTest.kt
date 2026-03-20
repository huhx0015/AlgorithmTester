package com.huhx0015.algorithmtester.twentytwentysix.problems.arrays

import com.huhx0015.algorithmtester.twentytwentysix.problems.arrays.BestTimeToBuyStock.maxProfit
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTimeToBuyStockTest {

    @Test
    fun testBestTimeToBuyStock() {
        val inputArray1 = intArrayOf(10, 1, 5, 6, 7, 1)
        val inputArray2 = intArrayOf(10, 8, 7, 5, 2)

        val result1 = maxProfit(inputArray1)
        assertEquals(6, result1)

        val result2 = maxProfit(inputArray2)
        assertEquals(0, result2)
    }
}