package test.com.huhx0015.algorithmtester.datastructures

import main.com.huhx0015.algorithmtester.datastructures.CustomStack
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Created by Michael Yoon Huh on 6/12/2017.
 */
internal class CustomStackTest {

    @Test
    fun testCustomStack() {
        val stack = CustomStack()

        stack.push(TEST_VALUE_1)

        assertEquals(TEST_VALUE_1, stack.peek())

        stack.push(TEST_VALUE_2)
        stack.push(TEST_VALUE_3)

        assertEquals(TEST_VALUE_3, stack.pop())
        assertEquals(TEST_VALUE_2, stack.peek())

        stack.push(TEST_VALUE_4)

        assertEquals(TEST_VALUE_4, stack.peek())

        stack.pop()
        stack.pop()

        assertEquals(TEST_VALUE_1, stack.peek())
    }

    companion object {
        private val TEST_VALUE_1 = "Hello"
        private val TEST_VALUE_2 = "There"
        private val TEST_VALUE_3 = "Mai"
        private val TEST_VALUE_4 = "My"
        private val TEST_VALUE_5 = "Name"
        private val TEST_VALUE_6 = "WHAT"
    }
}