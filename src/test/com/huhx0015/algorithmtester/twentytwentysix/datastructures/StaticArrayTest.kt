package com.huhx0015.algorithmtester.twentytwentysix.datastructures

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StaticArrayTest {

    private val staticArray: StaticArray = StaticArray()

    @Test
    fun testInsertAndRemoveEnd() {
        val testSize = 5
        val testIntArray = IntArray(testSize)

        val testValue1 = 20
        val testLength1 = 1
        staticArray.insertEnd(array = testIntArray, n = testValue1, length = testLength1, capacity = 2)
        assertEquals(20, testIntArray[testLength1])

        val testValue2 = 21
        val testLength2 = 0
        staticArray.insertEnd(array = testIntArray, n = testValue2, length = testLength2, capacity = 2)
        assertEquals(21, testIntArray[testLength2])

        val testRemove2 = staticArray.removeEnd(array = testIntArray, length = testLength2)
        assertEquals(testLength2, testRemove2)
    }
}