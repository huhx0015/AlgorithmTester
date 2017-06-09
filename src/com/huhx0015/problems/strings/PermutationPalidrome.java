package com.huhx0015.problems.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Interview Cake:
 *
 * Write an efficient function that checks whether any permutation ↴ of an input string is a palindrome ↴ .
 *
 * You can assume the input string only contains lowercase letters.
 *
 * Examples:
 *
 * "civic" should return true
 * "ivicc" should return true
 * "civil" should return false
 * "livci" should return false
 *
 * NOTE:
 * "But 'ivicc' isn't a palindrome!"
 * If you had this thought, read the question again carefully. We're asking if any permutation of the string is a
 * palindrome. Spend some extra time ensuring you fully understand the question before starting. Jumping in with a
 * flawed understanding of the problem doesn't look good in an interview.
 *
 * NOTE 2:
 * Think of this question in this way. Are any assortments of the input string a palindrome?
 * "ivicc" = NOPE
 * "civic" = YEA! <---- If at least one permutation that is a palindrome is found, this input string is a winner!
 * "ccivi" = NOPE
 *
 * DEFINITION OF PERMUTATION:
 * One of the many different ways or forms in which something exists or can be arranged — permutation in a sentence.
 *
 * DEFINITION OF PALINDROME:
 * A word, phrase, or sequence that reads the same backward as forward, e.g.
 *
 * URL: https://www.interviewcake.com/question/java/permutation-palindrome
 *
 * Time-Complexity Analysis:
 *
 * Because we loop through the entire number of characters in the input once, adding characters into the HashSet and
 * determining if this is a palindrome by the number of odd characters, runtime complexity is O(n), with n being number
 * of characters in the input, with space complexity being O(k), with k being the number of possible characters,
 * due to using a HashSet.
 *
 * Created by Michael Yoon Huh on 5/9/2017.
 */

public class PermutationPalidrome {

    public static boolean isPalindrome(String input) {

        // Converts input to lower case and creates a char array of characters from the input.
        char[] charArray = input.toLowerCase().toCharArray();

        // Uses a HashSet to store character frequency.
        Set<Character> oddCharacters = new HashSet<>();

        // Scan all frequencies of the characters in the char array.
        for (char c : charArray) {

            // If we already added this character, then we remove it from the HashSet.
            if (oddCharacters.contains(c)) {
                oddCharacters.remove(c);
            } else {
                oddCharacters.add(c);
            }
        }

        // We know that for palindromes to work, we need at least one or zero number of characters of odd frequencies.
        // Any more than that, none of the permutations can ever be a palindrome.
        if (oddCharacters.size() <= 1) {
            System.out.println("isPalindrome(): " + input + " has permutations that can be palindromes!");
            return true;
        } else {
            System.out.println("isPalindrome(): " + input + " has no permutations that can be palindromes.");
            return false;
        }
    }

    public static void main(String[] args) {
        isPalindrome("civic");
        isPalindrome("ivicc");
        isPalindrome("civil");
        isPalindrome("livci");
    }
}
