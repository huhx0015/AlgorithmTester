package com.huhx0015.algorithmtester.twentytwentysix.datastructures

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MinStackTest {

    val minStack: MinStack = MinStack()

    @Test
    fun testMinStack() {
        val testPush1 = 64
        minStack.push(testPush1)
        assertEquals(testPush1, minStack.top())
        assertEquals(testPush1, minStack.getMin())

        val testPush2 = 128
        minStack.push(testPush2)
        assertEquals(testPush2, minStack.top())
        assertEquals(testPush1, minStack.getMin())

        val testPush3 = 22
        minStack.push(testPush3)
        assertEquals(testPush3, minStack.top())
        assertEquals(testPush3, minStack.getMin())

        minStack.pop()
        assertEquals(testPush2, minStack.top())
        assertEquals(testPush1, minStack.getMin())

        minStack.pop()
        assertEquals(testPush1, minStack.top())
        assertEquals(testPush1, minStack.getMin())
    }
}