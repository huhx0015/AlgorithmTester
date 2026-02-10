package main.com.huhx0015.algorithmtester.problems.strings

import java.util.HashMap

/**
 * Created by Michael Yoon Huh on 5/4/2017.
 *
 * DEFINITION OF ANAGRAM:
 *
 * A word, phrase, or name formed by rearranging the letters of another, such as cinema, formed from iceman.
 */
object AreTwoStringsAnagrams {

    @JvmStatic fun main(arg: Array<String>) {
        areAnagrams("Key", "yek")
    }

    // TWO CONDITIONS NEED TO BE MET TO BE ANAGRAMS:
    // 1. STRINGS ARE OF SAME LENGTH
    // 2. STRINGS MUST HAVE THE SAME FREQUENCY OF CHARACTERS
    fun areAnagrams(s1: String, s2: String): Boolean {

        // Check if s1 and s2 are the same size.
        if (s1.length != s2.length) {
            println("areAnagrams(): Not a anagram, strings are of different length.")
            return false
        }

        val map = HashMap<Char, Int>() // Stores the character frequencies in this hashmap.

        // Convert the strings to char arrays.
        val s1Array = s1.lowercase().toCharArray()
        val s2Array = s2.lowercase().toCharArray()

        // Since the same length check has already been done, we can use the length of one of the strings.
        for (i in s1Array.indices) {

            // Get the current ith characters from both arrays.
            val c1 = s1Array[i]
            val c2 = s2Array[i]

            // Get current character count from the HashMap.
            val c1Count = if (map[c1] != null) map[c1] else 0 // IF NULL, value is set at 0;
            val c2Count = if (map[c2] != null) map[c2] else 0 // IF NULL, value is set at 0;

            // Add character to map and update the count.
            c1Count?.let { map.put(c1, it) }
            c2Count?.let { map.put(c2, it) }
        }

        // Iterate through the HashMap to check if all character counts are even.
        // Note: Can use entry.getKey() to get the key value.
        for ((key, value) in map) {

            val charCount: Int = value

            // Even/Odd check
            if (charCount % 2 != 0) {
                println("areAnagrams(): Not a anagram, failed the character count frequency check.")
                return false
            }
        }

        println("areAnagrams(): These are anagrams!")
        return true
    }
}
