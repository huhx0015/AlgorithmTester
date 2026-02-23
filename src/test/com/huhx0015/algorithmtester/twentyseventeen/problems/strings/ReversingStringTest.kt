package com.huhx0015.algorithmtester.twentyseventeen.problems.strings

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Created by Michael Yoon Huh on 6/13/2017.
 */
internal class ReversingStringTest {

    @Test
    fun testReversingString() {
        assertEquals(TEST_REVERSED_STRING, ReversingString.reverseString(TEST_INPUT_STRING))
    }

    companion object {
        private val TEST_INPUT_STRING = "hello my name is korean"
        private val TEST_REVERSED_STRING = "naerok si eman ym olleh"
    }
}