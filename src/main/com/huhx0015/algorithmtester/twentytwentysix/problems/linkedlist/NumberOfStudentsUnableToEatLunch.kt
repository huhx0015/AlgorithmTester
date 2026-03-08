package com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist

import java.util.LinkedList
import java.util.Queue
import java.util.Stack

/**
 * LeetCode
 *
 * Problem: 1700. Number of Students Unable to Eat Lunch
 * Difficulty: Easy
 * The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.
 *
 * The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each step:
 *
 * If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
 * Otherwise, they will leave it and go to the queue's end.
 * This continues until none of the queue students want to take the top sandwich and are thus unable to eat.
 *
 * You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the i​​​​​​th sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the j​​​​​​th student in the initial queue (j = 0 is the front of the queue). Return the number of students that are unable to eat.
 *
 * Example 1:
 *
 * Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
 * Output: 0
 * Explanation:
 * - Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
 * - Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
 * - Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
 * - Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
 * - Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
 * Hence all students are able to eat.
 * Example 2:
 *
 * Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= students.length, sandwiches.length <= 100
 * students.length == sandwiches.length
 * sandwiches[i] is 0 or 1.
 * students[i] is 0 or 1.
 *

 */

object NumberOfStudentsUnableToEatLunch {

    @JvmStatic fun main(args: Array<String>) {
        val solution = Solution()

        println("Standard solution with queues and stacks for number of students unable to eat lunch:\n")

        val students = intArrayOf(1,1,1,0,0,1)
        val sandwiches = intArrayOf(1,0,0,0,1,1)
        val result1 = solution.countStudents(students, sandwiches)

        println("Students: ${students.contentToString()}")
        println("Sandwiches: ${sandwiches.contentToString()}")
        println("Students unable to eat: $result1")

        println("Efficient solution for number of students unable to eat lunch:\n")
        val result2 = solution.countStudentsEfficient(students, sandwiches)

        println("Students: ${students.contentToString()}")
        println("Sandwiches: ${sandwiches.contentToString()}")
        println("Students unable to eat: $result2")
        println("-------------")
    }

    class Solution {

        /**
         * SOLUTION EXPLANATION:
         *
         * Simulates the student queue and processing the sandwich stack.
         *
         * Complexity
         * Time: O(n²)
         */
        fun countStudents(students: IntArray, sandwiches: IntArray): Int {
            // Early return conditions:
            // If there are no sandwiches, all students go hungry.
            // If there are no students in the queue, therefore no students go hungry.
            // If there are more students than sandwiches or sandwiches than students, then we return early.
            // If there are more than 100 sandwiches, no students go hungry, as part of the constraint.
            if (sandwiches.size != students.size) return 0
            if (sandwiches.isEmpty()) return students.size
            if (students.isEmpty()) return 0
            if (sandwiches.size > 100) return 0

            // Creates the queue for students and stack for sandwiches.
            val studentQueue: Queue<Int> = LinkedList()
            val sandwichStack: Stack<Int> = Stack()

            val studentCount = students.size // Count of students.

            // Fills the queue of students in FIFO order.
            for (student in students) {
                studentQueue.add(student)
            }

            // Fills the stack (reverse order) in LIFO order.
            for (i in 0 until studentCount) {
                val reversePosition = studentCount - i - 1
                sandwichStack.push(sandwiches[reversePosition])
            }

            var lastServed = 0

            // Loop through the student queue and process each student and sandwich.
            while (studentQueue.isNotEmpty() && lastServed < studentQueue.size) {
                val currentStudent = studentQueue.peek()
                val currentSandwich = sandwichStack.peek()

                // If the currentStudent and currentSandwich match, the student takes the sandwich.
                if (currentStudent == currentSandwich) {
                    studentQueue.remove() // Student leaves the queue.
                    sandwichStack.pop() // Sandwich is taken.
                    lastServed = 0
                    println("Student $currentStudent found their preferred sandwich $currentSandwich, student leaving the queue with sandwich.")
                } else {
                    studentQueue.remove() // Removes the student from the queue.
                    studentQueue.add(currentStudent) // Student is added to the back of the queue.
                    println("Student $currentStudent did not find their preferred sandwich, sandwich is $currentSandwich, student going to the back of the queue.")
                    lastServed++
                }
            }

            // Returns the remaining number of students in the queue.
            return studentQueue.size
        }

        /**
         * SOLUTION EXPLANATION:
         *
         * Instead of simulating students moving to the back of the queue, I count how many students prefer each sandwich type.
         * Then I process the sandwiches from top to bottom. If the current sandwich type is no longer wanted by any student,
         * the process stops immediately and the remaining student count is the answer.
         *
         * Complexity
         * Time: O(n)
         * Space: O(1)
         */
        fun countStudentsEfficient(students: IntArray, sandwiches: IntArray): Int {
            // Early return conditions:
            // If there are no sandwiches, all students go hungry.
            // If there are no students in the queue, therefore no students go hungry.
            // If there are more students than sandwiches or sandwiches than students, then we return early.
            // If there are more than 100 sandwiches, no students go hungry, as part of the constraint.
            if (sandwiches.size != students.size) return 0
            if (sandwiches.isEmpty()) return students.size
            if (students.isEmpty()) return 0
            if (sandwiches.size > 100) return 0

            // Keeps a count of students that prefer 0's and 1's.
            // studentSandwichPreferenceCount[0] = 0 -> Count of students that want 0's
            // studentSandwichPreferenceCount[1] = 1 -> Count of students that want 1's
            val studentSandwichPreferenceCount: IntArray = IntArray(2)

            // Loop through students, counting the 0's and 1's student preferences.
            for (student in students) {
                studentSandwichPreferenceCount[student]++ // Increments the respective
            }

            // Loop through sandwiches and decrement from the studentSandwichPreferenceCount.
            // Go through the sandwiches from top to bottom.
            // For each sandwich:
            // If no students want that type anymore, return how many students are left
            // otherwise decrement that count
            for (sandwich in sandwiches) {
                println("Current sandwich value: $sandwich")
                // If no student wants this type of sandwich, the process stops.
                if (studentSandwichPreferenceCount[sandwich] == 0) {
                    val remainingStudentCount = studentSandwichPreferenceCount[0] + studentSandwichPreferenceCount[1]
                    println("No preferred sandwiches available for the remaining students: $remainingStudentCount")
                    return remainingStudentCount
                }
                studentSandwichPreferenceCount[sandwich]-- // Student took the sandwich, decrements the preference count based on 'sandwich'.
            }

            println("All sandwiches were given out!")
            return 0
        }
    }
}