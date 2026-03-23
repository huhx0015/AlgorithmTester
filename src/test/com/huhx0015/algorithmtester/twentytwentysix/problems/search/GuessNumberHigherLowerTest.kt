package com.huhx0015.algorithmtester.twentytwentysix.problems.search

import com.huhx0015.algorithmtester.twentytwentysix.problems.search.GuessNumberHigherLower.guessNumber
import com.huhx0015.algorithmtester.twentytwentysix.problems.search.GuessNumberHigherLower.pick
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GuessNumberHigherLowerTest {

    @Test
    fun testGuessNumberHigherLowerTest() {
        val input1 = 5
        val input2 = 15
        val input3 = 1

        pick = 3
        val result1 = guessNumber(n = input1)
        assertEquals(pick, result1)

        pick = 10
        val result2 = guessNumber(n = input2)
        assertEquals(pick, result2)

        pick = 1
        val result3 = guessNumber(n = input3)
        assertEquals(pick, result3)
    }
}