package com.huhx0015.algorithmtester.twentytwentysix.problems.strings

import com.huhx0015.algorithmtester.twentytwentysix.problems.strings.ValidAnagram.isAnagram
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidAnagramTest {

    @Test
    fun isAnagramTest() {
        val inputFirstString1 = "racecar"
        val inputSecondString1 = "carrace"

        val inputFirstString2 = "jar"
        val inputSecondString2 = "jam"

        val result1 = isAnagram(s = inputFirstString1, t = inputSecondString1)
        val result2 = isAnagram(s = inputFirstString2, t = inputSecondString2)

        assertEquals(true, result1)
        assertEquals(false, result2)
    }
}