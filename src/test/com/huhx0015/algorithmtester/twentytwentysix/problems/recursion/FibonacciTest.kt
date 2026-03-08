package com.huhx0015.algorithmtester.twentytwentysix.problems.recursion

import com.huhx0015.algorithmtester.twentytwentysix.problems.recursion.Fibonacci.fibonacci
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FibonacciTest {

    @Test
    fun testFibonacci() {
        val fibonacci1 = fibonacci(1)
        assertEquals(1, fibonacci1)

        val fibonacci2 = fibonacci(2)
        assertEquals(1, fibonacci2)

        val fibonacci3 = fibonacci(3)
        assertEquals(2, fibonacci3)

        val fibonacci4 = fibonacci(4)
        assertEquals(3, fibonacci4)

        val fibonacci5 = fibonacci(5)
        assertEquals(5, fibonacci5)

        val fibonacci6 = fibonacci(6)
        assertEquals(8, fibonacci6)

        val fibonacci7 = fibonacci(7)
        assertEquals(13, fibonacci7)

        val fibonacci8 = fibonacci(8)
        assertEquals(21, fibonacci8)

        val fibonacci9 = fibonacci(9)
        assertEquals(34, fibonacci9)

        val fibonacci10 = fibonacci(10)
        assertEquals(55, fibonacci10)
    }
}