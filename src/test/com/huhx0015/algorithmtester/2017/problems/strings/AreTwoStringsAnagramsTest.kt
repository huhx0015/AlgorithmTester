package test.com.huhx0015.algorithmtester.problems.strings

import main.com.huhx0015.algorithmtester.problems.strings.AreTwoStringsAnagrams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Created by Michael Yoon Huh on 6/13/2017.
 */
internal class AreTwoStringsAnagramsTest {

    @Test
    fun testAreAnagrams() {
        assertEquals(true, AreTwoStringsAnagrams.areAnagrams("Key", "yek"))
    }
}