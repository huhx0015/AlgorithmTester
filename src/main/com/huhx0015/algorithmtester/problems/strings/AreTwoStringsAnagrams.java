package main.com.huhx0015.algorithmtester.problems.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michael Yoon Huh on 5/4/2017.
 *
 * DEFINITION OF ANAGRAM:
 * A word, phrase, or name formed by rearranging the letters of another, such as cinema, formed from iceman.
 *
 */
public class AreTwoStringsAnagrams {

    public static void main(String[] arg) {

        areAnagrams("Key", "yek");
    }

    // TWO CONDITIONS NEED TO BE MET TO BE ANAGRAMS:
    // 1. STRINGS ARE OF SAME LENGTH
    // 2. STRINGS MUST HAVE THE SAME FREQUENCY OF CHARACTERS
    public static boolean areAnagrams(String s1, String s2) {

        // Check if s1 and s2 are the same size.
        if (s1.length() != s2.length()) {
            System.out.println("areAnagrams(): Not a anagram, strings are of different length.");
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>(); // Stores the character frequencies in this hashmap.

        // Convert the strings to char arrays.
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        // Since the same length check has already been done, we can use the length of one of the strings.
        for (int i = 0; i < s1Array.length; i++) {

            // Get the current ith characters from both arrays.
            char c1 = s1Array[i];
            char c2 = s2Array[i];

            // Get current character count from the HashMap.
            int c1Count = map.get(c1) != null ? map.get(c1) : 0; // IF NULL, value is set at 1;
            int c2Count = map.get(c2) != null ? map.get(c2) : 0; // IF NULL, value is set at 1;

            // Add character to map and update the count.
            map.put(c1, c1Count);
            map.put(c2, c2Count);
        }

        // Iterate through the HashMap to check if all character counts are even.
        // Note: Can use entry.getKey() to get the key value.
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            int charCount = entry.getValue();

            // Even/Odd check
            if (charCount % 2 != 0) {

                System.out.println("areAnagrams(): Not a anagram, failed the character count frequency check.");
                return false;
            }

        }

        System.out.println("areAnagrams(): These are anagrams!");
        return true;

    }
}
