package com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist

import com.huhx0015.algorithmtester.twentytwentysix.datastructures.SinglyLinkedList.ListNode
import com.huhx0015.algorithmtester.twentytwentysix.problems.arrays.RemoveElement.removeElement

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
 *
 * Complexity:
 * Time: O(n) - each node visited once
 * Space: O(n) - recursion stack (n calls)
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
        val reversedList1 = reverseList(head = inputLinkedList1)
        println("INPUT 1: The new head ListNode value of the list after reversing is: ${reversedList1?.value}")

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
        val reversedList2 = reverseList(head = inputLinkedList2)
        println("INPUT 2: The new head ListNode value of the list after reversing is: ${reversedList2?.value}")
    }

    fun reverseList(head: ListNode?): ListNode? {
        // If the current head node is null or the next node of the head is null, it's either an empty LinkedList or the
        // end of the LinkedList has been reached.
        if (head == null || head.next == null) return head

        var newHead: ListNode? = head // New head of the list to return in this function.
        newHead = reverseList(head = head.next) // Use recursive function to get the last node in the list.
        head.next?.next = head
        head.next = null // Updates the original next link is invalidated. Needed to ensure that the recursive loop is broken.

        return newHead
    }
}