package test.com.huhx0015.algorithmtester.problems.strings

import main.com.huhx0015.algorithmtester.problems.strings.CTCI1ArraysStrings.areStringsPermutations
import main.com.huhx0015.algorithmtester.problems.strings.CTCI1ArraysStrings.areStringsPermutationsChar
import main.com.huhx0015.algorithmtester.problems.strings.CTCI1ArraysStrings.areStringsPermutationsWithoutSorting
import main.com.huhx0015.algorithmtester.problems.strings.CTCI1ArraysStrings.checkHowManyEdits
import main.com.huhx0015.algorithmtester.problems.strings.CTCI1ArraysStrings.isStringPermutationOfPalindrome
import main.com.huhx0015.algorithmtester.problems.strings.CTCI1ArraysStrings.isUniqueCharacterString
import main.com.huhx0015.algorithmtester.problems.strings.CTCI1ArraysStrings.isUniqueCharacterStringAscii
import main.com.huhx0015.algorithmtester.problems.strings.CTCI1ArraysStrings.isUniqueCharacterStringUnicode
import main.com.huhx0015.algorithmtester.problems.strings.CTCI1ArraysStrings.urlifyString
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Created by Michael Yoon Huh on 6/9/2017.
 */
internal class CTCI1ArraysStringsTest {

    @Test
    fun testIsUniqueCharacterString() {
        assertEquals(false, isUniqueCharacterString("hello"))
        assertEquals(true, isUniqueCharacterString("korea"))
    }

    @Test
    fun testIsUniqueCharacterStringUnicode() {
        assertEquals(true, isUniqueCharacterStringUnicode("ㄱㄴㄷㄹㅁㅂㅅㅇ"))
        assertEquals(false, isUniqueCharacterStringUnicode("12345678909"))
    }

    @Test
    fun testIsUniqueCharacterStringAscii() {
        assertEquals(false, isUniqueCharacterStringAscii("blahblah"))
        assertEquals(true, isUniqueCharacterStringAscii("might"))
    }

    @Test
    fun testAreStringsPermutationsWithoutSorting() {
        assertEquals(true, areStringsPermutationsWithoutSorting("hello", "olleh"))
        assertEquals(false, areStringsPermutationsWithoutSorting("mike", "janet"))
        assertEquals(false, areStringsPermutationsWithoutSorting("arti", "ratt"))
    }

    @Test
    fun testAreStringsPermutationsChar() {
        assertEquals(true, areStringsPermutationsChar("hello", "olleh"))
        assertEquals(false, areStringsPermutationsChar("mike", "janet"))
        assertEquals(false, areStringsPermutationsChar("arti", "ratt"))
    }

    @Test
    fun testAreStringsPermutations() {
        assertEquals(true, areStringsPermutations("hello", "olleh"))
        assertEquals(false, areStringsPermutations("mike", "janet"))
        assertEquals(false, areStringsPermutations("arti", "ratt"))
    }

    @Test
    fun testUrlify() {
        val testString = "A B C"
        val expectedString = "A%20B%20C"
        val testChar = testString.toCharArray()
        val expectedChar = expectedString.toCharArray()
        //assertEquals(expectedChar, urlify(testChar, testChar.length));
    }

    @Test
    fun testUrlifyString() {
        assertEquals("A%20B%20C", urlifyString("A B C"))
    }

    @Test
    fun testIsStringPermutationOfPalindrome() {
        assertEquals(true, isStringPermutationOfPalindrome("helleh"))
        assertEquals(false, isStringPermutationOfPalindrome("bobby"))
    }

    @Test
    fun testCheckHowManyEdits() {
        val testString1 = "Bobby"
        val testString2 = "Bobbo"
        val testString3 = "Bob"

        assertEquals(true, checkHowManyEdits(testString1, testString1))
        assertEquals(true, checkHowManyEdits(testString1, testString2))
        assertEquals(false, checkHowManyEdits(testString1, testString3))
    }
}