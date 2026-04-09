package com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist

/**
 * Problem: Linked List Cycle Detection
 * Difficulty: Easy
 * Given the beginning of a linked list head, return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * There is a cycle in a linked list if at least one node in the list can be visited again by following the next pointer.
 *
 * Internally, index determines the index of the beginning of the cycle, if it exists. The tail node of the list will set it's next pointer to the index-th node. If index = -1, then the tail node points to null and no cycle exists.
 *
 * Note: index is not given to you as a parameter.
 *
 * Example 1:
 * Input: head = [1,2,3,4], index = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 *
 * Example 2:
 * Input: head = [1,2], index = -1
 * Output: false
 * Constraints:
 *
 * 0 <= Length of the list <= 1000.
 * -1000 <= Node.val <= 1000
 * index is -1 or a valid index in the linked list.
 *
 * Hint:
 * Can use a HashSet and iterate through the LinkedList to detect a cycle, but the most efficient way is using fast
 * two pointers to get to space complexity O(1).
 */
object LinkedListCycle {

    @JvmStatic fun main(args: Array<String>) {
        val node1 = ListNode(`val` = 1)
        val node2 = ListNode(`val` = 2)
        val node3 = ListNode(`val` = 3)
        val node4 = ListNode(`val` = 4)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node1

        val result1 = hasCycle(head = node1)
        println("Linked List Cycle: The linked list at node with ${node1.`val`} cycle result: $result1\n")

        node4.next = null
        val result2 = hasCycle(head = node1)
        println("Linked List Cycle: The linked list at node with ${node1.`val`} cycle result: $result2")
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    // hasCycle(): Time Complexity: O(n) | Space Complexity: O(n)
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) {
            println("Linked List Cycle: Linked list was empty, returning false.")
            return false
        }

        // HashSet used to store the nodes that have been visited, each node should be unique since this is a HashSet.
        val visitedNodes: HashSet<ListNode> = HashSet()

        // Stores a reference to the `head` ListNode initially, used as a pointer reference to the currentNod while
        // traversing the linked list.
        var currentNode = head

        // Traverses the LinkedList to check for cycles.
        while (currentNode != null) {
            // Checks the visitedNodes HashSet. If value exists, there is a cycle, otherwise if is null then this is a
            // node that has not been visited yet.
            val isNodeVisited = visitedNodes.contains(currentNode)
            if (isNodeVisited) {
                println("Linked List Cycle: WHILE: A cycle has been found, with current node: ${currentNode.`val`}")
                return true // A cycle has been found in the LinkedList.
            } else{
                println("Linked List Cycle: WHILE: No cycle detected, adding current node with value ${currentNode.`val`} to the visitedNodes set.")
                visitedNodes.add(currentNode) // Adds the currentNode to the visitedNodes HashSet.
                currentNode = currentNode.next // Updates the currentNode to point to the next Node.
            }
        }

        println("Linked List Cycle: hasCycle() is completed, no cycle detected.")
        return false // We've traversed the entire visitedNodes HashSet, but no cycle was detected.
    }
}