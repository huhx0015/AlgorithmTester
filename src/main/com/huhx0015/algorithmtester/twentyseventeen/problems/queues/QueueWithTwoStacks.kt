package com.huhx0015.algorithmtester.twentyseventeen.problems.queues

import java.util.Stack

/**
 * Created by Michael Yoon Huh on 5/8/2017.

 * Interview Cake:

 * Implement a queue ↴ with 2 stacks ↴ . Your queue should have an enqueue and a dequeue function and it should be
 * "first in first out" (FIFO).

 * Optimize for the time cost of m function calls on your queue. These can be any mix of enqueue and dequeue calls.
 * Assume you already have a stack implementation and it gives O(1) time push and pop.

 * Reference: https://www.interviewcake.com/question/java/queue-two-stacks
 * Hint: http://stackoverflow.com/questions/69192/how-to-implement-a-queue-using-two-stacks

 * STACK: Last In, First Out
 * QUEUE: First In, First Out

 * NOTE: Amortized Time = Expected, typical runtime.
 */
class QueueWithTwoStacks {

    private val inStack: Stack<Int> = Stack<Int>()
    private val outStack: Stack<Int> = Stack<Int>()

    // O(1) time.
    fun enqueue(value: Int) {
        inStack.add(value)
        println("enqueue(): Value $value was added to the queue.")
    }

    // If the outstack is empty, the runtime is O(1), but worst time is O(i).
    fun dequeue(): Int? {

        // Check if the outStack is empty.
        if (outStack.isEmpty()) {

            // Move items from inStack to outStack.
            // This operation takes O(i) time, depending on how many i elements there are in the inStack.
            populateOutstack()

            if (outStack.isEmpty()) {
                println("dequeue(): ERROR: Can't remove item, both stacks were empty.")
                return null
            }
        }

        val dequeueValue = outStack.pop()
        println("dequeue(): Value $dequeueValue was removed from the queue.")
        return dequeueValue
    }

    // Helper method to move items from the instack to the outstack.
    private fun populateOutstack() {
        while (!inStack.isEmpty()) {
            val enqueuePopValue = inStack.pop() // Remove the top item from the stack.
            println("populateOutstack(): Moving $enqueuePopValue to outStack.")
            outStack.push(enqueuePopValue) // Pushes item into the dequeue stack.
        }
    }

    fun peek(): Int? {

        if (outStack.isEmpty()) {

            // Move items from inStack to outStack.
            // This operation takes O(i) time, depending on how many i elements there are in the inStack.
            populateOutstack()
        }

        if (!outStack.empty()) {
            val peekValue = outStack.peek()
            println("peek(): Peek value is: " + peekValue)
            return peekValue
        } else {
            println("peek(): No peek value, queue was empty.")
            return null
        }
    }

    companion object {

        @JvmStatic fun main(args: Array<String>) {
            val queue = QueueWithTwoStacks()

            queue.enqueue(5) // Should add 5. 5 at front. ItemCount: 1
            queue.enqueue(7) // Should add 7. 5 at front. ItemCount: 2
            queue.peek() // Should return 5 at front.
            queue.dequeue() // Should remove 5. 7 should be new front. ItemCount: 1
            queue.enqueue(20) // Should add 20. 7 at front. ItemCount: 2
            queue.enqueue(25) // Should add 25. 7 at front. ItemCount: 3
            queue.dequeue() // Should remove 7. 20 at front. ItemCount: 2
            queue.enqueue(70) // Should add 70. 20 at front. ItemCount: 4
            queue.enqueue(75) // Should add 75. 20 at front. ItemCount: 5.
            queue.enqueue(100) // Should add 100. 20 at front.
            queue.dequeue() // Should remove 20. 25 at front.
            queue.dequeue() // Should remove 25. 70 at front.
            queue.dequeue() // Should remove 70. 75 at front.
            queue.enqueue(40) // Should add 40. 75 at front.
            queue.peek() // Should return 75 at front.
            queue.dequeue() // Should remove 75. 100 at front.
        }
    }
}
