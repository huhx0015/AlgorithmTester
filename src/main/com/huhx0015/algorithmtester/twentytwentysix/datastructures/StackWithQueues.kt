package com.huhx0015.algorithmtester.twentytwentysix.datastructures

/**
 * Problem: Implement Stack Using Queues
 * Difficulty: Easy
 *
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 *
 * Implement the MyStack class:
 *
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 * Example 1:
 *
 * Input: ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 *
 * Output: [null, null, null, 2, 2, false]
 * Explanation:
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // return 2
 * myStack.pop(); // return 2
 * myStack.empty(); // return False
 *
 * Constraints:
 *
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, top, and empty.
 * All the calls to pop and top are valid.
 * Follow-up: Can you implement the stack using only one queue?
 *
 */
object StackWithQueues {

    @JvmStatic fun main(args: Array<String>) {
        val stackWithTwoQueues = MyStack()

        stackWithTwoQueues.push(1)
        println("StackWithTwoQueues: Pushing 1 into stack.")
        stackWithTwoQueues.push(2)
        println("StackWithTwoQueues: Pushing 2 into stack.")

        val topValue1 = stackWithTwoQueues.top()
        println("StackWithTwoQueues: Top value is $topValue1.")

        val poppedValue1 = stackWithTwoQueues.pop()
        println("StackWithTwoQueues: Popped value is $poppedValue1.")

        val isEmpty1 = stackWithTwoQueues.empty()
        println("StackWithTwoQueues: Stack is empty? $isEmpty1")

        val stackWithOneQueues = MyStackOneQueue()

        stackWithOneQueues.push(1)
        println("StackWithOneQueues: Pushing 1 into stack.")
        stackWithOneQueues.push(2)
        println("StackWithOneQueues: Pushing 2 into stack.")

        val topValue2 = stackWithOneQueues.top()
        println("StackWithOneQueues: Top value is $topValue2.")

        val poppedValue2 = stackWithOneQueues.pop()
        println("StackWithOneQueues: Popped value is $poppedValue2.")

        val isEmpty2 = stackWithOneQueues.empty()
        println("StackWithOneQueues: Stack is empty? $isEmpty2")
    }

    /**
     * Stack with Two Queues:
     *
     * Time & Space Complexity
     * Time complexity:
     * O(1) time for initialization.
     * O(n) time for each push() function call.
     * O(1) time for each pop() function call.
     *
     * Space complexity:
     * O(n)
     */
    class MyStack {
        val queue1: ArrayDeque<Int> = ArrayDeque()
        val queue2: ArrayDeque<Int> = ArrayDeque()

        // push(): Pushes element x to the top of the stack.
        fun push(x: Int) {
            queue2.addLast(x) // Adds the last element to the end of queue2.

            // Loops through queue1 while not empty and removing the first element from queue1 and then adding it to the
            // back of queue2.
            while (queue1.isNotEmpty()) {
                val removeFirstFromQueue1 = queue1.removeFirst() // First value of the queue1.
                queue2.addLast(removeFirstFromQueue1)
            }
            queue1.addAll(queue2) // Adds all queue2 to queue1.
            queue2.clear()
        }

        // pop(): Removes the element on the top of the stack and returns it.
        fun pop(): Int {
            return queue1.removeFirst() // Removes the first element from the first queue.
        }

        // top(): Returns the element on the top of the stack. (i.e. "peek" operation)
        fun top(): Int {
            return queue1.first()
        }

        // empty(): Returns true if the stack is empty, false otherwise.
        fun empty(): Boolean {
            return queue1.isEmpty()
        }
    }

    /**
     * Stack with One Queues:
     *
     * Time & Space Complexity
     * Time complexity:
     * O(1) time for initialization.
     * O(1) time for each push() function call.
     * O(1) time for each pop() function call.
     *
     * Space complexity:
     * O(n)
     */
    class MyStackOneQueue() {

        val queue: ArrayDeque<Int> = ArrayDeque()

        // push(): Pushes element x to the top of the stack.
        fun push(x: Int) {
            queue.addLast(x) // Adds the last element to the end of queue.

            // Loop through the entire queue, removing the first value of the queue and then adding it to the back.
            for (i in 0 until queue.size - 1) {
                val removeFirstFromQueue1 = queue.removeFirst()  // First value of the queue1.
                queue.addLast(removeFirstFromQueue1)
            }
        }

        // pop(): Removes the element on the top of the stack and returns it.
        fun pop(): Int {
            return queue.removeFirst() // Removes the first element from the first queue.
        }

        // top(): Returns the element on the top of the stack. (i.e. "peek" operation)
        fun top(): Int {
            return queue.first()
        }

        // empty(): Returns true if the stack is empty, false otherwise.
        fun empty(): Boolean {
            return queue.isEmpty()
        }
    }
}