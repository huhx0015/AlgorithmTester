package com.huhx0015.algorithmtester.twentyseventeen.problems.strings

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