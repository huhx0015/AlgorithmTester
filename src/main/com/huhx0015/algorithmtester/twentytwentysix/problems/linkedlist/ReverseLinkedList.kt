package com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist

import com.huhx0015.algorithmtester.twentytwentysix.datastructures.SinglyLinkedList.ListNode

/**
 * NeetCode.io
 *
 * Problem: Reverse Linked List
 * Difficulty: Easy
 *
 * Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list.
 *
 * Example 1:
 *
 * Input: head = [0,1,2,3]
 *
 * Output: [3,2,1,0]
 * Example 2:
 *
 * Input: head = []
 *
 * Output: []
 * Constraints:
 *
 * 0 <= The length of the list <= 1000.
 * -1000 <= Node.val <= 1000
 */
object ReverseLinkedList {

    @JvmStatic fun main(args: Array<String>) {
        val inputLinkedList1 = ListNode(value = 1, next =
            ListNode(value = 2,
                next = ListNode(value = 3,
                    next = ListNode(value = 4,
                        next = null
                    )
                )
            )
        )
        println("INPUT 1: The head ListNode value of the list before reversing is: ${inputLinkedList1.value}")
        val reversedListRecursive1 = reverseListRecursive(head = inputLinkedList1)
        println("INPUT 1: The new head ListNode value of the list after reversing recursively is: ${reversedListRecursive1?.value}")
        val reversedListIterative1 = reverseListIterative(head = inputLinkedList1)
        println("INPUT 1: The new head ListNode value of the list after reversing iteratively is: ${reversedListIterative1?.value}")

        val inputLinkedList2 = ListNode(value = 0,
            next = ListNode(value = 1,
                next = ListNode(value = 2,
                    next = ListNode(value = 3,
                        next = null
                    )
                )
            )
        )
        println("INPUT 2: The head ListNode value of the list before reversing is: ${inputLinkedList2.value}")
        val reversedListRecursive2 = reverseListRecursive(head = inputLinkedList2)
        println("INPUT 2: The new head ListNode value of the list after reversing recursively is: ${reversedListRecursive2?.value}")
        val reversedListIterative2 = reverseListIterative(head = inputLinkedList2)
        println("INPUT 1: The new head ListNode value of the list after reversing iteratively is: ${reversedListIterative2?.value}")
    }

    // ITERATIVE SOLUTION:
    // Intuition
    // Reversing a linked list iteratively is all about flipping pointers one step at a time.
    // We walk through the list from left to right, and for each node, we redirect its next pointer to point to the node
    // behind it.
    //
    // To avoid losing track of the rest of the list, we keep three pointers:
    //
    // curr → the current node we are processing
    // prev → the node that should come after curr once reversed
    // temp → the original next node (so we don't break the chain)
    // By moving these pointers forward in each step, we gradually reverse the entire list.
    // When curr becomes null, the list is fully reversed, and prev points to the new head.
    //
    // Algorithm
    // Initialize:
    // prev = null
    // curr = head
    // While curr exists:
    // Save the next node: temp = curr.next
    // Reverse the pointer: curr.next = prev
    // Move prev to curr
    // Move curr to temp
    // When the loop ends, prev is the new head of the reversed list.
    // Return prev.
    //
    // Complexity:
    // Time: O(n) - each node visited once
    // Space: O(1) - three pointer solution
    fun reverseListIterative(head: ListNode?): ListNode? {
        var previousNode: ListNode? = null
        var currentNode: ListNode? = head // Set the currentNode reference to head.

        while (currentNode != null) {
            val tempNode = currentNode.next // Set the tempNode reference to the next node after currentNode.
            currentNode.next = previousNode // Update the next node after currentNode to point to the previous node.
            previousNode = currentNode // Update previousNode reference to the currentNode.
            currentNode = tempNode // Update the currentNode reference to the tempNode (currentNode.next)
        }
        return previousNode
    }

    // RECURSIVE SOLUTION:
    // Complexity:
    // Time: O(n) - each node visited once
    // Space: O(n) - recursion stack (n calls)
    fun reverseListRecursive(head: ListNode?): ListNode? {
        // If the current head node is null or the next node of the head is null, it's either an empty LinkedList or the
        // end of the LinkedList has been reached.
        if (head == null || head.next == null) return head

        var newHead: ListNode? = head // New head of the list to return in this function.
        newHead = reverseListRecursive(head = head.next) // Use recursive function to get the last node in the list.
        head.next?.next = head
        head.next = null // Updates the original next link is invalidated. Needed to ensure that the recursive loop is broken.

        return newHead
    }
}