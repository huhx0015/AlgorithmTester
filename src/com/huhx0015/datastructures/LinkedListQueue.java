package com.huhx0015.datastructures;

import java.util.LinkedList;

/**
 * Created by Michael Yoon Huh on 5/8/2017.
 *
 * QUEUE:
 *
 * Queue implementation using built-in LinkedList.
 *
 * enqueue():
 * dequeue():
 * peek():
 */
public class LinkedListQueue {

    private LinkedList<Integer> linkedQueue;
    private static final int FRONT_POSITION = 0;

    public LinkedListQueue() {
        this.linkedQueue = new LinkedList<>();
    }

    public Integer peek() {
        if (!linkedQueue.isEmpty()) {
            int peekValue = linkedQueue.get(FRONT_POSITION);
            System.out.println("peek(): Peek value is " + peekValue);

            return peekValue;
        } else {
            System.out.println("peek(): No value to peek, queue was empty.");
            return null;
        }
    }

    public void enqueue(int value) {
        linkedQueue.add(value);
        System.out.println("enqueue(): Value " + value + " added to queue.");
    }

    public Integer dequeue() {
        if (!linkedQueue.isEmpty()) {
            int dequeueValue = linkedQueue.get(FRONT_POSITION);
            linkedQueue.remove(FRONT_POSITION);
            System.out.println("dequeue(): Value " + dequeueValue + " removed from queue.");
            return dequeueValue;
        } else {
            System.out.println("dequeue(): No value to dequeue, queue was empty.");
            return null;
        }
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

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
    }
}
