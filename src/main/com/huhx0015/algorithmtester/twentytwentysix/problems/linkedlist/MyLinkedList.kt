package com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist

import com.huhx0015.algorithmtester.twentytwentysix.datastructures.SinglyLinkedList.ListNode
import com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist.MergeTwoSortedLinkedList.mergeTwoLists

/**
 * Leetcode
 *
 * Problem: 707. Design Linked List
 *
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and
 * next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more
 * attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 *
 * Implement the MyLinkedList class:
 *
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the
 * new node will be the first node of the linked list.
 *
 * void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list.
 * If index equals the length of the linked list, the node will be appended to the end of the linked list.
 * If index is greater than the length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 *
 * Example 1:
 *
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 *
 * Explanation
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 *
 *
 * Constraints:
 *
 * 0 <= index, val <= 1000
 * Please do not use the built-in LinkedList library.
 * At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.
 */
object DesignLinkedList {

    @JvmStatic fun main(args: Array<String>) {
        val myLinkedList = MyLinkedList()
        myLinkedList.addAtHead(1)
        println("MyLinkedList: Adding at head with value 1")

        myLinkedList.addAtTail(3)
        println("MyLinkedList: Adding at tail with value 3")

        myLinkedList.addAtIndex(1, 2) // linked list becomes 1->2->3
        println("MyLinkedList: Adding at index with value 2")

        println("MyLinkedList: Getting value at position 1 (should be 2): ${myLinkedList.get(1)}") // return 2
        myLinkedList.deleteAtIndex(1) // now the linked list is 1->3
        println("MyLinkedList: Getting value at position 1 (should be 3): ${myLinkedList.get(1)}") // return 3
    }
}

class MyLinkedList {

    var head: Node? = null // Represents the front of the LinkedList.
    var tail: Node? = null // Represents the end of the LinkedList

    // Node: Represents the LinkedList Node object consisting of an Int value, and two pointers previous and next which
    // are Node types.
    data class Node(
        val value: Int,
        var previous: Node? = null,
        var next: Node? = null
    )

    // get(): Time O(n), Space O(1). Get the value of the indexth node in the linked list. If the index is invalid, return -1.
    fun get(index: Int): Int {
        var currentNode = head
        var nodeCount = 0
        var nodeValue = -1

        // While loop until currentNode is null.
        while (currentNode != null) {
            // If the nodeCount matches the index value, we are at the indexth node and assign nodeValue to the value
            // of the currentNode.
            if (nodeCount == index) {
                nodeValue = currentNode.value
                return nodeValue
            }
            currentNode = currentNode.next // Updates the pointer to the next Node in the LinkedList.
            nodeCount++
        }
        return nodeValue
    }

    // addAtHead(): Time O(1), Space O(1). Add a node of value val before the first element of the linked list. After the insertion, the
    // new node will be the first node of the linked list.
    fun addAtHead(value: Int) {
        val newNode = Node(value) // The new head node to insert into the LinkedList.
        val oldHeadNode = head // Reference copy of current head node.

        // If there are no existing nodes in the LinkedList, we assign the head and tail to be the newNode.
        if (oldHeadNode == null) {
            head = newNode
            tail = newNode
        } else {
            // Otherwise, we insert the newNode as the headNode and update the previous headNode's previous pointer to
            // point to the new headNode.
            oldHeadNode.previous = newNode
            head = newNode
            head?.next = oldHeadNode
        }
    }

    // addAtTail(): Time O(1), Space O(1). Append a node of value val as the last element of the linked list.
    fun addAtTail(value: Int) {
        val newNode = Node(value) // The new tail node to insert into the LinkedList.
        val oldTailNode = tail // Reference copy of the current tail node.

        // If there are no existing nodes in the LinkedList, we assign the head to be the newNode.
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            // Otherwise, we insert the newNode as the tailNode and update the previous tailNode's next pointer to
            // point to the new tailNode
            oldTailNode?.next = newNode
            tail = newNode
            tail?.previous = oldTailNode
        }
    }

    // addAtIndex(): Time O(n), Space O(1). Add a node of value val before the indexth node in the linked list. If index equals the length of
    // the linked list, the node will be appended to the end of the linked list. If index is greater than the length,
    // the node will not be inserted.
    fun addAtIndex(index: Int, value: Int) {
        val newNode = Node(value) // The new node to insert at indexth node in the linked list.
        var nodeCount = 0 // Counter variable to keep count of the loop iterations in the while loop.
        var currentNode = head // Reference copy to the current head.

        // While loop until currentNode is null.
        while (currentNode != null) {
            if (nodeCount == index) {
                val previousNode = currentNode.previous // Reference copy of the currentNode's previous Node pointer.
                newNode.previous = previousNode // Sets the new node's previous Node pointer to be the currentNode's previous Node pointer.
                newNode.next = currentNode // New node's next points to the node we're inserting before.
                previousNode?.next = newNode // Link previous node to new node (or update head if inserting at index 0).
                currentNode.previous = newNode // Update the currentNode's previous pointer to point to the newNode.
                if (previousNode == null) head = newNode // Inserting at head.
                return
            }
            currentNode = currentNode.next // Updates the currentNode pointer to the next Node for the next loop iteration.
            nodeCount++
        }

        // EDGE CASE: If index equals length, append to end. If index > length, do nothing.
        if (nodeCount == index) addAtTail(value)
    }

    // deleteAtIndex(): Time O(n), Space O(1). Delete the indexth node in the linked list, if the index is valid.
    fun deleteAtIndex(index: Int) {
        var nodeCount = 0 // Counter variable to keep count of the loop iterations in the while loop.
        var currentNode = head // Reference copy to the current head.

        // While loop until currentNode is null.
        while (currentNode != null) {
            if (nodeCount == index) {
                val previousNode = currentNode.previous // Reference copy of the previous node.
                val nextNode = currentNode.next // Reference copy of the next node.
                previousNode?.next = nextNode // Update previous node's next pointer to be the nextNode.
                nextNode?.previous = previousNode // Update next node's previous pointer for doubly linked list.

                if (previousNode == null) head = nextNode // Deleting head.
                if (nextNode == null) tail = previousNode // Deleting tail.
                return // Exit after deletion.
            }
            currentNode = currentNode?.next  // Updates the currentNode pointer to the next Node for the next loop iteration.
            nodeCount++
        }
    }
}