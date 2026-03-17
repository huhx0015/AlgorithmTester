package com.huhx0015.algorithmtester.twentytwentysix.problems.arrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ContainsDuplicatesTest {

    @Test
    fun containsDuplicatesTest() {
        val input1 = intArrayOf(1, 2, 3, 3)
        val input2 = intArrayOf(1, 2, 3, 4)

        val result1 = ContainsDuplicates.hasDuplicate(input1)
        assertEquals(true, result1)

        val result2 = ContainsDuplicates.hasDuplicate(input2)
        assertEquals(false, result2)
    }
}