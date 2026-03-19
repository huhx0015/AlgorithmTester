package com.huhx0015.algorithmtester.twentytwentysix.sorting

import com.huhx0015.algorithmtester.twentytwentysix.sorting.BucketSort.bucketSort
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class BucketSortTest {

    @Test
    fun testBucketSort() {
        val inputIntArray1 = intArrayOf(2, 3, 4, 1, 6)
        val inputIntArray2 = intArrayOf(20, 4, 70, 2, 1)

        val expectedIntArray1 = intArrayOf(1, 2, 3, 4, 6)
        val expectedIntArray2 = intArrayOf(1, 2, 4, 20, 70)

        val resultIntArray1 = bucketSort(inputIntArray1)
        assertArrayEquals(expectedIntArray1, resultIntArray1)

        val resultIntArray2 = bucketSort(inputIntArray2)
        assertArrayEquals(expectedIntArray2, resultIntArray2)
    }
}