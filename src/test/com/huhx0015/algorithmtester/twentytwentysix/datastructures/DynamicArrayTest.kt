package com.huhx0015.algorithmtester.twentytwentysix.datastructures

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DynamicArrayTest {

    lateinit var dynamicArray: DynamicArray

    @BeforeEach
    fun init() {
        val testCapacity = 2
        dynamicArray = DynamicArray(testCapacity)
    }

    @Test
    fun testDynamicArrayCapacity() {
        assertEquals(2, dynamicArray.getCapacity()) // Expects capacity to be 2.
        assertEquals(0, dynamicArray.getSize()) // Expects size to be 0.
    }

    @Test
    fun testDynamicArrayPushAndResize() {
        val testValue1 = 64
        dynamicArray.pushback(testValue1)

        assertEquals(testValue1, dynamicArray.get(0)) // Expects value at position 0 to be 64.
        assertEquals(1, dynamicArray.getSize()) // Expects size to be 1.

        val testValue2 = 128
        dynamicArray.pushback(testValue2)
        assertEquals(testValue2, dynamicArray.get(1)) // Expects value at position 0 to be 128.
        assertEquals(2, dynamicArray.getSize()) // Expects size to be 2.

        val testValue3 = 256
        dynamicArray.pushback(testValue3)
        assertEquals(testValue3, dynamicArray.get(2)) // Expects value at position 0 to be 256.
        assertEquals(3, dynamicArray.getSize()) // Expects size to be 3.
        assertEquals(4, dynamicArray.getCapacity()) // Expects capacity to be 4, after resize.
    }

    @Test
    fun testDynamicArrayPop() {
        val testValue1 = 64
        dynamicArray.pushback(testValue1)

        val testValue2 = 128
        dynamicArray.pushback(testValue2)

        val testValue3 = 256
        dynamicArray.pushback(testValue3)

        assertEquals(3, dynamicArray.getSize()) // Expects size to be 3.
        assertEquals(4, dynamicArray.getCapacity()) // Expects capacity to be 4, after resize.

        val popValue3 = dynamicArray.popback()
        assertEquals(testValue3, popValue3) // Expects popped value to be 256.

        val popValue2 = dynamicArray.popback()
        assertEquals(testValue2, popValue2) // Expects popped value to be 128.

        val popValue1 = dynamicArray.popback()
        assertEquals(testValue1, popValue1) // Expects popped value to be 64.

        assertEquals(0, dynamicArray.getSize()) // Expects size to be 0.
        assertEquals(4, dynamicArray.getCapacity()) // Expects capacity to be 4.
    }

    @Test
    fun testDynamicArrayGetAndSet() {
        val testValue1 = 64
        dynamicArray.pushback(testValue1)

        val testValue2 = 128
        dynamicArray.pushback(testValue2)

        val testValue3 = 256
        dynamicArray.pushback(testValue3)

        assertEquals(3, dynamicArray.getSize()) // Expects size to be 3.
        assertEquals(4, dynamicArray.getCapacity()) // Expects capacity to be 4, after resize.

        assertEquals(testValue1, dynamicArray.get(0)) // Expects value to be 64.
        assertEquals(testValue2, dynamicArray.get(1)) // Expects value to be 128.
        assertEquals(testValue3, dynamicArray.get(2)) // Expects value to be 256.

        dynamicArray.set(0, 32)
        assertEquals(32, dynamicArray.get(0)) // Expects value to be 32.
    }
}