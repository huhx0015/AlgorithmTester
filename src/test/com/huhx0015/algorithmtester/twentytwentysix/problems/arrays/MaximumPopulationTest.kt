package com.huhx0015.algorithmtester.twentytwentysix.problems.arrays

import com.huhx0015.algorithmtester.twentytwentysix.problems.arrays.MaximumPopulation.maximumPopulation
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumPopulationTest {

    @Test
    fun maximumPopulationTest() {
        val input1 = arrayOf(intArrayOf(1993, 1999), intArrayOf(2000, 2010))
        val result1 = maximumPopulation(input1)
        assertEquals(1993, result1)

        val input2 = arrayOf(intArrayOf(1950, 1961), intArrayOf(1960, 1971), intArrayOf(1970, 1981))
        val result2 = maximumPopulation(input2)
        assertEquals(1960, result2)
    }
}