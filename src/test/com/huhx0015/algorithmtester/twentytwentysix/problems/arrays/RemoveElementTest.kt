package com.huhx0015.algorithmtester.twentytwentysix.problems.arrays

import com.huhx0015.algorithmtester.twentytwentysix.problems.arrays.RemoveElement.removeElement
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveElementTest {

    @Test
    fun testRemoveElement() {
        val inputArray1 = intArrayOf(1, 1, 2, 3, 4)
        val inputValueToRemove1 = 1
        val inputUniqueElements1 = removeElement(nums = inputArray1, valueToRemove = inputValueToRemove1)

        assertEquals(3, inputUniqueElements1)

        val inputArray2 = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
        val inputValueToRemove2 = 2
        val inputUniqueElements2 = removeElement(nums = inputArray2, valueToRemove = inputValueToRemove2)

        assertEquals(5, inputUniqueElements2)
    }
}