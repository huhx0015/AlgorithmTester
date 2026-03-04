package com.huhx0015.algorithmtester.twentytwentysix.datastructures

class DoublyLinkedList {

    // DoublyLinkedListNode: Linked list node object with a Int? value, in addition to a previous and next node as a
    // reference to the previous node and the next node.
    data class DoublyLinkedListNode(
        var value: Int?,
        var next: DoublyLinkedListNode? = null,
        var prev: DoublyLinkedListNode? = null
    )

    var head: DoublyLinkedListNode = DoublyLinkedListNode(-1)
    var tail: DoublyLinkedListNode = DoublyLinkedListNode(-1)

    // Initializes the DoublyLinkedList with an initial DoublyLinkedListNode with a negative value.
    init {
        head.next = tail
        tail.prev = head
    }

    // insertFront(): Inserts a new node at the front of the linked list.
    fun insertFront(value: Int) {
        // Initializes the new head node.
        val newNode = DoublyLinkedListNode(value)
        newNode.prev = head
        newNode.next = head.next

        head.next!!.prev = newNode
        head.next = newNode
    }

    // insertEnd(): Inserts a new node at the end of the linked list.
    fun insertEnd(value: Int) {
        val newNode = DoublyLinkedListNode(value)
        newNode.next = tail
        newNode.prev = tail.prev

        tail.prev!!.next = newNode
        tail.prev = newNode
    }

    // removeFront(): Removes the node at the front of the linked list.
    fun removeFront() {
        head.next!!.next!!.prev = head
        head.next = head.next!!.next
    }

    // removeEnd(): Removes the node at the end of the linked list.
    fun removeEnd() {
        tail.prev!!.prev!!.next = tail
        tail.prev = tail.prev!!.prev
    }

    fun print() {
        var curr = head.next
        while (curr != tail) {
            print("${curr!!.value} -> ")
            curr = curr.next
        }
        println()
    }
}