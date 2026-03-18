package com.huhx0015.algorithmtester.twentytwentysix.problems.strings

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

        isPalindrome(s = input1)
        isPalindrome(s = input2)
        isPalindromeKotlin(s = input1)
        isPalindromeKotlin(s = input2)
        isPalindromeBruteForce(s = input1)
        isPalindromeBruteForce(s = input2)
    }

    // isPalindrome(): Two-Pointer solution, no string construction. Time Complexity: O(n) | Space Complexity: O(1)
    fun isPalindrome(s: String): Boolean {
        println("isPalindrome: Checking if '$s' is a palindrome...")

        // Empty character string is not a palindrome.
        if (s.isEmpty()) {
            println("isPalindrome: $s is empty, not a palindrome.")
            return false
        }

        // One character string is a palindrome.
        if (s.length == 1) {
            println("isPalindrome: $s is single character, it is a palindrome.")
            return true
        }

        // Use two pointers, one at the start and one at the end of the `s` string to check characters at each end.
        var startingPointer = 0
        var endingPointer = s.length - 1

        // Loops until the startingPointer is less than the endingPointer.
        while (startingPointer < endingPointer) {
            // Skip non-alphanumeric characters from the left.
            while (startingPointer < endingPointer && !s[startingPointer].isLetterOrDigit()) {
                println("isPalindrome: WHILE 1: Skipping non-alphanumeric '${s[startingPointer]}' at $startingPointer, moving left.")
                startingPointer++
            }
            // Skip non-alphanumeric characters from the right.
            while (startingPointer < endingPointer && !s[endingPointer].isLetterOrDigit()) {
                println("isPalindrome: WHILE 2: Skipping non-alphanumeric '${s[endingPointer]}' at $endingPointer, moving right.")
                endingPointer--
            }
            val leftCharacter = s[startingPointer].lowercaseChar()
            val rightCharacter = s[endingPointer].lowercaseChar()
            println("isPalindrome: WHILE: LeftCharacter: $leftCharacter | RightCharacter: $rightCharacter")

            // Compare characters (case-insensitive). If they don't match, not a palindrome.
            if (startingPointer < endingPointer && leftCharacter != rightCharacter) {
                println("isPalindrome: Mismatch at indices $startingPointer ('${leftCharacter}') and $endingPointer ('${rightCharacter}'), not a palindrome.\n")
                return false
            }
            startingPointer++
            endingPointer--
        }

        println("isPalindrome: '$s' is a palindrome.\n")
        return true
    }

    // isPalindromeKotlin(): Solution using Kotlin functions. Time Complexity: O(n) + O(n) = O(n) | Space Complexity: O(n)
    fun isPalindromeKotlin(s: String): Boolean {
        println("isPalindromeKotlin: Checking if '$s' is a palindrome...")

        // Create a mutable StringBuilder to efficiently build the filtered string (Using StringBuilder avoids O(n^2)
        // cost of repeated string concatenation)
        val stringBuilder = StringBuilder()

        // Loop through each character in the input string
        for (character in s) {

            // Check if the character is alphanumeric (letter or digit), this filters out spaces, punctuation, etc.
            if (character.isLetterOrDigit()) {

                // Convert the character to lowercase and append it to StringBuilder, this ensures case-insensitive
                // comparison later.
                stringBuilder.append(character.lowercaseChar())
                println("isPalindromeKotlin: Character $character is alphanumeric, appending.")
            } else {
                println("isPalindromeKotlin: Character $character is not alphanumeric, skipping.")
            }
        }

        val originalString = stringBuilder.toString()
        val reversedString = originalString.reversed() // Reverse the string and compare it with the original filtered string.
        val areStringsEquivalent = reversedString == originalString

        println("isPalindromeKotlin: Original string '$originalString' and reversed string '$reversedString' are palindromes: $areStringsEquivalent\n")
        return areStringsEquivalent
    }

    // isPalindromeBruteForce(): Two for-loop solution. Time Complexity: O(n) + O(n) = O(n) | Space Complexity: O(n)
    fun isPalindromeBruteForce(s: String): Boolean {
        println("isPalindromeBruteForce: Checking if '$s' is a palindrome...")

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

        // Use StringBuilder pattern to construct the strings.
        val originalStringBuilder: StringBuilder = StringBuilder()
        val reversedStringBuilder: StringBuilder = StringBuilder()

        // Loop through the string `s` in reverse, constructing the string and omitting non-alphanumeric characters.
        for (i in s.length - 1 downTo 0) {
            val currentCharacter = s[i]
            if (currentCharacter.isLetterOrDigit()) {
                println("isPalindromeBruteForce: FOR (RIGHT) Current character $currentCharacter at $i is alphanumeric, appending to reversedStringBuilder.")
                reversedStringBuilder.append(currentCharacter.lowercaseChar())
            } else {
                println("isPalindromeBruteForce: FOR (RIGHT) Current character $currentCharacter at $i is not alphanumeric, skipping.")
            }
        }

        // Loop through the string `s` normally to get the filtered original string without spaces or non-alphanumeric
        // characters.
        for (i in 0 until s.length) {
            val currentCharacter = s[i]
            if (currentCharacter.isLetterOrDigit()) {
                println("isPalindromeBruteForce: FOR (LEFT) Current character $currentCharacter at $i is alphanumeric, appending to originalStringBuilder.")
                originalStringBuilder.append(currentCharacter.lowercaseChar())
            } else {
                println("isPalindromeBruteForce: FOR (LEFT) Current character $currentCharacter at $i is not alphanumeric, skipping.")
            }
        }

        val reversedString = reversedStringBuilder.toString()
        val originalString = originalStringBuilder.toString()
        val areStringsEquivalent = reversedString == originalString

        println("isPalindromeBruteForce: Original string '$originalString' and reversed string '$reversedString' are palindromes: $areStringsEquivalent\n")
        return areStringsEquivalent
    }
}