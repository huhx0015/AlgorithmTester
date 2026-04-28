package com.huhx0015.algorithmtester.twentytwentysix.problems.arrays

import com.huhx0015.algorithmtester.twentytwentysix.problems.arrays.MajorityElement.majorityElement
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MajorityElementTest {

    @Test
    fun testMajorityElement() {
        val input1 = intArrayOf(5, 5, 1, 1, 1, 5, 5)
        val input2 = intArrayOf(2, 2, 2)
        val result1 = majorityElement(nums = input1)
        val result2 = majorityElement(nums = input2)

        assertEquals(5, result1)
        assertEquals(2, result2)
    }
}