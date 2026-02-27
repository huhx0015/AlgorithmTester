package com.huhx0015.algorithmtester.twentytwentysix.datastructures

/**
 * NeetCode.io
 *
 * Problem: Design Singly Linked List
 * Difficulty: Easy
 *
 * Your LinkedList class should support the following operations:
 *
 * LinkedList() will initialize an empty linked list.
 * int get(int i) will return the value of the ith node (0-indexed). If the index is out of bounds, return -1.
 * void insertHead(int val) will insert a node with val at the head of the list.
 * void insertTail(int val) will insert a node with val at the tail of the list.
 * bool remove(int i) will remove the ith node (0-indexed). If the index is out of bounds, return false, otherwise return true.
 * int[] getValues() return an array of all the values in the linked list, ordered from head to tail.
 * Example 1:
 *
 * Input:
 * ["insertHead", 1, "insertTail", 2, "insertHead", 0, "remove", 1, "getValues"]
 *
 * Output:
 * [null, null, null, true, [0, 2]]
 * Example 2:
 *
 * Input:
 * ["insertHead", 1, "insertHead", 2, "get", 5]
 *
 * Output:
 * [null, null, -1]
 * Note:
 *
 * The index int i provided to get(int i) and remove(int i) is guaranteed to be greater than or equal to 0.
 */
class SinglyLinkedList {
    var head: ListNode = ListNode(-1)
    var tail: ListNode? = head

    // ListNode: Linked list node object with a Int? value and next as a reference to the linked node object.
    data class ListNode(
        var value: Int?,
        var next: ListNode? = null
    )

    // insertHead(): Insert new node at the head of the linked list.
    fun insertHead(value: Int) {
        val newNode = ListNode(value)
        newNode.next = head.next
        head.next = newNode

        if (tail == head) {
            tail = newNode
        }
    }

    // insertTail(): Insert new node at the tail of the linked list.
    fun insertTail(value: Int) {
        val newNode = ListNode(value)
        tail?.next = newNode
        tail = newNode
    }

    // get(): Return the value at index (0-indexed). Returns -1 if index is out of bounds.
    fun get(index: Int): Int {
        var currentNode: ListNode? = head.next
        var i = 0
        while (currentNode != null) {
            if (i == index) {
                return currentNode.value ?: -1
            }
            currentNode = currentNode.next
            i++
        }
        return -1
    }

    // getValues(): Return an array of all values in the linked list, ordered from head to tail.
    // Use List<Int> so output serializes as [0, 2] instead of IntArray's [I@hashcode.
    fun getValues(): List<Int> {
        val values = mutableListOf<Int>()
        var currentNode: ListNode? = head.next
        while (currentNode != null) {
            currentNode.value?.let { values.add(it) }
            currentNode = currentNode.next
        }
        return values
    }

    // remove(): Remove node at index position. Returns true if successful, false if index out of bounds.
    fun remove(index: Int): Boolean {
        var currentNode: ListNode? = head
        var i = 0

        // Loop through the linked list starting at the head until we reach the index position.
        while (i < index && currentNode != null) {
            currentNode = currentNode.next // Updates the currentNode to the next node in the linked list.
            i++
        }

        // Checks if the currentNode is not null and if we are at the end of the linked list.
        if (currentNode != null && currentNode.next != null) {
            // Remove the node ahead of currentNode.
            if (currentNode.next == tail) {
                tail = currentNode // Sets the currentNode to be the new tail (end) of the linked list.
            }
            currentNode.next = currentNode.next?.next
            return true
        }
        return false
    }

    fun print() {
        var currentNode = head.next
        while (currentNode != null) {
            print("${currentNode.value} -> ")
            currentNode = currentNode.next
        }
        println()
    }
}