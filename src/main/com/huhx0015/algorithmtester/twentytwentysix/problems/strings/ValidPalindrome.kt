package com.huhx0015.algorithmtester.twentytwentysix.problems.strings

import com.huhx0015.algorithmtester.twentytwentysix.problems.strings.ValidAnagram.isAnagram

/**
 * NeetCode.io
 *
 * Problem: Valid Palindrome
 * Difficulty: Easy
 *
 * Given a string s, return true if it is a palindrome, otherwise return false.
 *
 * A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
 *
 * Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).
 *
 * Example 1:
 *
 * Input: s = "Was it a car or a cat I saw?"
 *
 * Output: true
 * Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.
 *
 * Example 2:
 *
 * Input: s = "tab a cat"
 *
 * Output: false
 * Explanation: "tabacat" is not a palindrome.
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s is made up of only printable ASCII characters.
 *
 */
object ValidPalindrome {

    @JvmStatic fun main(args: Array<String>) {
        val input1 = "Was it a car or a cat I saw?"
        val input2 = "tab a cat"

        val resultBruteForce1 = isPalindromeBruteForce(s = input1)
        val resultBruteForce2 = isPalindromeBruteForce(s = input2)
    }

    // isPalindrome():
//    fun isPalindrome(s: String): Boolean {
//        println("isPalindrome: Checking if $s is a palindrome...")
//
//        // Empty character string is not a palindrome.
//        if (s.isEmpty()) {
//            println("isPalindrome: $s is empty, not a palindrome.")
//            return false
//        }
//
//        // One character string is a palindrome.
//        if (s.length == 1) {
//            println("isPalindrome: $s is single character, it is a palindrome.")
//            return true
//        }
//
//    }

    fun isPalindromeBruteForce(s: String): Boolean {
        println("isPalindromeBruteForce: Checking if $s is a palindrome...")

        // Empty character string is not a palindrome.
        if (s.isEmpty()) {
            println("isPalindromeBruteForce: $s is empty, not a palindrome.")
            return true
        }

        // One character string is a palindrome.
        if (s.length == 1) {
            println("isPalindromeBruteForce: $s is single character, it is a palindrome.")
            return true
        }

        val reversedStringBuilder: StringBuilder = StringBuilder()
        val originalStringBuilder: StringBuilder = StringBuilder()

        // Loop through the string `s` in reverse, constructing the string and omitting non-alphanumeric characters.
        for (i in s.length - 1 downTo 0) {
            val currentCharacter = s[i]
            if (currentCharacter.isLetterOrDigit()) {
                println("isPalindromeBruteForce: Current character $currentCharacter is alphanumeric, appending to reversedStringBuilder.")
                reversedStringBuilder.append(currentCharacter.lowercaseChar())
            } else {
                println("isPalindromeBruteForce: Current character $currentCharacter is not alphanumeric, skipping.")
            }
        }

        // Loop through the string `s` normally to get the filtered original string
        for (i in 0 until s.length) {
            val currentCharacter = s[i]
            if (currentCharacter.isLetterOrDigit()) {
                println("isPalindromeBruteForce: Current character $currentCharacter is alphanumeric, appending to originalStringBuilder.")
                originalStringBuilder.append(currentCharacter.lowercaseChar())
            } else {
                println("isPalindromeBruteForce: Current character $currentCharacter is not alphanumeric, skipping.")
            }
        }

        val reversedString = reversedStringBuilder.toString()
        val originalString = originalStringBuilder.toString()
        val areStringsEquivalent = reversedString == originalString

        println("isPalindromeBruteForce: Original string $originalString and reversed string $reversedString are palindromes: $areStringsEquivalent\n")
        return areStringsEquivalent
    }
}