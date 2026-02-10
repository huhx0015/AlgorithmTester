package main.com.huhx0015.algorithmtester.datastructures

/**
 * Created by Michael Yoon Huh on 5/8/2017.

 * CIRCULAR QUEUE:
 * FIRST-IN, FIRST OUT

 * enqueue(): Adds to the queue.
 * dequeue(): Removes and returns the first queued value.
 * isFull(): Checks to see if the queue is full.

 * This can be implemented without having a itemCount, just need to add a cell to the arrayQueue to determine if the
 * array is full.
 */
class CircularIntegerQueue(private val maxSize: Int) {

    private val arrayQueue: IntArray
    private var itemCount: Int = 0
    private var frontPosition: Int = 0
    private var rearPosition: Int = 0

    init {
        this.arrayQueue = IntArray(maxSize)

        println("CircularIntegerQueue: Initializing queue with size: " + maxSize)

        this.frontPosition = 0
        this.itemCount = 0
        this.rearPosition = EMPTY_QUEUE
    }

    // enqueue: Add value at front of the line.
    fun enqueue(value: Int) {

        // Check if queue is full or not before adding value to the queue.
        if (!isFull) {

            // CIRCULAR ARRAY: If rearPosition is currently at the end of the array, the rearPosition is reset back to
            // -1 to handle wrap around.
            if (rearPosition == maxSize - 1) {
                rearPosition = EMPTY_QUEUE
            }

            rearPosition++ // Increment rear position value.
            arrayQueue[rearPosition] = value // Sets the value into the rear position.
            itemCount++

            println("enqueue(): Added $value at position $rearPosition. | ItemCount: $itemCount")
        }
    }

    // dequeue: Return value at front of the line.
    fun dequeue(): Int? {

        if (!isEmpty) {
            val dequeueValue = arrayQueue[frontPosition]

            itemCount--

            println("dequeue(): Removed $dequeueValue at position $frontPosition. | ItemCount: $itemCount")

            frontPosition++ // Update the front position value to indicate new front of the queue position.

            // CIRCULAR ARRAY: If front position is at the end of the array, the front position is moved to the
            // beginning of the array.
            if (frontPosition == maxSize) {
                frontPosition = 0
            }

            return dequeueValue
        } else {
            return null
        }
    }

    // peek: Get current value at front of the line.
    fun peek(): Int {

        val peekValue = arrayQueue[frontPosition]

        println("peek(): Current front value in the queue: " + peekValue)
        return peekValue
    }

    // isFull: Checks if queue is full.
    val isFull: Boolean
        get() {
            if (itemCount == maxSize) {
                println("isFull(): Queue is currently full. ItemCount: $itemCount | MaxSize: $maxSize")
                return true
            } else {
                return false
            }
        }

    // isEmpty: Checks if queue is empty.
    val isEmpty: Boolean
        get() {
            return itemCount <= 0
        }

    companion object {

        private val EMPTY_QUEUE = -1

        @JvmStatic fun main(args: Array<String>) {

            val queue = CircularIntegerQueue(5)

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