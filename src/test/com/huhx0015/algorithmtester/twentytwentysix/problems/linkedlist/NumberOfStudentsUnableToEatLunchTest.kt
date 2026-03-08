package com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist

import com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist.NumberOfStudentsUnableToEatLunch.Solution
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfStudentsUnableToEatLunchTest {

    val testSolution: Solution = Solution()

    @Test
    fun testCountStudentsQueueStack() {
        val students = intArrayOf(1,1,1,0,0,1)
        val sandwiches = intArrayOf(1,0,0,0,1,1)
        val result1 = testSolution.countStudents(students, sandwiches)
        assertEquals(3, result1)
    }

    @Test
    fun testCountStudentsEfficient() {
        val solution = Solution()
        val students = intArrayOf(1,1,1,0,0,1)
        val sandwiches = intArrayOf(1,0,0,0,1,1)
        val result1 = solution.countStudentsEfficient(students, sandwiches)
        assertEquals(3, result1)
    }
}