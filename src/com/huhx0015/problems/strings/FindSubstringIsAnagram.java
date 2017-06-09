package com.huhx0015.problems.strings;

import java.util.*;

/**
 * Created by Michael Yoon Huh on 5/4/2017.
 *
 * Given two strings, find if any substring of s1 is an anagram (permutation) of s2.
 *
 * Example: "password", "sap" = false;
 *
 * TIP 1: Have to worry about duplicates
 * TIP 2: Two hashmaps?
 * TIP 3: If in a interview, ask if we can implement first for non-duplicate.
 *
 * URL: http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
 */
public class FindSubstringIsAnagram {

    public static void main(String[] args) {
        substringAnagram("password", "sap");
        substringAnagram("ABCD", "BACDGABCDA");
        substringAnagram("AABA", "AAABABAA");
    }

    public static List<Integer> substringAnagram(String pattern, String text) {

        // Check the strings. If the first string is greater than the second string, there is no way it can ever be
        // an anagram.
        if (pattern.length() > text.length()) {
            System.out.println("substringAnagram(): No substrings exist, as pattern string is greater than text.");
            return null;
        }

        List<Integer> substringIndexList = null; // Stores the substring index list.

        // Generates a character count for the pattern string.
        HashMap<Character, Integer> patternMap = buildCharacterCountMap(pattern);

        // While the pattern length + current position is less than or equal to text length (to see if it is a substring
        // within the text).
        for (int x = 0; x + pattern.length() <= text.length(); x++) {

            String window = text.substring(x, x + pattern.length());

            // Check if anagram exists in window.
            if (findAnagramInString(window, patternMap)) {

                // Lazy load the substring list until we need it.
                if (substringIndexList == null) {
                    substringIndexList = new LinkedList<>();
                }

                substringIndexList.add(x); // We add the position value into the index list.
                System.out.println("substringAnagram(): Found substring at position: " + x);
            }
        }

        return substringIndexList;
    }

    // Helper method for building a hashmap that contains the character count frequencies given a string.
    private static HashMap<Character, Integer> buildCharacterCountMap(String string) {

        HashMap<Character, Integer> map = new HashMap<>(); // Stores the character frequency.

        // Loops through string to determine char count frequency. Loop is O(p), p = length of string.
        for (char character : string.toCharArray()) {

            // Gets the char count of the character if already on the map. Otherwise, set at the count of 1.
            int charCount = map.containsKey(character) ? map.get(character) : 1;

            // Updates the char count on the map.
            map.put(character, charCount + 1);
        }

        return map;
    }

    // Helper method for determining if an anagram exists in the string, given the patternMap.
    private static boolean findAnagramInString(String window, HashMap<Character, Integer> patternMap) {

        // Builds character count from the window string.
        HashMap<Character, Integer> windowMap = buildCharacterCountMap(window);

        // Iterates through the windowMap and compares values against the patternMap.
        for (Map.Entry<Character, Integer> entry : windowMap.entrySet()) {

            char character = entry.getKey();
            int count = entry.getValue();

            // If patternMap contains current character, we compare the counts of the character in pattern map.
            if (patternMap.containsKey(character)) {

                int patternCount = patternMap.get(character);

                if (count != patternCount) {
                    return false; // Immediately return false, since the counts don't match up.
                }
            } else {
                return false; // Immediately return false, since this window string has a character that the pattern string doesn't have.
            }
        }

        return true; // If it reaches here, all checks for anagram pass.
    }
}
