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
 */
object LinkedListCycle {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) {
            return false
        }

        val visitedNodes: HashSet<ListNode> = HashSet()
        var currentNode = head

        // Traverses the LinkedList to check for cycles.
        while (currentNode != null) {
            // Checks the visitedNodes HashSet. If value exists, there is a cycle, otherwise if is null then this is a
            // node that has not been visited yet.
            val isNodeVisited = visitedNodes.contains(currentNode)
            if (isNodeVisited) {
                println("Linked List Cycle: A cycle has been found, with current node: ${currentNode.`val`}")
                return true // A cycle has been found in the LinkedList.
            } else{
                visitedNodes.add(currentNode) // Adds the currentNode to the visitedNodes HashSet.
                currentNode = currentNode.next // Updates the currentNode to point to the next Node.
            }
        }

        return false // We've traversed the entire visitedNodes HashSet, but no cycle was detected.
    }
}