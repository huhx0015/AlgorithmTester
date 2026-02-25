package com.huhx0015.algorithmtester.twentytwentysix.problems.arrays

import com.huhx0015.algorithmtester.twentytwentysix.problems.arrays.ConcatenationOfArray.getConcatenation
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConcatenationOfArrayTest {

    @Test
    fun testConcatenationOfArray() {
        val input1 = intArrayOf(1, 2, 3, 4)
        val result1 = getConcatenation(input1)

        assertEquals(8, result1.size)
        assertEquals(input1[2], result1[6])

        val input2 = intArrayOf(3, 5)
        val result2 = getConcatenation(input2)

        assertEquals(4, result2.size)
        assertEquals(input2[1], result2[3])

        val input3 = intArrayOf(25, 1000, 25000, 4000, 7000)
        val result3 = getConcatenation(input3)

        assertEquals(10, result3.size)
        assertEquals(input3[3], result3[8])
    }
}