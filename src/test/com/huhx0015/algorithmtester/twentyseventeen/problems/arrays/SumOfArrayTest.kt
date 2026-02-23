package com.huhx0015.algorithmtester.twentyseventeen.problems.arrays

import com.huhx0015.algorithmtester.twentyseventeen.problems.arrays.SumOfArray.sumOfArray
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by Michael Yoon Huh on 6/11/2017.
 */
internal class SumOfArrayTest {

    val TEST_SUM_ARRAY: IntArray = intArrayOf(1, 2, 3, 4, 5)
    val TEST_SUM_EXPECTED = 15

    @Test
    fun testSumOfArray() {
        val testSum = sumOfArray(TEST_SUM_ARRAY)
        assertEquals(TEST_SUM_EXPECTED, testSum)
    }
}



