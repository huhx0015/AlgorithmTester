package com.huhx0015.algorithmtester.twentytwentysix.problems.strings

import com.huhx0015.algorithmtester.twentytwentysix.problems.strings.FizzBuzz.fizzBuzz

/**
 * NeetCode.io
 *
 * Problem: Valid Anagram
 * Difficulty: Easy
 *
 * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
 *
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 *
 * Example 1:
 *
 * Input: s = "racecar", t = "carrace"
 *
 * Output: true
 * Example 2:
 *
 * Input: s = "jar", t = "jam"
 *
 * Output: false
 * Constraints:
 *
 * s and t consist of lowercase English letters.
 */
object ValidAnagram {

    @JvmStatic fun main(args: Array<String>) {
        isAnagram(s = "racecar", t = "carrace")
        isAnagram(s = "jar", t = "jam")
    }

    // isAnagram(): Time Complexity: O(n) | Space Complexity: O(n)
    fun isAnagram(s: String, t: String): Boolean {
        println("IsAnagram: Starting isAnagram to check if $s and $t are anagrams...")

        // Early return condition: Anagrams must be of same length.
        if (s.length != t.length) {
            println("IsAnagram: $s and $t are not of the same length, these are not anagrams.")
            return false
        }

        val firstStringCharacterTable: HashMap<Char, Int> = hashMapOf()
        val secondStringCharacterTable: HashMap<Char, Int> = hashMapOf()

        for (i in 0 until s.length) {
            val firstStringCharacter = s[i] // Gets the string character at position i from 's' string.
            val secondStringCharacter = t[i] // Gets the string character at position i from 't' string.

            println("IsAnagram: FOR: At position $i, where s[$i] is $firstStringCharacter and t[$i] is $secondStringCharacter")

            val firstCharacterCount: Int = (firstStringCharacterTable[firstStringCharacter] ?: 0) + 1
            val secondCharacterCount: Int = (secondStringCharacterTable[secondStringCharacter] ?: 0) + 1

            println("IsAnagram: FOR: $firstStringCharacter count is $firstStringCharacter and $secondStringCharacter count is $secondCharacterCount")

            firstStringCharacterTable[firstStringCharacter] = firstCharacterCount
            secondStringCharacterTable[secondStringCharacter] = secondCharacterCount

            println("IsAnagram: FOR: Updated both hash map tables, moving on to next loop.")
        }

        // Compares the two HashMaps, returns true if the contents of both HashMaps are equal.
        val isAnagram = firstStringCharacterTable == secondStringCharacterTable
        println("IsAnagram: Finished, are $s and $t anagrams: $isAnagram\n")
        return isAnagram
    }
}