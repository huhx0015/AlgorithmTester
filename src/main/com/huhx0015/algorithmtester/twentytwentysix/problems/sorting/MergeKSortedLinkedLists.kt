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

        val result1 = mergeKLists(inputArray1)
        println("mergeKLists: Result: ${result1.toString()}\n")

        val result2 = mergeKLists(inputArray2)
        println("mergeKLists: Result: ${result2.toString()}\n")

        val result3 = mergeKLists(inputArray3)
        println("mergeKLists: Result: ${result3.toString()}\n")

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

    // mergeKLists(): Merges k sorted linked lists into one sorted linked list
    // Time Complexity: O(N log k) | N = total number of nodes | k = number of lists
    // Space Complexity: O(1)
    // Pattern: Divide and Conquer
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        // Edge case: if input array is empty, return null.
        if (lists.isEmpty()) {
            println("mergeKLists: lists was empty, returning null.")
            return null
        }
        var currentLists = lists.toList() // Convert the array into a mutable working list.

        // Keep merging until only one list remains.
        while (currentLists.size > 1) {
            val mergedLists = mutableListOf<ListNode?>() // This will store the merged results of this round.

            // Iterate through lists in pairs (step 2: Increments i by 2).
            for (i in currentLists.indices step 2) {
                val l1 = currentLists[i] // First list in the pair.

                // Second list in the pair (if it exists, otherwise null).
                val l2 = if (i + 1 < currentLists.size) currentLists[i + 1] else null

                println("mergeKLists: FOR: l1 is ${l1.toString()} and l2 is ${l2.toString()}")

                mergedLists.add(mergeList(l1, l2)) // Merge the two lists and add result to mergedLists.
            }
            currentLists = mergedLists // Update currentLists with the merged results for next iteration.
        }

        return currentLists[0] // At the end, only one fully merged list remains.
    }

    // mergeList(): Merges two sorted linked lists into one sorted list.
    private fun mergeList(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0) // Dummy node simplifies edge cases (like empty result list)
        var tail = dummy // Tail pointer to build the merged list

        // Pointers to traverse both lists
        var list1 = l1
        var list2 = l2

        // Traverse both lists while neither is exhausted
        while (list1 != null && list2 != null) {

            // Compare current values of both lists
            if (list1.value < list2.value) {
                tail.next = list1 // Attach the smaller node to the merged list
                list1 = list1.next // Move list1 pointer forward
            } else {
                tail.next = list2 // Attach list2 node if it is smaller or equal
                list2 = list2.next // Move list2 pointer forward
            }

            tail = tail.next!! // Move tail forward to the newly added node
        }

        tail.next = list1 ?: list2 // Attach the remaining nodes (only one of these will be non-null)

        return dummy.next // Return the merged list (skip dummy node)
    }

    // mergeKLists(): Brute force strategy. Time Complexity: O(n) + O(n log n) + O(n) = O(n log n)
    // Space Complexity: O(n)
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