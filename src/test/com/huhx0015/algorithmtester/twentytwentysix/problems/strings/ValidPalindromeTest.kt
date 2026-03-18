package com.huhx0015.algorithmtester.twentytwentysix.problems.strings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidPalindromeTest {

    @Test
    fun testValidPalindrome() {
        assertEquals(true, ValidPalindrome.isPalindrome("Was it a car or a cat I saw?"))
        assertEquals(false, ValidPalindrome.isPalindrome("tab a cat"))
        assertEquals(true, ValidPalindrome.isPalindrome("A man a plan a canal Panama"))
        assertEquals(false, ValidPalindrome.isPalindrome("race a car"))
    }

    @Test
    fun testValidPalindromeBruteForce() {
        assertEquals(true, ValidPalindrome.isPalindromeBruteForce("Was it a car or a cat I saw?"))
        assertEquals(false, ValidPalindrome.isPalindromeBruteForce("tab a cat"))
        assertEquals(true, ValidPalindrome.isPalindromeBruteForce("A man a plan a canal Panama"))
        assertEquals(false, ValidPalindrome.isPalindromeBruteForce("race a car"))
    }
}
