package com.huhx0015.problems.trees;

/**
 * Interview Cake
 *
 * Write a function to check that a binary tree ↴ is a valid binary search tree ↴ .
 *
 * https://www.interviewcake.com/question/java/bst-checker
 *
 * Hint:
 *
 * A Binary Tree is a valid BST if:
 * 1. each node contains one key (also known as data)
 * 2. the keys in the left subtree are less then the key in its parent node, in short L < P;
 * 3. the keys in the right subtree are greater the key in its parent node, in short P < R;
 * 4. duplicate keys are not allowed.
 *
 * Use DFS or BFS
 *
 * DFS: Visit node first, then explore each node neighbor's branch until the end.
 * (Pre-order is a form of DFS)
 * "THE CORE FAMILY APPROACH"
 * "ONE FAMILY FIRST, AND ALL THEIR CHILDREN. THEN THE NEXT FAMILY AND ALL THEIR CHILDREN."
 *
 * Advantages:
 *
 * Depth-first traversal on a binary tree generally requires less memory than breadth-first.
 * Depth-first traversal can be easily implemented with recursion.
 *
 * Disadvantages
 *
 * A DFS doesn't necessarily find the shortest path to a node, while breadth-first search does.
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * BFS: Visit node first, then explore each node neighbor, then explore children node and their neighbors.
 * (Note: Never recursive! Uses a queue!)
 * "THE FULL FAMILY GENERATIONAL APPROACH"
 * "GENERATION-BY-GENERATION
 *
 * BFS usually better than DFS.
 *
 * Advantages:
 *
 * A BFS will not necessarily find a target as quickly as possible, but it will find the shortest path between the starting
 * point and the target. A depth-first search will not necessarily find the shortest path.
 *
 * Disadvantages
 *
 * A BFS on a binary tree generally requires more memory than a DFS.
 *
 * Created by Michael Yoon Huh on 4/30/2017.
 */
public class ValidBinarySearchTree {

    public static void main(String[] args) {

        // TEST BINARY TREE:
        BinaryTreeNode testTreeRoot = new BinaryTreeNode(5);
        BinaryTreeNode testTreeNode1 = new BinaryTreeNode(3);
        BinaryTreeNode testTreeNode2 = new BinaryTreeNode(2);
        BinaryTreeNode testTreeNode3 = new BinaryTreeNode(4);
        BinaryTreeNode testTreeNode5 = new BinaryTreeNode(8);
        BinaryTreeNode testTreeNode6 = new BinaryTreeNode(6);
        BinaryTreeNode testTreeNode7 = new BinaryTreeNode(9);

        // P: 5 | L: 4 | R: 8
        testTreeRoot.left = testTreeNode1;
        testTreeRoot.right = testTreeNode5;

        // P: 3 | L: 2 | R: 4
        testTreeNode1.left = testTreeNode2;
        testTreeNode1.right = testTreeNode3;

        // P: 8 | L: 6 | R: 9
        testTreeNode5.left = testTreeNode6;
        testTreeNode5.right = testTreeNode7;

        // Validating if the binary tree is a binary search tree.
        boolean isValidated = validate(testTreeRoot);

        System.out.println("BINARY TREE VALIDATION RESULT: " + isValidated);
    }

    /** ALGORITHM METHODS __________________________________________________________________________________________ **/

    public static boolean validate(BinaryTreeNode treeNode) {

        //return validateBSTAttempt(treeNode, true); // FAILURE. DOES NOT HANDLE GOTCHA CASE.
        return isBinarySearchTree(treeNode, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // My attempt. We use the second parameter for determining if BST validation has failed or not. isValidated starts
    // off as true, until a condition is encountered where BST validation has failed. Unfortunately, this method fails
    // to handle the case where the sub-children node values could be smaller/greater than the root's value, as the
    // root value is not checked against.
    public static boolean validateBSTAttempt(BinaryTreeNode node, boolean isValidated) {

        // References the left and right node of the current node.
        BinaryTreeNode leftNode = node.left;
        BinaryTreeNode rightNode = node.right;

        // VISIT STEP: We compare the current node value against the children's value to satisfy BST conditions.

        // LEFT: Is the current (parent) node value greater than it's left child node value?
        if (leftNode != null) {
            if (node.value > leftNode.value) {
                isValidated = validateBSTAttempt(leftNode, isValidated);
            } else {
                isValidated = false; // Condition has failed, it is not a valid BST.
            }
        }

        // RIGHT: Is the current (parent) node value less than it's right child node value?
        if (rightNode != null) {
            if (node.value < rightNode.value) {
                isValidated = validateBSTAttempt(rightNode, isValidated);
            } else {
                isValidated = false; // Condition has failed, it is not a valid BST.
                System.out.println("FAILURE: Right node is less in value than it's parent. | PARENT: " + node.value + " | RIGHT CHILD: " + rightNode.value);
            }
        }

        return isValidated;
    }

    // InterviewCake Solution:
    // Complexity: O(n) time and O(n) O(n) space.
    public static boolean isBinarySearchTree(BinaryTreeNode root, int lowerBound, int upperBound) {

        if (root == null) {
            return true;
        }

        if (root.value >= upperBound || root.value <= lowerBound) {
            System.out.println("FAILURE: Node value exceeds upperBound and lowerBound limits.");
            return false;
        }

        return isBinarySearchTree(root.left, lowerBound, root.value) &&
                isBinarySearchTree(root.right, root.value, upperBound);
    }

    /** ALGORITHM HELPER METHODS ___________________________________________________________________________________ **/

    // Checks if the node satisfies the upper and lower bounds range.
    private static boolean validateBounds(BinaryTreeNode node, int upperBounds, int lowerBounds) {

        if (node.value >= lowerBounds && node.value <= upperBounds) {
            return true;
        } else {
            System.out.println("FAILURE: The node value violates the bounds range. | NODE: " + node.value + " | UPPER BOUND: " + upperBounds + " | LOWER BOUND: " + lowerBounds);
            return false;
        }
    }

    private static boolean validateLeft(BinaryTreeNode node, BinaryTreeNode leftNode) {
        if (node.value > leftNode.value) {
            return true;
        } else {
            System.out.println("FAILURE: Left node is greater in value than it's parent. | PARENT: " + node.value + " | LEFT CHILD: " + leftNode.value);
            return false; // Condition has failed, it is not a valid BST.
        }
    }

    private static boolean validateRight(BinaryTreeNode node, BinaryTreeNode rightNode) {
        if (node.value < rightNode.value) {
            return true;
        } else {
            System.out.println("FAILURE: Right node is less in value than it's parent. | PARENT: " + node.value + " | RIGHT CHILD: " + rightNode.value);
            return false; // Condition has failed, it is not a valid BST.
        }
    }

    /** SUBCLASSES _________________________________________________________________________________________________ **/

    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }
}
