package com.huhx0015.algorithmtester.twentytwentysix.problems.arrays

import com.huhx0015.algorithmtester.twentytwentysix.problems.arrays.RemoveDuplicatesSortedArray.removeDuplicates
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveDuplicatesSortedArrayTest {

    @Test
    fun testRemoveDuplicatesSortedArray() {
        val input1 = intArrayOf(1, 1, 2, 3, 4)
        val input1Result = removeDuplicates(input1)
        assertEquals(4, input1Result)

        val input2 = intArrayOf(2, 10, 10, 30, 30, 30)
        val input2Result = removeDuplicates(input2)
        assertEquals(3, input2Result)

        val input3 = intArrayOf(1, 72, 128, 128, 256, 256)
        val input3Result = removeDuplicates(input3)
        assertEquals(4, input3Result)
    }
}