package main.com.huhx0015.algorithmtester.datastructures;

/**
 * PRIORITY QUEUE (INTEGER ARRAY)
 * FIFO
 *
 * Queue Methods:
 *
 * enqueue() - Add item to the queue.
 * dequeue() - Remove item from the queue.
 * peek() - Look at item at the front of the queue.
 *
 * Created by Michael Yoon Huh on 5/9/2017.
 */
public class PriorityArrayQueue {

    private int[] queueArray;
    private int maxSize;
    private int itemCount;
    private int rearPosition;

    private static final int EMPTY_QUEUE = -1;

    public PriorityArrayQueue(int size) {
        this.maxSize = size;
        this.queueArray = new int[size];
        this.itemCount = 0;
        this.rearPosition = EMPTY_QUEUE;
    }

    // Runs in O(n) time for insertions.
    public void enqueue(int value) {

        // Check if array size has room or not.
        if (itemCount != maxSize) {

            // If queue is empty, we add the value into the queue.
            if (itemCount == 0) {
                rearPosition++;
                queueArray[rearPosition] = value;

                System.out.println("enqueue(): Adding " + value + " into the priority queue. | Count: " + itemCount);
                itemCount++;
            }

            // Need to compare against the last element to see if it is larger or smaller.
            else {

                int i = 0;
                for (i = itemCount - 1; i >= 0; i--) {

                    // If enqueued value is larger than previous value, value is placed ahead of previous value in the array.
                    if (value > queueArray[i]) {
                        queueArray[i + 1] = queueArray[i];
                        System.out.println("enqueue(): Value " + value + " is larger, it is put ahead. | Count: " + itemCount);
                    } else {
                        break;
                    }

                }

                queueArray[i + 1] = value;
                rearPosition++;
                itemCount++;
            }
        } else {
            System.out.println("enqueue(): ERROR: Queue is full. Count: " + itemCount);
        }
    }

    // Returns the minimum value. Runtime Complexity: O(1)
    public Integer dequeue() {

        if (itemCount > 0) {
            int dequeueValue = queueArray[rearPosition];
            rearPosition--;
            System.out.println("dequeue(): Removing " + dequeueValue + " from the queue. | ItemCount: " + itemCount);
            return dequeueValue;
        } else {
            System.out.println("dequeue(): Can't remove from front of queue. Queue is empty. | ItemCount: " + itemCount);
            return null;
        }
    }

    // Peeks at the minimum value.
    public Integer peek() {

        if (itemCount > 0) {
            int peekValue = queueArray[rearPosition];
            System.out.println("peek(): Peek value is " + peekValue + ". | ItemCount: " + itemCount);
            return peekValue;
        } else {
            System.out.println("peek(): Can't peek queue. Queue is empty. | ItemCount: " + itemCount);
            return null;
        }
    }

    public int[] getArray() {
        return queueArray;
    }

    public static void main(String[] args) {
        PriorityArrayQueue queue = new PriorityArrayQueue(10);

        queue.enqueue(5); // Should add 5. 5 at front. ItemCount: 1
        queue.enqueue(7); // Should add 7. 5 at front. ItemCount: 2
        queue.peek(); // Should return 5 at front.
        queue.dequeue(); // Should remove 5. 7 should be new front. ItemCount: 1
        queue.enqueue(20); // Should add 20. 7 at front. ItemCount: 2
        queue.enqueue(25); // Should add 25. 7 at front. ItemCount: 3
        queue.dequeue(); // Should remove 7. 20 at front. ItemCount: 2
        queue.enqueue(70); // Should add 70. 20 at front. ItemCount: 4
        queue.enqueue(75); // Should add 75. 20 at front. ItemCount: 5.
        queue.enqueue(100); // Should add 100. 20 at front.
        queue.dequeue(); // Should remove 20. 25 at front.
        queue.dequeue(); // Should remove 25. 70 at front.
        queue.dequeue(); // Should remove 70. 75 at front.
        queue.enqueue(40); // Should add 40. 75 at front.
        queue.peek(); // Should return 75 at front.
        queue.dequeue(); // Should remove 75. 100 at front.

        for(int x : queue.getArray()) {
            System.out.println(x);
        }
    }
}