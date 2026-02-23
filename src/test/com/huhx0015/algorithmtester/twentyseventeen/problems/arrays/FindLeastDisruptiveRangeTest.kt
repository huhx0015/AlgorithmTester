package com.huhx0015.algorithmtester.twentyseventeen.problems.arrays

import com.huhx0015.algorithmtester.twentyseventeen.problems.arrays.FindLeastDisruptiveRange.leastDisruptiveRange
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Created by Michael Yoon Huh on 6/13/2017.
 */
internal class FindLeastDisruptiveRangeTest {

    @Test
    fun testLeastDisruptiveRange() {
        val smallestIndex = leastDisruptiveRange(TEST_ARRAY_1, TEST_ARRAY_2)
        assertEquals(TEST_RESULT, smallestIndex)
    }

    companion object {
        private val TEST_ARRAY_1 = intArrayOf(1, 2, 3, 4, 5)
        private val TEST_ARRAY_2 = intArrayOf(5, 8, 1)
        private val TEST_RESULT = 2
    }
}