package main.com.huhx0015.algorithmtester.problems.linkedlist

/**
 * Created by Michael Yoon Huh on 4/29/2017.
 *
 * Interview Cake
 *
 * Reference: https://www.interviewcake.com/question/java/reverse-linked-list
 */
object ReverseLinkedList {

    @JvmStatic fun main(args: Array<String>) {

        // Test LinkedListNode:
        val testHeadNode = LinkedListNode(1)
        val testNode1 = LinkedListNode(2)
        val testNode2 = LinkedListNode(3)
        val testNode3 = LinkedListNode(4)
        val testNode4 = LinkedListNode(5)
        val testNode5 = LinkedListNode(6)
        testHeadNode.next = testNode1
        testNode1.next = testNode2
        testNode2.next = testNode3
        testNode3.next = testNode4
        testNode4.next = testNode5

        println("TEST LIST: \n")
        printLinkedList(testHeadNode) // Prints out test LinkedList.

        // Reverses the LinkedList.
        val reverseLinkedList = reverse(testHeadNode)

        println("REVERSED LIST: \n")
        printLinkedList(reverseLinkedList)
    }

    /** REVERSE LINKED LIST METHODS ________________________________________________________________________________  */

    fun reverse(node: LinkedListNode): LinkedListNode {

        //return reverseRecursiveMethod1(node, null);
        //return reverseRecursiveMethod2(node);
        //return reverseICMethod(node);

        return reverseRecursiveMethod3(node, null)!!
    }

    // My attempt. (Recursion)
    // Complexity: O(n), since it loops through all the elements once. Slightly inefficient on space complexity, since
    // reversedNode variable is created each time for every recursive call.
    fun reverseRecursiveMethod1(node: LinkedListNode, previous: LinkedListNode): LinkedListNode {

        val reversedNode: LinkedListNode // Stores the new head of the LinkedList.

        // If node.next is null, we have reached the end of the linked list.
        if (node.next == null) {
            println("RECURSION: Reached end of the list: " + node.value)

            node.next = previous // Sets the next node to be the previous node.
            return node
        } else {
            println("RECURSION: Calling reverseRecursiveMethod1() on Node: " + node.value)
            reversedNode = reverseRecursiveMethod1(node.next!!, node)
            node.next = previous // Sets the next node to be the previous node.
        }// If previous node is not null (indicating the original head), reverseRecursiveMethod1 is recursively called onto
        // node.next and node.

        return reversedNode
    }

    // Stackoverflow Solution: (Recursion)
    fun reverseRecursiveMethod2(node: LinkedListNode?): LinkedListNode? {

        // LAST NODE OR NULL NODE: If node is null or the next node is null, we return the node.
        if (node == null || node.next == null) {
            println("RECURSION: Reached end of the list: " + (node?.value ?: "null"))
            return node
        }

        println("RECURSION: Current Node: " + node.value)

        val nextNode = node.next // References the next node.
        node.next = null // Sets the next node for the current node as null.

        val newHeadNode = reverseRecursiveMethod2(nextNode)
        nextNode!!.next = node // Sets the nextNode.next to point to the current node.

        println("RECURSION: Current Result: " + newHeadNode?.value)

        return newHeadNode
    }

    // LeetCode Solution (Recursive)
    private fun reverseRecursiveMethod3(node: LinkedListNode?, newHead: LinkedListNode?): LinkedListNode? {

        // If current node is null, we have reached the last node of the original list.
        if (node == null) {
            return newHead
        }

        println("RECURSION: Current Node: " + node.value)

        // Sets the reference for the next node.
        val next = node.next
        node.next = newHead

        return reverseRecursiveMethod3(next, node)
    }

    // Interview Cake Official Solution: (Iterative)
    // Complexity: O(n) time and O(1) space. We pass over the list only once, and maintain a constant number of
    // variables in memory.
    fun reverseICMethod(headNode: LinkedListNode): LinkedListNode {

        var currentNode: LinkedListNode? = headNode
        var previousNode: LinkedListNode? = null
        var nextNode: LinkedListNode? = null

        // until we have 'fallen off' the end of the list
        while (currentNode != null) {

            println("RECURSION: Current Node: " + currentNode.value)

            // Sets the current nextNode reference.
            nextNode = currentNode.next

            // Sets the current node's next node to be the previous node.
            currentNode.next = previousNode

            // Updates the previous and current nodes.
            previousNode = currentNode
            currentNode = nextNode
        }

        /**
         * We return previous because when we exit the list, current is null. Which means that the last node we
         * visited—previous—was the tail of the original list, and thus the head of our reversed list.
         */
        return previousNode!!
    }

    /** UTILITY METHODS ____________________________________________________________________________________________  */

    fun printLinkedList(node: LinkedListNode) {

        println("LIST: " + node.value)

        // Recursively call printLinkedList.
        if (node.next != null) {
            printLinkedList(node.next!!)
        }
    }

    fun getLastNode(node: LinkedListNode): LinkedListNode {
        var node = node

        if (node.next != null) {
            node = getLastNode(node.next!!)
        } else {
            println("getLastNode(): Last Node value: " + node.value)
        }
        return node
    }

    /** LINKEDLIST NODE CLASS ______________________________________________________________________________________  */

    class LinkedListNode(var value: Int) {
        var next: LinkedListNode? = null
    }
}
