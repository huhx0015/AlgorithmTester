package com.huhx0015.algorithmtester.twentytwentysix.datastructures

/**
 * NeetCode.io
 *
 * Problem: Design Double-ended Queue
 * Problem: Easy
 * Design a Double-ended Queue class.
 *
 * Your Deque class should support the following operations:
 *
 * Deque() will initialize an empty queue.
 * bool isEmpty() will return whether the queue is empty or not.
 * void append(int value) will insert value at the end of the queue.
 * void appendleft(int val) will insert value at the beginning of the queue.
 * int pop() will remove and return the value at the end of the queue. If the queue is empty, return -1.
 * int popleft() will remove and return the value at the beginning of the queue. If the queue is empty, return -1.
 * Note: You should implement each operation in O(1)
 * O(1) time complexity.
 *
 * Example 1:
 *
 * Input:
 * ["isEmpty", "append", 10, "isEmpty", "appendLeft", 20, "popLeft", "pop", "pop", "append", 30, "pop", "isEmpty"]
 *
 * Output:
 * [true, null, false, null, 20, 10, -1, null, 30, true]
 *
 * Notes: FIFO: First-In-First-Out
 */
object DesignDeque {

    @JvmStatic fun main(args: Array<String>) {
        val myDeque = Deque()

        println("Deque: Is Deque empty: ${myDeque.isEmpty()}")

        myDeque.append(10)
        println("Deque: Appending at end with value 10")

        println("Deque: Is Deque empty: ${myDeque.isEmpty()}")

        myDeque.appendleft(20)
        println("Deque: Appending at the start with value 20")

        val popLeft1 = myDeque.popleft()
        println("Deque: Popping left: $popLeft1")

        val pop1 = myDeque.pop()
        println("Deque: Pop: $pop1")

        myDeque.append(30)
        println("Deque: Appending at end with value 30")

        val pop2 = myDeque.pop()
        println("Deque: Pop: $pop2")

        println("Deque: Is Deque empty: ${myDeque.isEmpty()}")
    }
}

class Deque {

    // Node: Represents the queue Node object consisting of an Int value, and two pointers previous and next which
    // are Node types.
    data class Node(
        val value: Int,
        var previous: Node? = null,
        var next: Node? = null
    )

    var dummyHead: Node = Node(0) // Dummy pointer to a dummy node before the front of the queue.
    var dummyTail: Node = Node(0) // Dummy pointer to a dummy node after the end of the queue.

    init {
        // Attaches the dummyHead and dummyTail to each other.
        dummyHead.next = dummyTail // dummyHead next pointer points to dummyTail.
        dummyTail.previous = dummyHead // dummyTail previous pointer points to dummyHead.
    }

    // isEmpty(): Checks if the queue is empty.
    fun isEmpty(): Boolean {
        // To determine if the queue is empty, we check if the dummyHead.next is pointing to the dummyTail. If not empty
        // the dummyHead.next should be pointing to a real Node.
        return dummyHead.next == dummyTail
    }

    // append(): O(1): Insert value at the end of the queue.
    fun append(value: Int) {
        val newNode = Node(value) // New Node to insert at the end of the queue.
        val endNode = dummyTail.previous // End of the queue is the Node that is previous to the dummyTail, which could also be the dummyHead.

        newNode.previous = endNode // Updates the new Node's previous pointer to point to the dummyTail's previous Node.
        newNode.next = dummyTail // Updates the new Node's next pointer to point to the dummyTail, as this is now the new end Node of the queue.
        endNode?.next = newNode // Update the previous ending Node's next pointer to point to the new Node. If this was the dummyHead, the dummyHead.next pointer is updated.
        dummyTail.previous = newNode // Update the dummyTail previous pointer to point to the new Node.
    }

    // appendLeft(): 0(1): Insert value at the beginning of the queue.
    fun appendleft(value: Int) {
        val newNode = Node(value) // New Node to insert at the beginning of the queue.
        val headNode = dummyHead.next // The dummyHead next pointer points to the true start of the queue, if a real Node exists. Otherwise, it's the dummyTail Node.

        dummyHead.next = newNode // Updates the dummyHead next pointer to point to the new Node inserted at the beginning of the queue.
        newNode.previous = dummyHead // Updates the new Node's previous pointer to point to the dummyHead, as this is now the beginning of the queue.
        newNode.next = headNode // Updates the new Node's next pointer to point to the previous headNode.
        headNode?.previous = newNode // Updates the previous headNode's previous pointer to point to the newNode.
    }

    // pop(): O(1): Removes and return the value at the end of the queue. If the queue is empty, return -1.
    fun pop(): Int {
        if (dummyHead.next == dummyTail) return -1 // The queue is empty if dummyHead's next pointer is pointing to the dummyTail.

        val endNode = dummyTail.previous // Node that is at the end of the queue, which the dummyTail's previous pointer points to. This is the Node we want to pop.
        val previousNodeBeforeEndNode = endNode?.previous // The Node that the endNode's previous pointer was pointing to.
        previousNodeBeforeEndNode?.next = dummyTail // Sets the previousNodeBeforeEndNode's next pointer to point to the dummyTail.
        dummyTail.previous = previousNodeBeforeEndNode // dummyTail's previous pointer points to the previousNodeBeforeEndNode.

        return endNode?.value ?: -1 // Returns the value of the node that we popped.
    }

    // popLeft(): O(1): Removes and return the value at the beginning of the queue. If the queue is empty, return -1.
    fun popleft(): Int {
        if (dummyHead.next == dummyTail) return -1 // The queue is empty if dummyHead's next pointer is pointing to the dummyTail.

        val headNode = dummyHead.next // The head Node to which the dummyHead's next pointer points to, this is the Node we want to pop.
        val nextNodeAfterHeadNode = headNode?.next // References the Node that the current head Node's next pointer points to.
        dummyHead.next = nextNodeAfterHeadNode // Updates the dummyHead's next pointer to point to the nextNodeAfterHeadNode.
        nextNodeAfterHeadNode?.previous = dummyHead // Updates the nextNodeAfterHeadNode's previous pointer to point to dummyHead, signifying that it is now the new Node at the beginning of the queue.

        return headNode?.value ?: -1 // Returns the value of the node that we popped.
    }
}