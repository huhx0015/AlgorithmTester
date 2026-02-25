package com.huhx0015.algorithmtester.twentytwentysix.datastructures

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class StackTest {

    lateinit var stack: Stack

    @BeforeEach
    fun init() {
        stack = Stack()
    }

    @Test
    fun testStack() {
        val testPush1 = 3
        stack.push(testPush1)
        assertEquals(1, stack.size())

        val testPush2 = 20
        stack.push(testPush2)
        assertEquals(2, stack.size())

        val testPush3 = 40
        stack.push(testPush3)
        assertEquals(3, stack.size())

        val testPop3 = stack.pop()
        assertEquals(testPush3, testPop3)

        val testPop2 = stack.pop()
        assertEquals(testPush2, testPop2)

        val testPop1 = stack.pop()
        assertEquals(testPush1, testPop1)
    }
}