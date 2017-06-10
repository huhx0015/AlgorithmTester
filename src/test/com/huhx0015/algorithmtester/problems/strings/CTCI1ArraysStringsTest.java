package test.com.huhx0015.algorithmtester.problems.strings;

import org.junit.jupiter.api.Test;
import static main.com.huhx0015.algorithmtester.problems.strings.CTCI1ArraysStrings.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Michael Yoon Huh on 6/9/2017.
 */
class CTCI1ArraysStringsTest {

    @Test
    void testIsUniqueCharacterString() {
        assertEquals(false, isUniqueCharacterString("hello"));
        assertEquals(true, isUniqueCharacterString("korea"));
    }

    @Test
    void testIsUniqueCharacterStringUnicode() {
        assertEquals(true, isUniqueCharacterStringUnicode("ㄱㄴㄷㄹㅁㅂㅅㅇ"));
        assertEquals(false, isUniqueCharacterStringUnicode("12345678909"));
    }

    @Test
    void testIsUniqueCharacterStringAscii() {
        assertEquals(false, isUniqueCharacterStringAscii("blahblah"));
        assertEquals(true, isUniqueCharacterStringAscii("might"));
    }

    @Test
    void testAreStringsPermutationsWithoutSorting() {
        assertEquals(true, areStringsPermutationsWithoutSorting("hello", "olleh"));
        assertEquals(false, areStringsPermutationsWithoutSorting("mike", "janet"));
        assertEquals(false, areStringsPermutationsWithoutSorting("arti", "ratt"));
    }

    @Test
    void testAreStringsPermutationsChar() {
        assertEquals(true, areStringsPermutationsChar("hello", "olleh"));
        assertEquals(false, areStringsPermutationsChar("mike", "janet"));
        assertEquals(false, areStringsPermutationsChar("arti", "ratt"));
    }

    @Test
    void testAreStringsPermutations() {
        assertEquals(true, areStringsPermutations("hello", "olleh"));
        assertEquals(false, areStringsPermutations("mike", "janet"));
        assertEquals(false, areStringsPermutations("arti", "ratt"));
    }

    @Test
    void testUrlify() {
        String testString = "A B C";
        String expectedString = "A%20B%20C";
        char[] testChar = testString.toCharArray();
        char[] expectedChar = expectedString.toCharArray();
        //assertEquals(expectedChar, urlify(testChar, testChar.length));
    }

    @Test
    void testUrlifyString() {
        assertEquals("A%20B%20C", urlifyString("A B C"));
    }

    @Test
    void testIsStringPermutationOfPalindrome() {
        assertEquals(true, isStringPermutationOfPalindrome("helleh"));
        assertEquals(false, isStringPermutationOfPalindrome("bobby"));
    }

    @Test
    void testCheckHowManyEdits() {
        String testString1 = "Bobby";
        String testString2 = "Bobbo";
        String testString3 = "Bob";

        assertEquals(true, checkHowManyEdits(testString1, testString1));
        assertEquals(true, checkHowManyEdits(testString1, testString2));
        assertEquals(false, checkHowManyEdits(testString1, testString3));
    }
}