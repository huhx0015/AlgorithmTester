package com.huhx0015.problems.strings;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Michael Yoon Huh on 2/22/2017.
 */

public class CTCI1ArraysStrings {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    private static final int ASCII_SIZE = 256;

    /** MAIN SOLUTIONS _________________________________________________________________________ **/

    public static void main(String[] args) {

        System.out.println("isUniqueCharacterString(): " + isUniqueCharacterString("hello") + "\n");
        System.out.println("IsStringPerrmuationOfPalindrome(): " + isStringPermutationOfPalindrome("helleh"));
    }

    /** CTCI : 1.1 SOLUTIONS ___________________________________________________________________ **/

    // 1.1: STRING WITH ALL UNIQUE CHARACTERS (HASHMAP) | COMPLEXITY: O(N) | SPACE: O(N)
    public static boolean isUniqueCharacterString(String string) {

        HashMap<Character, Character> map = new HashMap<>();

        for (char character : string.toCharArray()) {
            if (!map.containsKey(character)) {
                System.out.println("isUniqueCharacterString(): Unique Character Added: " + character);
                map.put(character, character);
            } else {
                System.out.println("isUniqueCharacterString(): This string does not have unique characters.");
                return false; // This character was already added, so the string is not of unique characters.
            }
        }
        return true;
    }

    // 1.1: STRING WITH ALL UNIQUE CHARACTERS (UNICODE) | BEST: O(1) | WORST: O(N^2)
    // NOTES: Downside of this approach is that array needs to be increased in size each time a new
    // unique character is added.
    public static boolean isUniqueCharacterStringUnicode(String string) {

        int size = 0;
        char[] uniqueList = new char[0];

        for (char c : string.toCharArray()) {

            if (size == 0) {
                size++;
                System.out.println("isUniqueCharacterStringUnicode(): Unique Character Added: " + c);

                uniqueList = new char[size];
                uniqueList[0] = c;
            } else {

                // Check if character is in uniqueList.
                for (int x = 0; x < uniqueList.length; x++) {
                    if (c == uniqueList[x]) {
                        return false;
                    }
                }

                size++;
                char[] newUniqueList = new char[size];

                for (int y = 0; y < uniqueList.length; y++) {
                    newUniqueList[y] = uniqueList[y];
                }
                System.out.println("isUniqueCharacterStringUnicode(): Unique Character Added: " + c);
                newUniqueList[uniqueList.length] = c;
                uniqueList = newUniqueList;
            }
        }
        return true;
    }

    // 1.1: STRING WITH ALL UNIQUE CHARACTERS (ASCII) | BEST: O(1) | WORST: O(N)
    public static boolean isUniqueCharacterStringAscii(String string) {

        // If the string is greater than the number of unique ASCII characters available, it's not
        // going to be composed of unique characters.
        if (string.length() > ASCII_SIZE) {
            return false;
        }

        boolean[] uniqueList = new boolean[ASCII_SIZE];
        for (int i = 0; i < string.length(); i++) {
            int value = string.charAt(i);

            if (uniqueList[value]) {
                return false; // Character has already been found.
            }
            System.out.println("isUniqueCharacterStringAscii(): Unique Character Added: " + string.charAt(i));
            uniqueList[value] = true;
        }

        return true;
    }

    /** CTCI : 1.2 SOLUTIONS ___________________________________________________________________ **/

    // 1.2: CHECK IF TWO STRINGS ARE PERMUTATIONS OF EACH OTHER. (NON-SORT)
    public static boolean areStringsPermutationsWithoutSorting(String s1, String s2) {

        // Check if string lengths are equal. If not, they are not permutations of each other.
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> s1Map = new HashMap<>();

        // Builds the HashMap for the first string.
        for (char c1 : s1.toCharArray()) {
            if (s1Map.containsKey(c1)) {
                int frequency = s1Map.get(c1);
                s1Map.put(c1, frequency + 1);
            } else {
                s1Map.put(c1, 1);
            }
        }

        for (char c2 : s2.toCharArray()) {

            if (s1Map.containsKey(c2)) {
                int frequency = s1Map.get(c2);

                if (frequency < 1) {
                    return false; // Indicates a mismatch in frequency of characters.
                } else {
                    s1Map.put(c2, frequency - 1);
                }
            } else {
                return false; // Indicates that the second string has a character that is not present in first string.
            }
        }

        return true;
    }

    // 1.2: CHECK IF TWO STRINGS ARE PERMUTATIONS OF EACH OTHER. (SORTED, CHAR)
    public static boolean areStringsPermutationsChar(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        for (int i = 0; i < s1Array.length; i++) {
            if (s1Array[i] != s2Array[i]) {
                return false;
            }
        }

        return true;
    }

    // 1.2: CHECK IF TWO STRINGS ARE PERMUTATIONS OF EACH OTHER. (SORTED, STRINGS)
    public static boolean areStringsPermutations(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        s1 = new String(s1Array);
        s2 = new String(s2Array);

        return s1.equals(s2);
    }

    /** CTCI : 1.3 SOLUTIONS ___________________________________________________________________ **/

    // 1.3: REPLACE ALL SPACES WITH '%20' USING ONLY CHAR ARRAYS.
    public static char[] urlify(char[] input, int length) {

        int spaceCounter = 0;
        for (int x = 0; x < length; x++) {
            if (input[x] == ' ') {
                spaceCounter++;
            }
        }

        int newLength = length + spaceCounter * 2;

        for (int i = length - 1; i >= 0; i--) {
            if (input[i] == ' ') {
                input[newLength - 1] = '0';
                input[newLength - 2] = '2';
                input[newLength - 3] = '%';
                newLength = newLength - 3;
                System.out.println("NewLength: " + newLength);
            } else {
                input[newLength - 1] = input[i];
                newLength = newLength - 1;
            }
        }

        return input;
    }

    // 1.3: REPLACE ALL SPACES WITH '%20' USING STRINGS.
    public static String urlifyString(String input) {
        String newString = input.trim();
        newString = newString.replace(" ", "%20");
        return newString;
    }

    /** CTCI : 1.4 SOLUTIONS ___________________________________________________________________ **/

    // 1.4: PALINDROME PERMUTATION: CHECK IF A STRING IS A PERMUTATION OF A PALINDROME.
    // PALINDROME: WORD OR PHRASE THAT IS THE SAME FORWARDS AND BACKWARDS.
    // PERMUTATION: REARRANGEMENT OF LETTERS.
    // OPERATING TIME: O(N)
    public static boolean isStringPermutationOfPalindrome(String input) {
        HashMap<Character, Integer> characterMap = getCharacterFrequencyTable(input.toLowerCase());

        // Check characters to see if there is more than one odd character.
        return (!checkMoreThanOneOdd(characterMap));
    }

    // Builds character frequency table of characters.
    private static HashMap<Character, Integer> getCharacterFrequencyTable(String input) {
        HashMap<Character, Integer> characterMap = new HashMap<>();

        // Count occurrence of each character in the hash table.
        for (Character c : input.toCharArray()) {
            System.out.println("getCharacterFrequencyTable: Current character: " + c);

            // Check if current character is a valid letter.
            if (Character.isLetter(c)) {
                if (characterMap.containsKey(c)) {
                    int characterCount = characterMap.get(c);

                    System.out.println("getCharacterFrequencyTable: Character found, current count: " + characterCount);
                    characterMap.put(c, characterCount + 1);
                } else {
                    System.out.println("getCharacterFrequencyTable: Character encountered for the first time: " + c);
                    characterMap.put(c, 1);
                }
            }
        }

        return characterMap;
    }

    // Checks if character frequency table has more than one odd number of characters.
    private static boolean checkMoreThanOneOdd(HashMap<Character, Integer> table) {
        boolean isMoreThanOneOdd = false;

        for (Character c : table.keySet()) {
            System.out.println("checkMoreThanOneOdd: Current Character: " + c);
            int characterCount = table.get(c);
            if (characterCount % 2 == 1) {
                System.out.println("checkMoreThanOneOdd: Found odd character: " + c);
                if (isMoreThanOneOdd) {
                    System.out.println("checkMoreThanOneOdd: More than one odd character found");
                    return true;
                }
                isMoreThanOneOdd = true;
            }
        }

        return false;
    }

    /** CTCI : 1.5 SOLUTIONS ___________________________________________________________________ **/

    // 1.5: GIVEN TWO STRINGS, WRITE A FUNCTION TO CHECK IF THEY ARE ONE EDIT (OR ZERO EDITS) AWAY.
    // THREE TYPES OF EDITS ON STRINGS: INSERT CHARACTER, REMOVE CHARACTER, REPLACE CHARACTER.
    public static boolean checkHowManyEdits(String first, String second) {

        // Check if strings match. If so, return immediately.
        if (first.equals(second)) {
            System.out.println("checkHowManyEdits: Strings match, zero edits away.");
            return true;
        }

        // REPLACE CHARACTER: Check if string lengths are equal; indicates that no insert/remove
        // character has occurred.
        if (first.length() == second.length()) {
            System.out.println("checkHowManyEdits: Character replacement detected.");
            return checkForCharacterReplacement(first, second);
        }

        // INSERTED CHARACTER: If first string is less than length of the second string, indicates
        // that character insertion has occurred.
        else if (first.length() < second.length()) {
            System.out.println("checkHowManyEdits: Character insertion detected.");
            return checkForCharacterInsertions(first, second);
        }

        // REMOVED CHARACTER: If first string is greater than length of the second string, indicates
        // that character removal has occurred.
        else if (first.length() > second.length()) {
            System.out.println("checkHowManyEdits: Character removal detected.");
            return checkForCharacterInsertions(second, first);
        }

        else {
            return false;
        }
    }

    // Checks how many characters have been replaced compared to the first string.
    private static boolean checkForCharacterReplacement(String first, String second) {
        int replacedCharacterCount = 0;

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                replacedCharacterCount++;
                System.out.println("checkForCharacterReplacement: Replaced character found. Count: " + replacedCharacterCount);
            }
        }

        // If more than one character replacement, two or more edits are away.
        if (replacedCharacterCount < 2) {
            return true;
        } else {
            return false;
        }
    }

    // Checks how many characters have been inserted compared to the first string.
    private static boolean checkForCharacterInsertions(String first, String second) {

        // Check if second string length is greater than one; if so, indicates that the string is
        // has more than one edit.
        if ( (second.length() - first.length()) >= 2) {
            return false;
        }

        int insertionCharacterCount = 0;
        int firstIndexCounter = 0;
        for (int i = 0; i < second.length(); i++) {
            if (firstIndexCounter < first.length()) {
                if (first.charAt(firstIndexCounter) == second.charAt(i)) {
                    firstIndexCounter++;
                } else {
                    insertionCharacterCount++;
                }
            }
        }

        // Checks how many characters have been inserted/edited compared to the first string.
        if (insertionCharacterCount < 2) {
            return true;
        } else {
            return false;
        }
    }

    /** CTCI : 1.6 SOLUTIONS ___________________________________________________________________ **/
}
