package com.huhx0015.datastructures;

/**
 * Created by Michael Yoon Huh on 5/8/2017.
 *
 * Reference: http://stackoverflow.com/questions/11523932/queue-using-linked-list
 */
public class NodeQueue {

    private SingleNode frontNode;
    private SingleNode rearNode;

    private int nodeCount;

    public NodeQueue() {
        this.nodeCount = 0; // Sets the node count to 0.
    }

    public Integer peek() {
        if (nodeCount != 0) {
            int frontValue = frontNode.value;
            System.out.println("peek(): Value at the front of queue: " + frontValue);

            return frontValue;
        } else {
            System.out.println("peek(): No value could be peeked, queue was empty.");
            return null;
        }
    }

    public void enqueue(int value) {
        SingleNode node = new SingleNode(value);
        nodeCount++;

        // If the queue is empty, we set the Node we are adding as the front node and rear node.
        if (frontNode == null) {
            frontNode = node;
            rearNode = node;

            System.out.println("enqueue(): Queue was empty, adding " + value + " as the front node value.");
            return;
        }

        // If the queue only has one item, we set the reference for the next node.
        if (frontNode.next == null) {
            frontNode.next = node;
            rearNode = node;

            System.out.println("enqueue(): Queue only had one item, updating front node reference. Value: " + value);
        }

        // The current rearNode.next reference is updated and we set the new rear node.
        else {
            rearNode.next = node;
            rearNode = node;

            System.out.println("enqueue(): Added new node to the queue: Value: " + value);
        }
    }

    public Integer dequeue() {

        // If NodeQueue is not empty, we return the value in the front node and remove it from the queue.
        if (nodeCount > 0) {
            int dequeueValue = frontNode.value;

            frontNode = frontNode.next;

            nodeCount--;
            return dequeueValue;
        } else {
            System.out.println("dequeue(): No value could be removed, queue was empty.");
            return null;
        }
    }


    public class SingleNode {
        public int value;
        public SingleNode next;

        public SingleNode(int value) {
            this.value = value;
        }
    }

    public class DoubleNode {
        public int value;
        public DoubleNode head;
        public DoubleNode tail;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        NodeQueue queue = new NodeQueue();

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
