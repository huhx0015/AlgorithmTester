package com.huhx0015.algorithmtester.twentytwentysix.problems.search

import com.huhx0015.algorithmtester.twentytwentysix.problems.search.Search2DMatrix.searchMatrix
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Search2DMatrixTest {

    @Test
    fun testSearch2DMatrix() {
        val inputMatrix = arrayOf(
            intArrayOf(1, 2, 4, 8),
            intArrayOf(10, 11, 12, 13),
            intArrayOf(14, 20, 30, 40)
        )
        val target1 = 10
        val target2 = 15

        val result1 = searchMatrix(matrix = inputMatrix, target = target1)
        assertEquals(true, result1)

        val result2 = searchMatrix(matrix = inputMatrix, target = target2)
        assertEquals(false, result2)
    }
}