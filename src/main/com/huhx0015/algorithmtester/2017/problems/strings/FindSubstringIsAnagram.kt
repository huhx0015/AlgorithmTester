package main.com.huhx0015.algorithmtester.problems.strings

import java.util.*

/**
 * Created by Michael Yoon Huh on 5/4/2017.

 * Given two strings, find if any substring of s1 is an anagram (permutation) of s2.

 * Example: "password", "sap" = false;

 * TIP 1: Have to worry about duplicates
 * TIP 2: Two hashmaps?
 * TIP 3: If in a interview, ask if we can implement first for non-duplicate.

 * URL: http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
 */
object FindSubstringIsAnagram {

    @JvmStatic fun main(args: Array<String>) {
        substringAnagram("password", "sap")
        substringAnagram("ABCD", "BACDGABCDA")
        substringAnagram("AABA", "AAABABAA")
    }

    fun substringAnagram(pattern: String, text: String): List<Int>? {

        // Check the strings. If the first string is greater than the second string, there is no way it can ever be
        // an anagram.
        if (pattern.length > text.length) {
            println("substringAnagram(): No substrings exist, as pattern string is greater than text.")
            return null
        }

        var substringIndexList: MutableList<Int>? = null // Stores the substring index list.

        // Generates a character count for the pattern string.
        val patternMap = buildCharacterCountMap(pattern)

        // While the pattern length + current position is less than or equal to text length (to see if it is a substring
        // within the text).
        var x = 0
        while (x + pattern.length <= text.length) {

            val window = text.substring(x, x + pattern.length)

            // Check if anagram exists in window.
            if (findAnagramInString(window, patternMap)) {

                // Lazy load the substring list until we need it.
                if (substringIndexList == null) {
                    substringIndexList = LinkedList<Int>()
                }

                substringIndexList.add(x) // We add the position value into the index list.
                println("substringAnagram(): Found substring at position: " + x)
            }
            x++
        }

        return substringIndexList
    }

    // Helper method for building a hashmap that contains the character count frequencies given a string.
    private fun buildCharacterCountMap(string: String): HashMap<Char, Int> {

        val map = HashMap<Char, Int>() // Stores the character frequency.

        // Loops through string to determine char count frequency. Loop is O(p), p = length of string.
        for (character in string.toCharArray()) {

            // Gets the char count of the character if already on the map. Otherwise, set at the count of 1.
            val charCount = if (map.containsKey(character)) map[character] else 1

            // Updates the char count on the map.
            map.put(character, charCount!! + 1)
        }

        return map
    }

    // Helper method for determining if an anagram exists in the string, given the patternMap.
    private fun findAnagramInString(window: String, patternMap: HashMap<Char, Int>): Boolean {

        // Builds character count from the window string.
        val windowMap = buildCharacterCountMap(window)

        // Iterates through the windowMap and compares values against the patternMap.
        for ((character, count) in windowMap) {

            // If patternMap contains current character, we compare the counts of the character in pattern map.
            if (patternMap.containsKey(character)) {

                val patternCount = patternMap[character]

                if (count != patternCount) {
                    return false // Immediately return false, since the counts don't match up.
                }
            } else {
                return false // Immediately return false, since this window string has a character that the pattern string doesn't have.
            }
        }

        return true // If it reaches here, all checks for anagram pass.
    }
}
