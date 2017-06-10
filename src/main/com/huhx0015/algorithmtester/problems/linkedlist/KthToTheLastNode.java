package main.com.huhx0015.algorithmtester.problems.linkedlist;

import java.util.HashMap;

/**
 * Interview Cake
 *
 * You have a linked list ↴ and want to find the kkth to last node.
 *
 * Write a function kthToLastNode() that takes an integer kk and the headNode of a singly linked list, and returns the
 * kkth to last node in the list.
 *
 * https://www.interviewcake.com/question/java/kth-to-last-node-in-singly-linked-list
 *
 * Created by Michael Yoon Huh on 5/2/2017.
 */
public class KthToTheLastNode {

    public static void main(String[] args) {

        LinkedListNode a = new LinkedListNode("Angel Food");
        LinkedListNode b = new LinkedListNode("Bundt");
        LinkedListNode c = new LinkedListNode("Cheese");
        LinkedListNode d = new LinkedListNode("Devil's Food");
        LinkedListNode e = new LinkedListNode("Eccles");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        //LinkedListNode node = kthToLastNodeBruteForce(2, a);

        LinkedListNode node = kthToLastNode(2, a);

        if (node != null) {
            System.out.println("Node found: " + node.value);
        }
    }

    // Time Complexity: O(2n) = O(n) and O(1) space.
    // Brute Force Method
    private static LinkedListNode kthToLastNodeBruteForce(int kth, LinkedListNode node) {

        // Valid parameter checks:
        if (node == null) {
            System.out.println("ERROR: node was null");
            return null;
        }

        // Iterate through the entire LinkedList to get the nodeCount size.
        LinkedListNode currentNode = node;
        int nodeCount = 0; // We count the head.
        while (currentNode != null) {
            currentNode = currentNode.next;
            nodeCount++;
        }

        // Calculate the node distance.
        int distanceToNode = nodeCount - kth;

        // Once we find the length, we iterate again through the linked list.
        currentNode = node;
        for (int i = 0; i < distanceToNode; i++) {
            currentNode = currentNode.next;
            System.out.println("Current node value: " + currentNode.value);
        }

        return currentNode;
    }

    // kthToLastNode using HashMap
    // Complexity O(1n) = O(n), but because of HashMap, space complexity is O(n);
    private static LinkedListNode kthToLastNode(int kth, LinkedListNode node) {

        if (node == null) {
            return null;
        }

        // Create a hashmap to store the position and the node.
        HashMap<Integer, LinkedListNode> nodeMap = new HashMap<>();

        int nodeCount = 0;
        LinkedListNode currentNode = node;
        nodeMap.put(nodeCount, currentNode); // Put the head into the HashMap first.

        // Stores all the nodes into the hashmap.
        while (currentNode != null) {
            nodeCount++;
            currentNode = currentNode.next;
            nodeMap.put(nodeCount, currentNode);
        }

        // Fetches the node from the hashmap.
        return nodeMap.get(nodeCount - kth);
    }

    public static class LinkedListNode {

        public String value;
        public LinkedListNode next;

        public LinkedListNode(String value) {
            this.value = value;
        }
    }
}
