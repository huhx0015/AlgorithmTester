package main.com.huhx0015.algorithmtester.problems.linkedlist

import java.util.HashMap

/**
 * Created by Michael Yoon Huh on 5/2/2017.
 *
 * Interview Cake
 *
 * You have a linked list ↴ and want to find the kkth to last node.
 *
 * Write a function kthToLastNode() that takes an integer kk and the headNode of a singly linked list, and returns the
 * kkth to last node in the list.
 *
 * Reference: https://www.interviewcake.com/question/java/kth-to-last-node-in-singly-linked-list
 */
object KthToTheLastNode {

    @JvmStatic fun main(args: Array<String>) {

        val a = LinkedListNode("Angel Food")
        val b = LinkedListNode("Bundt")
        val c = LinkedListNode("Cheese")
        val d = LinkedListNode("Devil's Food")
        val e = LinkedListNode("Eccles")

        a.next = b
        b.next = c
        c.next = d
        d.next = e

        //LinkedListNode node = kthToLastNodeBruteForce(2, a);

        val node = kthToLastNode(2, a)

        if (node != null) {
            println("Node found: " + node.value)
        }
    }

    // Time Complexity: O(2n) = O(n) and O(1) space.
    // Brute Force Method
    fun kthToLastNodeBruteForce(kth: Int, node: LinkedListNode?): LinkedListNode? {

        // Valid parameter checks:
        if (node == null) {
            println("ERROR: node was null")
            return null
        }

        // Iterate through the entire LinkedList to get the nodeCount size.
        var currentNode = node
        var nodeCount = 0 // We count the head.
        while (currentNode != null) {
            currentNode = currentNode.next
            nodeCount++
        }

        // Calculate the node distance.
        val distanceToNode = nodeCount - kth

        // Once we find the length, we iterate again through the linked list.
        currentNode = node
        for (i in 0..distanceToNode - 1) {
            currentNode = currentNode!!.next
            println("Current node value: " + currentNode!!.value)
        }

        return currentNode
    }

    // kthToLastNode using HashMap
    // Complexity O(1n) = O(n), but because of HashMap, space complexity is O(n);
    fun kthToLastNode(kth: Int, node: LinkedListNode?): LinkedListNode? {

        if (node == null) {
            return null
        }

        // Create a hashmap to store the position and the node.
        val nodeMap = HashMap<Int, LinkedListNode>()

        var nodeCount = 0
        var currentNode = node
        nodeMap.put(nodeCount, currentNode) // Put the head into the HashMap first.

        // Stores all the nodes into the hashmap.
        while (currentNode != null) {
            nodeCount++
            currentNode = currentNode.next

            if (currentNode != null) {
                nodeMap.put(nodeCount, currentNode)
            }
        }

        // Fetches the node from the hashmap.
        return nodeMap[nodeCount - kth]
    }

    class LinkedListNode(var value: String) {
        var next: LinkedListNode? = null
    }
}
