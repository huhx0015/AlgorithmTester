package test.com.huhx0015.algorithmtester.datastructures

import main.com.huhx0015.algorithmtester.datastructures.NodeQueue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Created by Michael Yoon Huh on 6/12/2017.
 */
internal class NodeQueueTest {

    @Test
    fun testNodeQueue() {
        val queue = NodeQueue()

        queue.enqueue(5) // Should add 5. 5 at front. ItemCount: 1
        queue.enqueue(7) // Should add 7. 5 at front. ItemCount: 2

        assertEquals(5, queue.peek()) // Should return 5 at front.

        assertEquals(5, queue.dequeue()) // Should remove 5. 7 should be new front. ItemCount: 1

        queue.enqueue(20) // Should add 20. 7 at front. ItemCount: 2
        queue.enqueue(25) // Should add 25. 7 at front. ItemCount: 3

        assertEquals(7, queue.dequeue()) // Should remove 7. 20 at front. ItemCount: 2

        queue.enqueue(70) // Should add 70. 20 at front. ItemCount: 4
        queue.enqueue(75) // Should add 75. 20 at front. ItemCount: 5.
        queue.enqueue(100) // Should add 100. 20 at front.

        assertEquals(20, queue.dequeue()) // Should remove 20. 25 at front.
        assertEquals(25, queue.dequeue()) // Should remove 25. 70 at front.
        assertEquals(70, queue.dequeue()) // Should remove 70. 75 at front.

        queue.enqueue(40) // Should add 40. 75 at front.

        assertEquals(75, queue.peek()) // Should return 75 at front.
        assertEquals(75, queue.dequeue()) // Should remove 75. 100 at front.
    }
}