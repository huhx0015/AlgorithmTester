package com.huhx0015.algorithmtester.twentytwentysix.problems.arrays

/**
 * NeetCode.io
 *
 * Problem: Longest Common Prefix
 * Difficulty: Easy
 *
 * You are given an array of strings strs. Return the longest common prefix of all the strings.
 *
 * If there is no longest common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["bat","bag","bank","band"]
 * Output: "ba"
 *
 * Example 2:
 * Input: strs = ["dance","dag","danger","damage"]
 * Output: "da"
 *
 * Example 3:
 * Input: strs = ["neet","feet"]
 * Output: ""
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] is made up of lowercase English letters if it is non-empty.
 *
 * CONDITIONS:
 * If the input array has any prefixes that don't match, the output is blank.
 */
object LongestCommonPrefix {

    @JvmStatic fun main(args: Array<String>) {
        val input1 = arrayOf("bat", "bag", "bank", "band")
        val input2 = arrayOf("dance", "dag", "danger", "damage")
        val input3 = arrayOf("neet", "feet")

        val result1 = longestCommonPrefix(input1)
        println("Longest Common Prefix: RESULT: $result1\n")

        val result2 = longestCommonPrefix(input2)
        println("Longest Common Prefix: RESULT: $result2\n")

        val result3 = longestCommonPrefix(input3)
        println("Longest Common Prefix: RESULT: $result3\n")
    }

    // longestCommonPrefix():
    // Time Complexity: O(n · m) | n = number of strings | m = length of the longest string (or initial prefix)
    // Space Complexity: O(1)
    fun longestCommonPrefix(strs: Array<String>): String {
        // Initialize the prefix as the first string in the array.
        // We'll progressively shrink this until it matches all strings.
        var prefix = strs[0]
        println("Longest Common Prefix: Prefix starting with $prefix")

        // Loops through the strs string array, checking each string.
        for (string in strs) {

            // Keep shrinking the prefix until the current string starts with it.
            // If it doesn't match, remove the last character from prefix.
            while (!string.startsWith(prefix)) {
                println("Longest Common Prefix: WHILE: Current string $string doesn't start with $prefix")

                // Reduce the prefix by removing the last character.
                prefix = prefix.substring(0, prefix.length - 1)
                println("Longest Common Prefix: Prefix was updated, prefix is now $prefix")

                // If prefix becomes empty, there is no common prefix.
                if (prefix.isEmpty()) {
                    println("Longest Common Prefix: WHILE: prefix is empty, returning empty string")
                    return ""
                }
            }
        }

        // After checking all strings, prefix will be the longest common prefix.
        println("Longest Common Prefix: Finished, longest common prefix was $prefix")
        return prefix
    }
}