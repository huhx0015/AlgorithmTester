package com.huhx0015.algorithmtester.twentytwentysix.sorting

import com.huhx0015.algorithmtester.twentytwentysix.sorting.MergeSort.Pair
import com.huhx0015.algorithmtester.twentytwentysix.sorting.MergeSort.mergeSort
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MergeSortTest {

    @Test
    fun testMergeSortIntArray() {
        val inputIntArray1 = intArrayOf(2, 3, 4, 1, 6)
        val inputIntArray2 = intArrayOf(6, 4, 3, 2, 1)
        val sortIntArray1 = mergeSort(inputIntArray1, 0, inputIntArray1.size - 1)
        val sortIntArray2 = mergeSort(inputIntArray2, 0, inputIntArray2.size - 1)

        assertEquals(1, sortIntArray1.first())
        assertEquals(1, sortIntArray2.first())
        assertEquals(6, sortIntArray1.last())
        assertEquals(6, sortIntArray2.last())
    }

    @Test
    fun testMergeSortListPairs() {
        val inputPairArray1 = mutableListOf(
            Pair(5, "apple"),
            Pair(2, "banana"),
            Pair(9, "cherry"),
        )
        val inputPairArray2 = mutableListOf(
            Pair(3, "cat"),
            Pair(3, "bird"),
            Pair(2, "dog"),
        )
        val sortPairsArray1 = mergeSort(pairs = inputPairArray1)
        val sortPairsArray2 = mergeSort(pairs = inputPairArray2)

        assertEquals(2, sortPairsArray1.first().key)
        assertEquals("banana", sortPairsArray1.first().value)

        assertEquals(9, sortPairsArray1.last().key)
        assertEquals("bird", sortPairsArray2.last().value)

        assertEquals(2, sortPairsArray2.first().key)
        assertEquals("dog", sortPairsArray2.first().value)

        assertEquals(3, sortPairsArray2.last().key)
        assertEquals("bird", sortPairsArray2.last().value)
    }
}