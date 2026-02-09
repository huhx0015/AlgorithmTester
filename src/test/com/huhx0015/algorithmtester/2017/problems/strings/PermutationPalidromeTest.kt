package test.com.huhx0015.algorithmtester.problems.strings

import main.com.huhx0015.algorithmtester.problems.strings.PermutationPalidrome
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Created by Michael Yoon Huh on 6/13/2017.
 */
internal class PermutationPalidromeTest {

    @Test
    fun testIsPalindrome() {
        assertEquals(true, PermutationPalidrome.isPalindrome("civic"))
        assertEquals(true, PermutationPalidrome.isPalindrome("ivicc"))
        assertEquals(false, PermutationPalidrome.isPalindrome("civil"))
        assertEquals(false, PermutationPalidrome.isPalindrome("livci"))
    }
}