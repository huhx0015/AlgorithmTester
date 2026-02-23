package com.huhx0015.algorithmtester.twentyseventeen.datastructures

/**
 * PRIORITY QUEUE (INTEGER ARRAY)
 * FIFO

 * Queue Methods:

 * enqueue() - Add item to the queue.
 * dequeue() - Remove item from the queue.
 * peek() - Look at item at the front of the queue.

 * Created by Michael Yoon Huh on 5/9/2017.
 */
class PriorityArrayQueue(private val maxSize: Int) {

    val array: IntArray = IntArray(maxSize)
    private var itemCount: Int = 0
    private var rearPosition: Int = 0

    init {
        this.itemCount = 0
        this.rearPosition = EMPTY_QUEUE
    }

    // Runs in O(n) time for insertions.
    fun enqueue(value: Int) {

        // Check if array size has room or not.
        if (itemCount != maxSize) {

            // If queue is empty, we add the value into the queue.
            if (itemCount == 0) {
                rearPosition++
                array[rearPosition] = value

                println("enqueue(): Adding $value into the priority queue. | Count: $itemCount")
                itemCount++
            }

            // Need to compare against the last element to see if it is larger or smaller.
            else {

                var i = 0
                i = itemCount - 1

                while (i >= 0) {

                    // If enqueued value is larger than previous value, value is placed ahead of previous value in the array.
                    if (value > array[i]) {
                        array[i + 1] = array[i]

                        println("enqueue(): Value $value is larger, it is put ahead. | Count: $itemCount")
                    } else {
                        break
                    }

                    i--
                }

                array[i + 1] = value
                rearPosition++
                itemCount++
            }
        } else {
            println("enqueue(): ERROR: Queue is full. Count: " + itemCount)
        }
    }

    // Returns the minimum value. Runtime Complexity: O(1)
    fun dequeue(): Int? {

        if (itemCount > 0) {
            val dequeueValue = array[rearPosition]
            rearPosition--
            println("dequeue(): Removing $dequeueValue from the queue. | ItemCount: $itemCount")
            return dequeueValue
        } else {
            println("dequeue(): Can't remove from front of queue. Queue is empty. | ItemCount: " + itemCount)
            return null
        }
    }

    // Peeks at the minimum value.
    fun peek(): Int? {

        if (itemCount > 0) {
            val peekValue = array[rearPosition]
            println("peek(): Peek value is $peekValue. | ItemCount: $itemCount")
            return peekValue
        } else {
            println("peek(): Can't peek queue. Queue is empty. | ItemCount: " + itemCount)
            return null
        }
    }

    companion object {

        private val EMPTY_QUEUE = -1

        @JvmStatic fun main(args: Array<String>) {
            val queue = PriorityArrayQueue(10)

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
        }
    }
}