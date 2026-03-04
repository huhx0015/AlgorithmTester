package com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist

import com.huhx0015.algorithmtester.twentytwentysix.datastructures.SinglyLinkedList.ListNode

/**
 * NeetCode.io
 *
 * Problem: Merge Two Sorted Linked Lists
 * Difficulty: Easy
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted linked list and return the head of the new sorted linked list.
 *
 * The new list should be made up of nodes from list1 and list2.
 *
 * Example 1:
 *
 * Input: list1 = [1,2,4], list2 = [1,3,5]
 *
 * Output: [1,1,2,3,4,5]
 * Example 2:
 *
 * Input: list1 = [], list2 = [1,2]
 *
 * Output: [1,2]
 * Example 3:
 *
 * Input: list1 = [], list2 = []
 *
 * Output: []
 * Constraints:
 *
 * 0 <= The length of the each list <= 100.
 * -100 <= Node.val <= 100
 *
 * Time Complexity: O(n + m) where n and m are lengths of the two lists
 * Space Complexity: O(1) - we're reusing existing nodes, not creating new ones
 * Approach: Compare nodes from both lists, always take the smaller one, and move that list's pointer forward
 * Edge Cases: Handled at the beginning with the when block
 */
object MergeTwoSortedLinkedList {

    @JvmStatic fun main(args: Array<String>) {
        val inputLinkedList1 = ListNode(value = 1,
            next = ListNode(value = 2,
                next = ListNode(value = 4,
                    next = null
                )
            )
        )
        println("INPUT 1: The head ListNode value of the list before merging is: ${inputLinkedList1.value}")
        val inputLinkedList2 = ListNode(value = 1,
            next = ListNode(value = 3,
                next = ListNode(value = 5,
                    next = null
                )
            )
        )
        println("INPUT 2: The head ListNode value of the list before merging is: ${inputLinkedList2.value}")

        val mergedSortedList1 = mergeTwoLists(inputLinkedList1, inputLinkedList2)
        println("INPUT 1: The new head ListNode value of the list after merging list is: ${mergedSortedList1?.value}")
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        // Handle edge cases where one or both lists are empty.
        when {
            list1 == null && list2 == null -> return null  // Both lists empty, return null.
            list1 != null && list2 == null -> return list1  // Only list2 empty, return list1.
            list1 == null && list2 != null -> return list2  // Only list1 empty, return list2.
        }

        // Create pointers to traverse the input lists without modifying originals.
        var listNode1: ListNode? = list1  // Pointer for first list.
        var listNode2: ListNode? = list2  // Pointer for second list.

        // Variables to build the merged result list.
        var mergedHead: ListNode? = null  // Will store the head of merged list.
        var mergedTail: ListNode? = null  // Will track the tail for efficient appending.

        // Main merging loop: continues while both lists have nodes
        while (listNode1 != null && listNode2 != null) {
            val selectedNode: ListNode  // Node to add to merged list.

            // Compare current nodes from both lists.
            if (listNode1.value!! < listNode2.value!!) {
                selectedNode = listNode1    // listNode1 has smaller value, select it.
                listNode1 = listNode1.next  // Move listNode1 pointer forward.
                println("listNode1 ${listNode1?.value} is less than than listNode2 ${listNode2.value}, updating selectedNode with listNode1: ${listNode1?.value}")
            } else {
                selectedNode = listNode2    // listNode2 has smaller or equal value, select it.
                listNode2 = listNode2.next  // Move listNode2 pointer forward.
                println("listNode1 ${listNode2?.value} is less than than listNode2 ${listNode1.value}, updating selectedNode with listNode2: ${listNode2?.value}")
            }

            // Add selected node to merged list.
            if (mergedHead == null) {
                // First node in merged list - initialize both head and tail.
                mergedHead = selectedNode
                mergedTail = selectedNode
            } else {
                // Append to existing list.
                mergedTail?.next = selectedNode  // Link current tail to new node.
                mergedTail = selectedNode        // Update tail to new node.
            }
        }

        // After loop, one list might still have remaining nodes.
        // Append any remaining nodes from listNode1 (if any).
        if (listNode1 != null) mergedTail?.next = listNode1

        // Append any remaining nodes from listNode2 (if any).
        if (listNode2 != null) mergedTail?.next = listNode2

        // Return the head of the merged sorted list.
        return mergedHead
    }
}