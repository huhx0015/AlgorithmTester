package com.huhx0015.algorithmtester.twentyseventeen.problems.stacks

import java.util.EmptyStackException

/**
 * Implement a Stack for integer inputs
 * Stack should be able to return Maximum value contained in it
 * Ideally getMax is constant time
 *
 * Should have Push, Pop, Max.
 *
 * Note 1: This function does it in O(1) runtime. Space time for each method is O(n), based on how many elements are in
 * the stack.
 * Note 2: Does not handle dynamic array re-creation.
 *
 * Similar to Interview Cake problem:
 * URL: https://www.interviewcake.com/question/java/largest-stack
 *
 * Created by Michael Yoon Huh on 5/8/2017.
 *
 */
class LargestIntegerStack(private val maxSize: Int) {

    private val dataArray: IntArray = IntArray(maxSize) // Stores the values.
    private val maxArray: IntArray = IntArray(maxSize) // Stores the values in sorted order, from min to max.
    private var topPosition: Int = 0

    init {

        // Initializes the array of elements.
        // Initializes the array of elements from min to max.
        topPosition = EMPTY_STACK // Represents an empty array.

        println("LargestIntegerStack(): Created new stack with size $maxSize, starting at position: $topPosition")
    }

    fun peek(): Int {

        // Check if the stack is empty or not.
        if (topPosition != EMPTY_STACK) {
            val peekValue = dataArray[topPosition]

            println("peek(): Peek value: $peekValue at position: $topPosition | Size: $maxSize")

            return peekValue
        } else {
            throw EmptyStackException()
        }
    }

    fun push(value: Int) {

        // Check to make sure that the array has not been filled up yet.
        if (topPosition + 1 < maxSize) {
            topPosition++
            dataArray[topPosition] = value

            println("push(): Pushed $value at position: $topPosition | Size: $maxSize")

            // MAX VALUE:
            // ----------
            // Gets the previous max value. If there is no previous max value, prevMax is set to Integer.MIN_VALUE.
            val prevMax = if (topPosition > 0) maxArray[topPosition - 1] else Integer.MIN_VALUE

            // If value is greater than previous max, we found our new max.
            if (value > prevMax) {
                maxArray[topPosition] = value
                println("push(): New value was greater, setting new maximum value: " + value)
            } else {
                maxArray[topPosition] = prevMax
                println("push(): Older max value was greater: " + prevMax)
            }
        } else {
            println("push(): Cannot push any more values to this stack, stack is full: $topPosition | Size: $maxSize")
        }
    }

    fun pop(): Int {

        // Check if stack is empty or not.
        if (topPosition != EMPTY_STACK) {
            val popValue = dataArray[topPosition]

            println("pop(): Popped $popValue at position: $topPosition | Size: $maxSize")

            topPosition--
            return popValue
        } else {
            throw EmptyStackException()
        }
    }

    // Check if stack is empty or not.
    val max: Int
        get() {
            if (topPosition != EMPTY_STACK) {
                val maxValue = maxArray[topPosition]

                println("getMax(): Current max value is: " + maxValue)

                return maxValue
            } else {
                throw EmptyStackException()
            }
        }

    companion object {

        private val EMPTY_STACK = -1

        @JvmStatic fun main(args: Array<String>) {

            val stack = LargestIntegerStack(5)

            stack.push(1)
            stack.max
            stack.push(2)
            stack.max
            stack.peek()
            stack.pop()
            stack.max
            stack.push(3)
            stack.max
            stack.peek()
            stack.push(4)
            stack.max
            stack.push(5)
            stack.max
            stack.push(6)
            stack.max
            stack.push(7)
            stack.max
            stack.pop()
            stack.pop()
        }
    }
}
