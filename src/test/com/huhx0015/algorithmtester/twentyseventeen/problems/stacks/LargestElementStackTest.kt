package com.huhx0015.algorithmtester.twentyseventeen.problems.stacks

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Created by Michael Yoon Huh on 6/13/2017.
 */
internal class LargestElementStackTest {

    @Test
    fun testLargestElementStack() {
        val stack = LargestElementStack()

        stack.push(5)

        assertEquals(5, stack.max)

        stack.push(25)

        assertEquals(25, stack.max)
        assertEquals(25, stack.pop())
        assertEquals(5, stack.max)

        stack.push(38)

        assertEquals(38, stack.max)
        assertEquals(38, stack.pop())
        assertEquals(5, stack.max)
    }
}