package com.huhx0015.algorithmtester.twentytwentysix.sorting

import com.huhx0015.algorithmtester.twentytwentysix.sorting.QuickSort.Pair
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class QuickSortTest {

    @Test
    fun testQuickSortPairs() {
        val inputPairs1: MutableList<Pair> = mutableListOf(Pair(1, "cat"), Pair(2, "dog"), Pair(3, "bird"))
        val inputPairs2: MutableList<Pair> = mutableListOf(Pair(5, "apple"), Pair(9, "apple"), Pair(9, "cherry"), Pair(9, "banana"))
        val inputPairs3: MutableList<Pair> = mutableListOf(Pair(3, "cat"), Pair(2, "dog"), Pair(1, "bird"))

        val resultPairs1 = QuickSort.quickSort(pairs = inputPairs1)
        assertEquals(listOf(1, 2, 3), resultPairs1.map { it.key })
        assertEquals(3, resultPairs1.size)

        val resultPairs2 = QuickSort.quickSort(pairs = inputPairs2)
        assertEquals(listOf(5, 9, 9, 9), resultPairs2.map { it.key })
        assertEquals(4, resultPairs2.size)

        val expectedPairs2 = listOf(5 to "apple", 9 to "apple", 9 to "cherry", 9 to "banana")
            .sortedWith(compareBy({ it.first }, { it.second }))
        assertEquals(expectedPairs2, resultPairs2.map { it.key to it.value }
            .sortedWith(compareBy({ it.first }, { it.second })))

        val resultPairs3 = QuickSort.quickSort(pairs = inputPairs3)
        assertEquals(listOf(1, 2, 3), resultPairs3.map { it.key })
        assertEquals(3, resultPairs3.size)
    }

    @Test
    fun testQuickSortIntArray() {
        val inputArray1 = intArrayOf(6, 2, 4, 1, 3)
        val inputArray2 = intArrayOf(7, 3, 7, 4, 5)
        val expectedArray1 = inputArray1
        expectedArray1.sort()
        val expectedArray2 = inputArray2
        expectedArray2.sort()

        val resultArray1 = QuickSort.quickSort(arr = inputArray1, s = 0, e = 4)
        assertEquals(expectedArray1, resultArray1)

        val resultArray2 = QuickSort.quickSort(arr = inputArray2, s = 0, e = 4)
        assertEquals(expectedArray2, resultArray2)
    }
}