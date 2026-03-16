package com.huhx0015.algorithmtester.twentytwentysix.problems.strings

import com.huhx0015.algorithmtester.twentytwentysix.problems.strings.FizzBuzz.fizzBuzz
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FizzBuzzTest {

    @Test
    fun testFizzBuzz() {
        val input1 = 3
        val input2 = 5
        val input3 = 15

        val output1 = fizzBuzz(input1)
        val output2 = fizzBuzz(input2)
        val output3 = fizzBuzz(input3)

        val expected1: List<String> = listOf(
            "1", "2", "Fizz"
        )
        val expected2: List<String> = listOf(
            "1", "2", "Fizz", "4", "Buzz"
        )
        val expected3: List<String> = listOf(
            "1","2","Fizz","4","Buzz",
            "Fizz","7","8","Fizz","Buzz",
            "11","Fizz","13","14","FizzBuzz"
        )

        assertEquals(expected1, output1)
        assertEquals(expected2, output2)
        assertEquals(expected3, output3)
    }
}