package main.com.huhx0015.algorithmtester.datastructures

import java.util.LinkedList

/**
 * Created by Michael Yoon Huh on 5/8/2017.

 * QUEUE:

 * Queue implementation using built-in LinkedList.

 * enqueue():
 * dequeue():
 * peek():
 */
class LinkedListQueue {

    private val linkedQueue: LinkedList<Int> = LinkedList<Int>()

    fun peek(): Int? {
        if (!linkedQueue.isEmpty()) {
            val peekValue = linkedQueue[FRONT_POSITION]
            println("peek(): Peek value is " + peekValue)

            return peekValue
        } else {
            println("peek(): No value to peek, queue was empty.")
            return null
        }
    }

    fun enqueue(value: Int) {
        linkedQueue.add(value)
        println("enqueue(): Value $value added to queue.")
    }

    fun dequeue(): Int? {
        if (!linkedQueue.isEmpty()) {
            val dequeueValue = linkedQueue[FRONT_POSITION]
            linkedQueue.removeAt(FRONT_POSITION)

            println("dequeue(): Value $dequeueValue removed from queue.")

            return dequeueValue
        } else {
            println("dequeue(): No value to dequeue, queue was empty.")
            return null
        }
    }

    companion object {
        private val FRONT_POSITION = 0

        @JvmStatic fun main(args: Array<String>) {
            val queue = LinkedListQueue()

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
