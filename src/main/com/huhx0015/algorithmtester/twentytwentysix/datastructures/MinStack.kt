package com.huhx0015.algorithmtester.twentytwentysix.datastructures

/**
 * NeetCode.io
 *
 * Problem: Min Stack
 * Difficulty: Medium
 *
 * Design a stack class that supports the push, pop, top, and getMin operations.
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * Each function should run in O(1) time.
 *
 * Example 1:
 *
 * Input: ["MinStack", "push", 1, "push", 2, "push", 0, "getMin", "pop", "top", "getMin"]
 *
 * Output: [null,null,null,null,0,null,2,1]
 *
 * Explanation:
 * MinStack minStack = new MinStack();
 * minStack.push(1);
 * minStack.push(2);
 * minStack.push(0);
 * minStack.getMin(); // return 0
 * minStack.pop();
 * minStack.top();    // return 2
 * minStack.getMin(); // return 1
 * Constraints:
 *
 * -2^31 <= val <= 2^31 - 1.
 * pop, top and getMin will always be called on non-empty stacks.
 */
class MinStack() {

    private val stack: MutableList<Pair<Int, Int>> = mutableListOf() // Int List of Pair<Int, Int> to store the current value as first, and current minimum value as second.

    // push(): Adds the value into the stack.
    fun push(value: Int) {
        if (stack.isNotEmpty()) {
            val currentPair = stack[stack.size - 1]
            var currentMinimum = currentPair.second

            // If the pushed value is less than the currentMinimum, the new value is the new minimum value.
            if (value < currentMinimum) {
               currentMinimum = value
            }
            stack.add(Pair(value, currentMinimum))
        } else {
            // If the stack is empty, the new value is added, with the new value also set as the minimum value.
            stack.add(Pair(value, value))
        }
    }

    // pop(): Pops (removes) the value at the last position of the stack.
    fun pop() {
        if (stack.isEmpty()) return // Do nothing if the stack is empty.
        stack.removeAt(stack.size - 1)
    }

    // top(): Returns the value at the last position of the stack. (aka peek)
    fun top(): Int {
        return stack[stack.size - 1].first
    }

    // getMin(): Returns the minimum value found in the stack.
    fun getMin(): Int {
        return stack[stack.size - 1].second
    }
}