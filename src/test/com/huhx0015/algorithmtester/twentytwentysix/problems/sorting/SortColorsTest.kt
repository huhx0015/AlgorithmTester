package com.huhx0015.algorithmtester.twentytwentysix.problems.sorting

import com.huhx0015.algorithmtester.twentytwentysix.problems.sorting.SortColors.sortColors
import com.huhx0015.algorithmtester.twentytwentysix.problems.sorting.SortColors.sortColorsTreeMap
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SortColorsTest {

    @Test
    fun testSortColors() {
        val inputColorArrayDutch1 = intArrayOf(1, 0, 1, 2)
        val inputColorArrayDutch2 = intArrayOf(2, 1, 0)

        sortColors(inputColorArrayDutch1)
        assertEquals(0, inputColorArrayDutch1.first())
        assertEquals(2, inputColorArrayDutch1.last())

        sortColors(inputColorArrayDutch2)
        assertEquals(0, inputColorArrayDutch2.first())
        assertEquals(2, inputColorArrayDutch2.last())
    }

    @Test
    fun testSortColorsTreeMap() {
        val inputColorArrayTreeMap1 = intArrayOf(1, 0, 1, 2)
        val inputColorArrayTreeMap2 = intArrayOf(2, 1, 0)

        sortColorsTreeMap(inputColorArrayTreeMap1)
        assertEquals(0, inputColorArrayTreeMap1.first())
        assertEquals(2, inputColorArrayTreeMap1.last())

        sortColorsTreeMap(inputColorArrayTreeMap2)
        assertEquals(0, inputColorArrayTreeMap2.first())
        assertEquals(2, inputColorArrayTreeMap2.last())
    }
}