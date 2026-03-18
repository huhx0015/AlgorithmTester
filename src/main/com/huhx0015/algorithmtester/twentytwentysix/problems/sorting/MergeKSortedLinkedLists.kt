package com.huhx0015.algorithmtester.twentytwentysix.problems.sorting

/**
 * Neetcode.io
 *
 * Problem: Merge K Sorted Linked Lists
 * Difficulty: Hard
 *
 * You are given an array of k linked lists `lists`, where each list is sorted in ascending order.
 *
 * Return the sorted linked list that is the result of merging all of the individual linked lists.
 *
 * Example 1:
 *
 * Input: lists = [[1,2,4],[1,3,5],[3,6]]
 * Output: [1,1,2,3,3,4,5,6]
 *
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 *
 * Example 3:
 *
 * Input: lists = [[]]
 *
 * Output: []
 * Constraints:
 *
 * 0 <= lists.length <= 1000
 * 0 <= lists[i].length <= 100
 * -1000 <= lists[i][j] <= 1000
 */
object MergeKSortedLinkedLists {

    @JvmStatic fun main(args: Array<String>) {
        val listNode1 = ListNode(1)
        val listNode2 = ListNode(2)
        val listNode3 = ListNode(4)
        val listNode4 = ListNode(1)
        val listNode5 = ListNode(3)
        val listNode6 = ListNode(5)
        val listNode7 = ListNode(3)
        val listNode8 = ListNode(6)

        listNode1.next = listNode2
        listNode2.next = listNode3
        listNode4.next = listNode5
        listNode5.next = listNode6
        listNode7.next = listNode8

        val inputArray1: Array<ListNode?> = arrayOf(
            listNode1,
            listNode4,
            listNode7
        )
        val inputArray2: Array<ListNode?> = emptyArray()
        val inputArray3: Array<ListNode?> = arrayOf(null)

        val resultBruteForce1 = mergeKListsBruteForce(inputArray1)
        println("mergeKListsBruteForce: Result: ${resultBruteForce1.toString()}\n")

        val resultBruteForce2 = mergeKListsBruteForce(inputArray2)
        println("mergeKListsBruteForce: Result: ${resultBruteForce2.toString()}\n")

        val resultBruteForce3 = mergeKListsBruteForce(inputArray3)
        println("mergeKListsBruteForce: Result: ${resultBruteForce3.toString()}\n")
    }

    // ListNode(): Definition for singly-linked list.
    data class ListNode(var value: Int) {
        var next: ListNode? = null
    }

    // mergeKLists(): Brute force strategy. Time Complexity:
    // Inner nodes are all pre-sorted.
    fun mergeKListsBruteForce(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) {
            println("mergeKListsBruteForce: lists was empty, returning null.")
            return null
        }

        // Initializes a MutableList to store all values from the lists, populated with ListNode `value` as the lists
        // are traversed.
        val valueArray: MutableList<Int> = mutableListOf()

        // Loops through the lists Array<ListNode?> and adds all the values into the valueArray.
        for (list in lists) {
            var currentNode = list // Reference to the current ListNode in lists.

            while (currentNode != null) {
                val currentNodeValue = currentNode.value
                valueArray.add(currentNodeValue)
                currentNode = currentNode.next
                println("mergeKListsBruteForce: Adding list value $currentNodeValue into the valueArray and updating the currentNode next pointer.")
            }
        }

        valueArray.sort() // Sorts the valueArray using the built-in sort() function.

        // Used to store the reference to the head and tail of the new ListNode.
        var head: ListNode? = null
        var tail: ListNode? = null

        for (value in valueArray) {
            println("mergeKListsBruteForce: Creating new ListNode with value $value")
            val tempNode = ListNode(value)

            if (head == null) {
                head = tempNode
                tail = tempNode
            } else {
                tail?.next = tempNode
                tail = tempNode
            }
        }

        println("mergeKListsBruteForce: Finished creating the new sorted ListNode.\n")
        return head
    }
}