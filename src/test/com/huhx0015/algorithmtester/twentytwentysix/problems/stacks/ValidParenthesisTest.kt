package com.huhx0015.algorithmtester.twentytwentysix.problems.stacks

import com.huhx0015.algorithmtester.twentytwentysix.problems.stacks.ValidParenthesis.isValid
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidParenthesisTest {

    @Test
    fun testValidParenthesis() {
        val input1 = "[]"
        val valid1 = isValid(input1)
        assertEquals(true, valid1)

        val input2 = "([{}])"
        val valid2 = isValid(input2)
        assertEquals(true, valid2)

        val input3 = "[(])"
        val valid3 = isValid(input3)
        assertEquals(false, valid3)

        val input4 = "[[(())]]"
        val valid4 = isValid(input4)
        assertEquals(true, valid4)

        val input5 = "[[(())]"
        val valid5 = isValid(input5)
        assertEquals(false, valid5)
    }
}