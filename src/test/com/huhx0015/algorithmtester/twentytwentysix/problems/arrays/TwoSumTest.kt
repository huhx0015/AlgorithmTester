package com.huhx0015.algorithmtester.twentytwentysix.problems.arrays

import com.huhx0015.algorithmtester.twentytwentysix.problems.arrays.TwoSum.twoSum
import com.huhx0015.algorithmtester.twentytwentysix.problems.arrays.TwoSum.twoSumBruteForce
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TwoSumTest {

    @Test
    fun testTwoSum() {
        val inputArray1 = intArrayOf(3, 4, 5, 6)
        val inputTarget1 = 7
        val output1 = twoSum(nums = inputArray1, target = inputTarget1)
        val expectedOutcome1 = intArrayOf(0, 1)
        assertEquals(expectedOutcome1.first(), output1.first())
        assertEquals(expectedOutcome1.last(), output1.last())

        val inputArray2 = intArrayOf(4, 5, 6)
        val inputTarget2 = 10
        val output2 = twoSum(nums = inputArray2, target = inputTarget2)
        val expectedOutcome2 = intArrayOf(0, 2)
        assertEquals(expectedOutcome2.first(), output2.first())
        assertEquals(expectedOutcome2.last(), output2.last())

        val inputArray3 = intArrayOf(5, 5)
        val inputTarget3 = 10
        val output3 = twoSum(nums = inputArray3, target = inputTarget3)
        val expectedOutcome3 = intArrayOf(0, 1)
        assertEquals(expectedOutcome3.first(), output3.first())
        assertEquals(expectedOutcome3.last(), output3.last())
    }

    @Test
    fun testTwoSumBruteForce() {
        val inputArray1 = intArrayOf(3, 4, 5, 6)
        val inputTarget1 = 7
        val outputBruteForce1 = twoSumBruteForce(nums = inputArray1, target = inputTarget1)
        val expectedOutcome1 = intArrayOf(0, 1)
        assertEquals(expectedOutcome1.first(), outputBruteForce1.first())
        assertEquals(expectedOutcome1.last(), outputBruteForce1.last())

        val inputArray2 = intArrayOf(4, 5, 6)
        val inputTarget2 = 10
        val outputBruteForce2 = twoSumBruteForce(nums = inputArray2, target = inputTarget2)
        val expectedOutcome2 = intArrayOf(0, 2)
        assertEquals(expectedOutcome2.first(), outputBruteForce2.first())
        assertEquals(expectedOutcome2.last(), outputBruteForce2.last())

        val inputArray3 = intArrayOf(5, 5)
        val inputTarget3 = 10
        val outputBruteForce3 = twoSumBruteForce(nums = inputArray3, target = inputTarget3)
        val expectedOutcome3 = intArrayOf(0, 1)
        assertEquals(expectedOutcome3.first(), outputBruteForce3.first())
        assertEquals(expectedOutcome3.last(), outputBruteForce3.last())
    }
}