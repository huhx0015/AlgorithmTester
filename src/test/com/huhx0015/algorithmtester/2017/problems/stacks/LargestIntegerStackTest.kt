package test.com.huhx0015.algorithmtester.problems.stacks

import main.com.huhx0015.algorithmtester.problems.stacks.LargestIntegerStack
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Created by Michael Yoon Huh on 6/13/2017.
 */
internal class LargestIntegerStackTest {

    @Test
    fun testLargestIntegerStack() {
        val stack = LargestIntegerStack(5)

        stack.push(1)
        assertEquals(1, stack.max)

        stack.push(2)

        assertEquals(2, stack.max)
        assertEquals(2, stack.peek())
        assertEquals(2, stack.pop())
        assertEquals(1, stack.max)

        stack.push(3)

        assertEquals(3, stack.max)
        assertEquals(3, stack.peek())

        stack.push(4)

        assertEquals(4, stack.max)

        stack.push(5)

        assertEquals(5, stack.max)

        stack.push(6)

        assertEquals(6, stack.max)

        stack.push(7)

        assertEquals(6, stack.max)
        assertEquals(6, stack.pop())
        assertEquals(5, stack.pop())
    }
}