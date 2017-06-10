package main.com.huhx0015.algorithmtester.algorithms;

import main.com.huhx0015.algorithmtester.datastructures.Node;
import java.util.Arrays;

/**
 * Created by Michael Yoon Huh on 5/1/2017.
 *
 * Note: BINARY SEARCH ONLY WORKS ON SORTED LISTS!
 */
public class BinarySearch {

    public static void main(String[] args) {

        // ARRAY SEARCH -------------------------------
        System.out.println("Preparing Binary Search on Array...\n\n");

        int[] testArray = {1, 3, 5, 7, 8, 10, 12, 15, 20};

        // NOTE: Array must be sorted for binary arraySearch to work!
        Arrays.sort(testArray);

        // Returns an int representing the position at which the value was found.
        arraySearch(testArray, 12, 0, testArray.length - 1);


        // NODE SEARCH ---------------------------------
        System.out.println("\n\nPreparing Binary Search on Node...\n\n");

//                        8
//                5               12
//            3       7       10      15
//        1                               20

        // Must be a binary arraySearch tree.
        Node rootNode = new Node(8);
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        Node node4 = new Node(7);
        Node node5 = new Node(10);
        Node node6 = new Node(12);
        Node node7 = new Node(15);
        Node node8 = new Node(20);

        // LEFT SIDE
        rootNode.left = node3;
        node3.left = node2;
        node3.right = node4;
        node2.left = node1;

        // RIGHT SIDE
        rootNode.right = node6;
        node6.left = node5;
        node6.right = node7;
        node7.right = node8;

        // Returns the node with our value (if found) or null.
        Node foundNode = nodeSearch(rootNode, 12);

        if (foundNode != null) {
            System.out.println("Node found. Value is: " + foundNode.value);
        }
    }

    // arraySearch(): Binary search on a int array. Returns the position of where the element was found.
    // Note: Parent is greater than left, less than right.
    // Complexity: O(log n)
    // Explanation: http://stackoverflow.com/questions/2307283/what-does-olog-n-mean-exactly/13093274#13093274
    public static int arraySearch(int[] array, int value, int left, int right) {

        // ERROR CASE:
        if (right < left) {
            System.out.println("arraySearch(): Could not find " + value + " in the array.");
            return -1; // Could not find the value.
        }

        int mid = (left + right) / 2; // Get the current middle array value between left and right.

        // If the "mid" point in the array is greater than value, we recursively call arraySearch onto the left child.
        if (array[mid] > value) {
            System.out.println("arraySearch(): " + array[mid] + ": Recursively searching to the left...");
            return arraySearch(array, value, left, mid - 1);
        }

        // Otherwise, the value we are looking for is on the right child.
        else if (array[mid] < value){
            System.out.println("arraySearch(): " + array[mid] + ": Recursively searching to the right...");
            return arraySearch(array, value, mid  + 1, right);
        }

        // We found our match.
        else if (array[mid] == value){
            System.out.println("arraySearch(): Found " + value + " in the array at position " + mid);
            return mid;
        }

        // ERROR: SHOULD NEVER REACH HERE.
        else {
            System.out.println("arraySearch(): ERROR: Could not find " + value + " in the array.");
            return -1;
        }
    }

    // nodeSearch(): Binary arraySearch on a binary search tree.
    public static Node nodeSearch(Node node, int value) {

        // ERROR:
        if (node == null) {
            System.out.println("nodeSearch(): Could not find " + value + " in the binary tree.");
            return null;
        }

        // If the node value is greater than the value we're looking for, we recursively call the nodeSearch on the left side.
        if (node.value > value) {
            System.out.println("nodeSearch(): " + node.value + ": Recursively searching to the left...");
            return nodeSearch(node.left, value);
        }

        // If the node value is less than the value we're looking for, we recursively call the nodeSearch on the right side.
        else if (node.value < value) {
            System.out.println("nodeSearch(): " + node.value + ": Recursively searching to the right...");
            return nodeSearch(node.right, value);
        }

        // If node value equals the value we're looking for, match was found.
        else if (node.value == value) {
            System.out.println("nodeSearch(): " + node.value + ": We found the node we're looking for!");
            return node;
        }

        // ERROR: Should actually never reach here.
        else {
            System.out.println("nodeSearch(): ERROR encountered!");
            return null;
        }
    }
}
