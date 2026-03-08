package com.huhx0015.algorithmtester.twentytwentysix.datastructures

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DesignDequeTest {

    @Test
    fun testDeque() {
        val testDeque = Deque()
        assertEquals(true, testDeque.isEmpty())

        val testInsertValue1 = 10
        testDeque.append(testInsertValue1)
        assertEquals(false, testDeque.isEmpty())

        val testInsertValue2 = 20
        testDeque.appendleft(testInsertValue2)
        val popLeft1 = testDeque.popleft()
        assertEquals(testInsertValue2, popLeft1)

        val pop1 = testDeque.pop()
        assertEquals(testInsertValue1, pop1)
        assertEquals(true, testDeque.isEmpty())

        val testInsertValue3 = 30
        testDeque.append(testInsertValue3)
        assertEquals(false, testDeque.isEmpty())

        val pop2 = testDeque.pop()
        assertEquals(testInsertValue3, pop2)
    }
}