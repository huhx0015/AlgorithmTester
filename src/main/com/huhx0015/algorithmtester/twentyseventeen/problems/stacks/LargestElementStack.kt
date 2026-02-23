package com.huhx0015.algorithmtester.twentyseventeen.problems.stacks

import java.util.EmptyStackException
import java.util.Stack

/**
 * Interview Cake:

 * Use the built-in Stack class to implement a new class MaxStack with a function getMax() that returns the largest
 * element in the stack. getMax() should not remove the item.

 * Created by Michael Yoon Huh on 5/8/2017.

 * URL: https://www.interviewcake.com/question/java/largest-stack
 */
class LargestElementStack {

    private val dataStack: Stack<Int> = Stack<Int>()
    private val maxStack: Stack<Int> = Stack<Int>()

    fun peek(): Int {

        if (!dataStack.empty()) {
            return dataStack.peek()
        } else {
            throw EmptyStackException()
        }
    }

    // Runs in O(1) time, O(n) time for space.
    fun push(value: Int) {

        dataStack.push(value)
        println("push(): Pushed value: " + value)

        // If maxStack is not empty, we grab the previous max value.
        if (!maxStack.empty()) {
            val prevMax = maxStack.peek()

            if (value > prevMax) {
                maxStack.push(value)
                println("push(): Value was greater than previous max. New max value is: " + value)
            } else {
                maxStack.push(prevMax)
                println("push(): Previous max is greater than value. Max value is: " + prevMax)
            }
        } else {
            maxStack.push(value)
            println("push(): No previous max value was set: " + value)
        }
    }

    // Runs in O(1) time, O(n) time for space.
    fun pop(): Int {

        if (!dataStack.empty()) {
            maxStack.pop()
            return dataStack.pop()
        } else {
            throw EmptyStackException()
        }
    }

    // Runs in O(1) time, O(n) time for space.
    val max: Int
        get() {

            if (!maxStack.empty()) {
                val maxValue = maxStack.peek()

                println("getMax(): Current max value: " + maxValue)

                return maxValue
            } else {
                throw EmptyStackException()
            }
        }

    companion object {

        @JvmStatic fun main(args: Array<String>) {

            val stack = LargestElementStack()

            stack.push(5)
            stack.max
            stack.push(25)
            stack.max
            stack.pop()
            stack.max
            stack.push(38)
            stack.max
            stack.pop()
            stack.max
        }
    }
}
