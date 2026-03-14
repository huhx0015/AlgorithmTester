package com.huhx0015.algorithmtester.twentytwentysix.problems.recursion

import com.huhx0015.algorithmtester.twentytwentysix.problems.recursion.ClimbingStairs.climbStairsDp
import com.huhx0015.algorithmtester.twentytwentysix.problems.recursion.ClimbingStairs.climbStairsMemoization
import com.huhx0015.algorithmtester.twentytwentysix.problems.recursion.ClimbingStairs.climbStairsRecursive
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ClimbingStairsTest {

    @Test
    fun testClimbingStairsRecursive() {
        val testInput1 = 1
        val climbStairsRecursive1 = climbStairsRecursive(testInput1)
        assertEquals(1, climbStairsRecursive1)

        val testInput2 = 2
        val climbStairsRecursive2 = climbStairsRecursive(testInput2)
        assertEquals(2, climbStairsRecursive2)

        val testInput3 = 3
        val climbStairsRecursive3 = climbStairsRecursive(testInput3)
        assertEquals(3, climbStairsRecursive3)

        val testInput4 = 4
        val climbStairsRecursive4 = climbStairsRecursive(testInput4)
        assertEquals(5, climbStairsRecursive4)

        val testInput5 = 5
        val climbStairsRecursive5 = climbStairsRecursive(testInput5)
        assertEquals(8, climbStairsRecursive5)
    }

    @Test
    fun testClimbingStairsDynamicProgramming() {
        val testInput1 = 1
        val climbStairsDp1 = climbStairsDp(testInput1)
        assertEquals(1, climbStairsDp1)

        val testInput2 = 2
        val climbStairsDp2 = climbStairsDp(testInput2)
        assertEquals(2, climbStairsDp2)

        val testInput3 = 3
        val climbStairsDp3 = climbStairsDp(testInput3)
        assertEquals(3, climbStairsDp3)

        val testInput4 = 4
        val climbStairsDp4 = climbStairsDp(testInput4)
        assertEquals(5, climbStairsDp4)

        val testInput5 = 5
        val climbStairsDp5 = climbStairsDp(testInput5)
        assertEquals(8, climbStairsDp5)
    }

    @Test
    fun testClimbingStairsMemoization() {
        val testInput1 = 1
        val climbStairsMemoization1 = climbStairsMemoization(testInput1)
        assertEquals(1, climbStairsMemoization1)

        val testInput2 = 2
        val climbStairsMemoization2 = climbStairsMemoization(testInput2)
        assertEquals(2, climbStairsMemoization2)

        val testInput3 = 3
        val climbStairsMemoization3 = climbStairsMemoization(testInput3)
        assertEquals(3, climbStairsMemoization3)

        val testInput4 = 4
        val climbStairsMemoization4 = climbStairsMemoization(testInput4)
        assertEquals(5, climbStairsMemoization4)

        val testInput5 = 5
        val climbStairsMemoization5 = climbStairsMemoization(testInput5)
        assertEquals(8, climbStairsMemoization5)
    }
}