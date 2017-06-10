package main.com.huhx0015.algorithmtester.problems.linkedlist;

/** Interview Cake
 *
 * https://www.interviewcake.com/question/java/reverse-linked-list
 *
 * Created by Michael Yoon Huh on 4/29/2017.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

        // Test LinkedListNode:
        LinkedListNode testHeadNode = new LinkedListNode(1);
        LinkedListNode testNode1 = new LinkedListNode(2);
        LinkedListNode testNode2 = new LinkedListNode(3);
        LinkedListNode testNode3 = new LinkedListNode(4);
        LinkedListNode testNode4 = new LinkedListNode(5);
        LinkedListNode testNode5 = new LinkedListNode(6);
        testHeadNode.next = testNode1;
        testNode1.next = testNode2;
        testNode2.next = testNode3;
        testNode3.next = testNode4;
        testNode4.next = testNode5;

        System.out.println("TEST LIST: \n");
        printLinkedList(testHeadNode); // Prints out test LinkedList.

        // Reverses the LinkedList.
        LinkedListNode reverseLinkedList = reverse(testHeadNode);

        System.out.println("REVERSED LIST: \n");
        printLinkedList(reverseLinkedList);
    }

    /** REVERSE LINKED LIST METHODS ________________________________________________________________________________ **/

    public static LinkedListNode reverse(LinkedListNode node) {

        //return reverseRecursiveMethod1(node, null);
        //return reverseRecursiveMethod2(node);
        //return reverseICMethod(node);

        return reverseRecursiveMethod3(node, null);
    }

    // My attempt. (Recursion)
    // Complexity: O(n), since it loops through all the elements once. Slightly inefficient on space complexity, since
    // reversedNode variable is created each time for every recursive call.
    public static LinkedListNode reverseRecursiveMethod1(LinkedListNode node, LinkedListNode previous) {

        LinkedListNode reversedNode; // Stores the new head of the LinkedList.

        // If node.next is null, we have reached the end of the linked list.
        if (node.next == null) {
            System.out.println("RECURSION: Reached end of the list: " + node.value);

            node.next = previous; // Sets the next node to be the previous node.
            return node;
        }

        // If previous node is not null (indicating the original head), reverseRecursiveMethod1 is recursively called onto
        // node.next and node.
        else {
            System.out.println("RECURSION: Calling reverseRecursiveMethod1() on Node: " + node.value);
            reversedNode = reverseRecursiveMethod1(node.next, node);
            node.next = previous; // Sets the next node to be the previous node.
        }

        return reversedNode;
    }

    // Stackoverflow Solution: (Recursion)
    public static LinkedListNode reverseRecursiveMethod2(LinkedListNode node) {

        // LAST NODE OR NULL NODE: If node is null or the next node is null, we return the node.
        if (node == null || node.next == null) {
            System.out.println("RECURSION: Reached end of the list: " + (node != null ? node.value : "null"));
            return node;
        }

        System.out.println("RECURSION: Current Node: " + node.value);

        LinkedListNode nextNode = node.next; // References the next node.
        node.next = null; // Sets the next node for the current node as null.

        LinkedListNode newHeadNode = reverseRecursiveMethod2(nextNode);
        nextNode.next = node; // Sets the nextNode.next to point to the current node.

        System.out.println("RECURSION: Current Result: " + newHeadNode.value);

        return newHeadNode;
    }

    // LeetCode Solution (Recursive)
    private static LinkedListNode reverseRecursiveMethod3(LinkedListNode node, LinkedListNode newHead) {

        // If current node is null, we have reached the last node of the original list.
        if (node == null) {
            return newHead;
        }

        System.out.println("RECURSION: Current Node: " + node.value);

        // Sets the reference for the next node.
        LinkedListNode next = node.next;
        node.next = newHead;

        return reverseRecursiveMethod3(next, node);
    }

    // Interview Cake Official Solution: (Iterative)
    // Complexity: O(n) time and O(1) space. We pass over the list only once, and maintain a constant number of
    // variables in memory.
    public static LinkedListNode reverseICMethod(LinkedListNode headNode) {

        LinkedListNode currentNode = headNode;
        LinkedListNode previousNode = null;
        LinkedListNode nextNode = null;

        // until we have 'fallen off' the end of the list
        while (currentNode != null) {

            System.out.println("RECURSION: Current Node: " + currentNode.value);

            // Sets the current nextNode reference.
            nextNode = currentNode.next;

            // Sets the current node's next node to be the previous node.
            currentNode.next = previousNode;

            // Updates the previous and current nodes.
            previousNode = currentNode;
            currentNode = nextNode;
        }

        /**
         * We return previous because when we exit the list, current is null. Which means that the last node we
         * visited—previous—was the tail of the original list, and thus the head of our reversed list.
         */
        return previousNode;
    }

    /** UTILITY METHODS ____________________________________________________________________________________________ **/

    public static void printLinkedList(LinkedListNode node) {

        System.out.println("LIST: " + node.value);

        // Recursively call printLinkedList.
        if (node.next != null) {
            printLinkedList(node.next);
        }
    }

    public static LinkedListNode getLastNode(LinkedListNode node) {

        if (node.next != null) {
            node = getLastNode(node.next);
        } else {
            System.out.println("getLastNode(): Last Node value: " + node.value);
        }
        return node;
    }

    /** LINKEDLIST NODE CLASS ______________________________________________________________________________________ **/

    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }
}
