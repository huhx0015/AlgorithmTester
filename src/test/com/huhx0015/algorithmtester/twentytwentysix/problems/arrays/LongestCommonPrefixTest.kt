package com.huhx0015.algorithmtester.twentytwentysix.problems.arrays

import com.huhx0015.algorithmtester.twentytwentysix.problems.arrays.LongestCommonPrefix.longestCommonPrefix
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestCommonPrefixTest {

    @Test
    fun testLongestCommonPrefix() {
        val input1 = arrayOf("bat", "bag", "bank", "band")
        val input2 = arrayOf("dance", "dag", "danger", "damage")
        val input3 = arrayOf("neet", "feet")

        val result1 = longestCommonPrefix(input1)
        assertEquals("ba", result1)
        println("Longest Common Prefix: RESULT: $result1\n")

        val result2 = longestCommonPrefix(input2)
        assertEquals("da", result2)

        val result3 = longestCommonPrefix(input3)
        assertEquals("", result3)
    }
}