package test.com.huhx0015.algorithmtester.datastructures;

import main.com.huhx0015.algorithmtester.datastructures.CircularIntegerQueue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Michael Yoon Huh on 6/9/2017.
 */
class CircularIntegerQueueTest {

    @Test
    void testQueue() {
        CircularIntegerQueue queue = new CircularIntegerQueue(5);

        queue.enqueue(5); // Should add 5. 5 at front. ItemCount: 1
        queue.enqueue(7); // Should add 7. 5 at front. ItemCount: 2
        assertEquals(5, queue.peek()); // Should return 5 at front.

        assertEquals(5, (int) queue.dequeue()); // Should remove 5. 7 should be new front. ItemCount: 1

        queue.enqueue(20); // Should add 20. 7 at front. ItemCount: 2
        queue.enqueue(25); // Should add 25. 7 at front. ItemCount: 3

        assertEquals(7, (int) queue.dequeue()); // Should remove 7. 20 at front. ItemCount: 2

        queue.enqueue(70); // Should add 70. 20 at front. ItemCount: 4
        queue.enqueue(75); // Should add 75. 20 at front. ItemCount: 5.
        queue.enqueue(100); // Should add 100. 20 at front.

        assertEquals(20, (int) queue.dequeue()); // Should remove 20. 25 at front.
        assertEquals(25, (int) queue.dequeue()); // Should remove 25. 70 at front.
        assertEquals(70, (int) queue.dequeue()); // Should remove 70. 75 at front.

        queue.enqueue(40); // Should add 40. 75 at front.

        assertEquals(75, queue.peek()); // Should return 75 at front.
        assertEquals(75, (int) queue.dequeue()); // Should remove 75. 100 at front.
    }
}