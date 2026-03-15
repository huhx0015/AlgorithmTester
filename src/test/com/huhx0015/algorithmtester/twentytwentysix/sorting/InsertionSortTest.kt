package com.huhx0015.algorithmtester.twentytwentysix.sorting

import com.huhx0015.algorithmtester.twentytwentysix.sorting.InsertionSort.Pair
import com.huhx0015.algorithmtester.twentytwentysix.sorting.InsertionSort.insertionSort
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InsertionSortTest {

    @Test
    fun testInsertionSortIntArray() {
        val inputIntArray1 = intArrayOf(2, 3, 4, 1, 6)
        val inputIntArray2 = intArrayOf(6, 4, 3, 2, 1)
        val sortIntArray1 = insertionSort(inputIntArray1)
        val sortIntArray2 = insertionSort(inputIntArray2)

        assertEquals(1, sortIntArray1.first())
        assertEquals(1, sortIntArray2.first())
        assertEquals(6, sortIntArray1.last())
        assertEquals(6, sortIntArray2.last())
    }

    @Test
    fun testInsertionSortListPairs() {
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
        val sortPairsArray1 = insertionSort(pairs = inputPairArray1)
        val sortPairsArray2 = insertionSort(pairs = inputPairArray2)

        assertEquals(5, sortPairsArray1.first().first().key)
        assertEquals("apple", sortPairsArray1.first().first().value)

        assertEquals(9, sortPairsArray1.last().last().key)
        assertEquals("bird", sortPairsArray2.last().last().value)

        assertEquals(3, sortPairsArray2.first().first().key)
        assertEquals("cat", sortPairsArray2.first().first().value)

        assertEquals(3, sortPairsArray2.last().last().key)
        assertEquals("bird", sortPairsArray2.last().last().value)
    }
}