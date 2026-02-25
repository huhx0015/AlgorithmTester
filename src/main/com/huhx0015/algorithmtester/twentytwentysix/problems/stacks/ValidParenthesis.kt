package com.huhx0015.algorithmtester.twentytwentysix.problems.stacks

import java.util.Stack

/**
 * NeetCode.io
 *
 * Problem: Valid Parentheses
 * Difficulty: Easy
 *
 * You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.
 *
 * The input string s is valid if and only if:
 *
 * Every open bracket is closed by the same type of close bracket.
 * Open brackets are closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * Return true if s is a valid string, and false otherwise.
 *
 * Example 1:
 *
 * Input: s = "[]"
 *
 * Output: true
 * Example 2:
 *
 * Input: s = "([{}])"
 *
 * Output: true
 * Example 3:
 *
 * Input: s = "[(])"
 *
 * Output: false
 * Explanation: The brackets are not closed in the correct order.
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 */
object ValidParenthesis {

    @JvmStatic fun main(args: Array<String>) {
        val input1 = "[]"
        val valid1 = isValid(input1)
        println("Parenthesis input $input1 is valid: $valid1\n")

        val input2 = "([{}])"
        val valid2 = isValid(input2)
        println("Parenthesis input $input2 is valid: $valid2\n")

        val input3 = "[(])"
        val valid3 = isValid(input3)
        println("Parenthesis input $input3 is valid: $valid3\n")
    }

    fun isValid(s: String): Boolean {
        if (s.isEmpty()) return false // Return false if string is empty, there are no parenthesis hence not valid.
        if (s.length == 1) return false // Return false if length is 1, not possible for parenthesis to be valid and hence not valid.

        val stack: Stack<Char> = Stack()

        s.forEach { character ->
            when (character) {
                '(' -> stack.push(character)
                '[' -> stack.push(character)
                ')' -> if (stack.peek() == '(') {
                    println("Matching parenthesis '(' found for $character, popping off the stack!")
                    stack.pop()
                }
                ']' -> if (stack.peek() == '[') {
                    println("Matching parenthesis '[' found for $character, popping off the stack!")
                    stack.pop()
                }
            }
        }
        val isValid = stack.isEmpty()
        return isValid
    }
}