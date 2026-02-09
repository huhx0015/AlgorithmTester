package main.com.huhx0015.algorithmtester.problems.strings

import java.util.Arrays
import java.util.HashMap

/**
 * Cracking the Coding Interview:

 * Created by Michael Yoon Huh on 2/22/2017.
 */

object CTCI1ArraysStrings {

    /** CLASS VARIABLES ________________________________________________________________________  */

    private val ASCII_SIZE = 256

    /** MAIN SOLUTIONS _________________________________________________________________________  */

    @JvmStatic fun main(args: Array<String>) {

        println("isUniqueCharacterString(): " + isUniqueCharacterString("hello") + "\n")
        println("IsStringPerrmuationOfPalindrome(): " + isStringPermutationOfPalindrome("helleh"))
    }

    /** CTCI : 1.1 SOLUTIONS ___________________________________________________________________  */

    // 1.1: STRING WITH ALL UNIQUE CHARACTERS (HASHMAP) | COMPLEXITY: O(N) | SPACE: O(N)
    fun isUniqueCharacterString(string: String): Boolean {

        val map = HashMap<Char, Char>()

        for (character in string.toCharArray()) {
            if (!map.containsKey(character)) {
                println("isUniqueCharacterString(): Unique Character Added: " + character)
                map.put(character, character)
            } else {
                println("isUniqueCharacterString(): This string does not have unique characters.")
                return false // This character was already added, so the string is not of unique characters.
            }
        }
        return true
    }

    // 1.1: STRING WITH ALL UNIQUE CHARACTERS (UNICODE) | BEST: O(1) | WORST: O(N^2)
    // NOTES: Downside of this approach is that array needs to be increased in size each time a new
    // unique character is added.
    fun isUniqueCharacterStringUnicode(string: String): Boolean {

        var size = 0
        var uniqueList = CharArray(0)

        for (c in string.toCharArray()) {

            if (size == 0) {
                size++
                println("isUniqueCharacterStringUnicode(): Unique Character Added: " + c)

                uniqueList = CharArray(size)
                uniqueList[0] = c
            } else {

                // Check if character is in uniqueList.
                for (x in uniqueList.indices) {
                    if (c == uniqueList[x]) {
                        return false
                    }
                }

                size++
                val newUniqueList = CharArray(size)

                for (y in uniqueList.indices) {
                    newUniqueList[y] = uniqueList[y]
                }
                println("isUniqueCharacterStringUnicode(): Unique Character Added: " + c)
                newUniqueList[uniqueList.size] = c
                uniqueList = newUniqueList
            }
        }
        return true
    }

    // 1.1: STRING WITH ALL UNIQUE CHARACTERS (ASCII) | BEST: O(1) | WORST: O(N)
    fun isUniqueCharacterStringAscii(string: String): Boolean {

        // If the string is greater than the number of unique ASCII characters available, it's not
        // going to be composed of unique characters.
        if (string.length > ASCII_SIZE) {
            return false
        }

        val uniqueList = BooleanArray(ASCII_SIZE)
        for (i in 0..string.length - 1) {
            val value = string[i].toInt()

            if (uniqueList[value]) {
                return false // Character has already been found.
            }
            println("isUniqueCharacterStringAscii(): Unique Character Added: " + string[i])
            uniqueList[value] = true
        }

        return true
    }

    /** CTCI : 1.2 SOLUTIONS ___________________________________________________________________  */

    // 1.2: CHECK IF TWO STRINGS ARE PERMUTATIONS OF EACH OTHER. (NON-SORT)
    fun areStringsPermutationsWithoutSorting(s1: String, s2: String): Boolean {

        // Check if string lengths are equal. If not, they are not permutations of each other.
        if (s1.length != s2.length) {
            return false
        }

        val s1Map = HashMap<Char, Int>()

        // Builds the HashMap for the first string.
        for (c1 in s1.toCharArray()) {
            if (s1Map.containsKey(c1)) {
                val frequency = s1Map[c1]
                s1Map.put(c1, frequency!! + 1)
            } else {
                s1Map.put(c1, 1)
            }
        }

        for (c2 in s2.toCharArray()) {

            if (s1Map.containsKey(c2)) {
                val frequency = s1Map[c2]

                if (frequency!! < 1) {
                    return false // Indicates a mismatch in frequency of characters.
                } else {
                    s1Map.put(c2, frequency - 1)
                }
            } else {
                return false // Indicates that the second string has a character that is not present in first string.
            }
        }

        return true
    }

    // 1.2: CHECK IF TWO STRINGS ARE PERMUTATIONS OF EACH OTHER. (SORTED, CHAR)
    fun areStringsPermutationsChar(s1: String, s2: String): Boolean {

        if (s1.length != s2.length) {
            return false
        }

        val s1Array = s1.toCharArray()
        val s2Array = s2.toCharArray()
        Arrays.sort(s1Array)
        Arrays.sort(s2Array)

        for (i in s1Array.indices) {
            if (s1Array[i] != s2Array[i]) {
                return false
            }
        }

        return true
    }

    // 1.2: CHECK IF TWO STRINGS ARE PERMUTATIONS OF EACH OTHER. (SORTED, STRINGS)
    fun areStringsPermutations(s1: String, s2: String): Boolean {
        var s1 = s1
        var s2 = s2

        if (s1.length != s2.length) {
            return false
        }

        val s1Array = s1.toCharArray()
        val s2Array = s2.toCharArray()

        Arrays.sort(s1Array)
        Arrays.sort(s2Array)
        s1 = String(s1Array)
        s2 = String(s2Array)

        return s1 == s2
    }

    /** CTCI : 1.3 SOLUTIONS ___________________________________________________________________  */

    // 1.3: REPLACE ALL SPACES WITH '%20' USING ONLY CHAR ARRAYS.
    fun urlify(input: CharArray, length: Int): CharArray {

        var spaceCounter = 0
        for (x in 0..length - 1) {
            if (input[x] == ' ') {
                spaceCounter++
            }
        }

        var newLength = length + spaceCounter * 2

        for (i in length - 1 downTo 0) {
            if (input[i] == ' ') {
                input[newLength - 1] = '0'
                input[newLength - 2] = '2'
                input[newLength - 3] = '%'
                newLength = newLength - 3
                println("NewLength: " + newLength)
            } else {
                input[newLength - 1] = input[i]
                newLength = newLength - 1
            }
        }

        return input
    }

    // 1.3: REPLACE ALL SPACES WITH '%20' USING STRINGS.
    fun urlifyString(input: String): String {
        var newString = input.trim { it <= ' ' }
        newString = newString.replace(" ", "%20")
        return newString
    }

    /** CTCI : 1.4 SOLUTIONS ___________________________________________________________________  */

    // 1.4: PALINDROME PERMUTATION: CHECK IF A STRING IS A PERMUTATION OF A PALINDROME.
    // PALINDROME: WORD OR PHRASE THAT IS THE SAME FORWARDS AND BACKWARDS.
    // PERMUTATION: REARRANGEMENT OF LETTERS.
    // OPERATING TIME: O(N)
    fun isStringPermutationOfPalindrome(input: String): Boolean {
        val characterMap = getCharacterFrequencyTable(input.lowercase())

        // Check characters to see if there is more than one odd character.
        return !checkMoreThanOneOdd(characterMap)
    }

    // Builds character frequency table of characters.
    private fun getCharacterFrequencyTable(input: String): HashMap<Char, Int> {
        val characterMap = HashMap<Char, Int>()

        // Count occurrence of each character in the hash table.
        for (c in input.toCharArray()) {
            println("getCharacterFrequencyTable: Current character: " + c)

            // Check if current character is a valid letter.
            if (Character.isLetter(c)) {
                if (characterMap.containsKey(c)) {
                    val characterCount = characterMap[c]

                    println("getCharacterFrequencyTable: Character found, current count: " + characterCount)
                    characterMap.put(c, characterCount!! + 1)
                } else {
                    println("getCharacterFrequencyTable: Character encountered for the first time: " + c)
                    characterMap.put(c, 1)
                }
            }
        }

        return characterMap
    }

    // Checks if character frequency table has more than one odd number of characters.
    private fun checkMoreThanOneOdd(table: HashMap<Char, Int>): Boolean {
        var isMoreThanOneOdd = false

        for (c in table.keys) {
            println("checkMoreThanOneOdd: Current Character: " + c)
            val characterCount = table[c]
            if (characterCount!! % 2 == 1) {
                println("checkMoreThanOneOdd: Found odd character: " + c)
                if (isMoreThanOneOdd) {
                    println("checkMoreThanOneOdd: More than one odd character found")
                    return true
                }
                isMoreThanOneOdd = true
            }
        }

        return false
    }

    /** CTCI : 1.5 SOLUTIONS ___________________________________________________________________  */

    // 1.5: GIVEN TWO STRINGS, WRITE A FUNCTION TO CHECK IF THEY ARE ONE EDIT (OR ZERO EDITS) AWAY.
    // THREE TYPES OF EDITS ON STRINGS: INSERT CHARACTER, REMOVE CHARACTER, REPLACE CHARACTER.
    fun checkHowManyEdits(first: String, second: String): Boolean {

        // Check if strings match. If so, return immediately.
        if (first == second) {
            println("checkHowManyEdits: Strings match, zero edits away.")
            return true
        }

        // REPLACE CHARACTER: Check if string lengths are equal; indicates that no insert/remove
        // character has occurred.
        if (first.length == second.length) {
            println("checkHowManyEdits: Character replacement detected.")
            return checkForCharacterReplacement(first, second)
        } else if (first.length < second.length) {
            println("checkHowManyEdits: Character insertion detected.")
            return checkForCharacterInsertions(first, second)
        } else if (first.length > second.length) {
            println("checkHowManyEdits: Character removal detected.")
            return checkForCharacterInsertions(second, first)
        } else {
            return false
        }// REMOVED CHARACTER: If first string is greater than length of the second string, indicates
        // that character removal has occurred.
        // INSERTED CHARACTER: If first string is less than length of the second string, indicates
        // that character insertion has occurred.
    }

    // Checks how many characters have been replaced compared to the first string.
    private fun checkForCharacterReplacement(first: String, second: String): Boolean {
        var replacedCharacterCount = 0

        for (i in 0..first.length - 1) {
            if (first[i] != second[i]) {
                replacedCharacterCount++
                println("checkForCharacterReplacement: Replaced character found. Count: " + replacedCharacterCount)
            }
        }

        // If more than one character replacement, two or more edits are away.
        return replacedCharacterCount < 2
    }

    // Checks how many characters have been inserted compared to the first string.
    private fun checkForCharacterInsertions(first: String, second: String): Boolean {

        // Check if second string length is greater than one; if so, indicates that the string is
        // has more than one edit.
        if (second.length - first.length >= 2) {
            return false
        }

        var insertionCharacterCount = 0
        var firstIndexCounter = 0
        for (i in 0..second.length - 1) {
            if (firstIndexCounter < first.length) {
                if (first[firstIndexCounter] == second[i]) {
                    firstIndexCounter++
                } else {
                    insertionCharacterCount++
                }
            }
        }

        // Checks how many characters have been inserted/edited compared to the first string.
        return insertionCharacterCount < 2
    }
}
