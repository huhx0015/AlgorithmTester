package com.huhx0015.algorithmtester.twentytwentysix.datastructures

import com.huhx0015.algorithmtester.twentytwentysix.datastructures.StackWithQueues.MyStack
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StackWithQueuesTest {

    @Test
    fun testStackWithTwoQueues() {
        val stackWithTwoQueues = MyStack()

        val testValue1 = 1
        val testValue2 = 2
        stackWithTwoQueues.push(testValue1)
        stackWithTwoQueues.push(testValue2)

        val topValue1 = stackWithTwoQueues.top()
        assertEquals(testValue2, topValue1)

        val poppedValue1 = stackWithTwoQueues.pop()
        assertEquals(testValue2, poppedValue1)

        val isEmpty1 = stackWithTwoQueues.empty()
        assertEquals(false, isEmpty1)
    }

    @Test
    fun testStackWithOneQueues() {
        val stackWithOneQueue = StackWithQueues.MyStackOneQueue()

        val testValue1 = 1
        val testValue2 = 2
        stackWithOneQueue.push(testValue1)
        stackWithOneQueue.push(testValue2)

        val topValue1 = stackWithOneQueue.top()
        assertEquals(testValue2, topValue1)

        val poppedValue1 = stackWithOneQueue.pop()
        assertEquals(testValue2, poppedValue1)

        val isEmpty1 = stackWithOneQueue.empty()
        assertEquals(false, isEmpty1)
    }
}