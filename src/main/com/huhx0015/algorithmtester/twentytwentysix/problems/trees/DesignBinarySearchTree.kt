package com.huhx0015.algorithmtester.twentytwentysix.problems.trees

/**
 * Neetcode.io
 *
 * Problem: Design Binary Search Tree
 * Difficulty: Medium
 * Design a Binary Search Tree class.
 *
 * You will design a Tree Map, which maps an integer key to an integer value. Your Tree class should support the following operations:
 *
 * TreeMap() will initialize an binary search tree map.
 * void insert(int key, int val) will map the key to the value and insert it into the tree.
 * int get(int key) will return the value mapped with the key. If the key is not present in the tree, return -1.
 * int getMin() will return the value mapped to the smallest key in the tree. If the tree is empty, return -1.
 * int getMax() will return the value mapped to the largest key in the tree. If the tree is empty, return -1.
 * void remove(int key) will remove the key-value pair with the given key from the tree.
 * int[] getInorderKeys() will return an array of the keys in the tree in ascending order.
 * Note:
 *
 * The tree should be ordered by the keys.
 * The tree should not contain duplicate keys. If the key is already present in the tree, the original key-value pair should be overridden with the new key-value pair.
 *
 * Example 1:
 * Input:
 * ["insert", 1, 2, "get", 1, "insert", 4, 0, "getMin", "getMax"]
 *
 * Output:
 * [null, 2, null, 2, 0]
 *
 * Example 2:
 * Input:
 * ["insert", 1, 2, "insert", 4, 2, "insert", 3, 7, "insert", 2, 1, "getInorderKeys", "remove", 1, "getInorderKeys"]
 *
 * Output:
 * [null, null, null, null, [1, 2, 3, 4], null, [2, 3, 4]]
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * Patterns Used:
 *
 * 1. Binary Search Tree traversal
 * This is the core pattern. For insert, get, and remove, each comparison decides whether to go left or right.
 *
 * 2. Iterative traversal
 * Used in:
 *
 * insert
 * get
 * findMin
 * getMax
 *
 * These functions walk down the tree with a loop.
 *
 * 3. Recursive DFS
 * Used in:
 *
 * removeHelper
 * inorderTraversal
 *
 * This is Depth-First Search, because it recursively explores one subtree before the other.
 *
 * 4. Inorder traversal
 * Used in:
 *
 * getInorderKeys
 *
 * This is a DFS traversal order: Left → Node → Right.
 * In a BST, inorder traversal returns keys in sorted ascending order.
 *
 * 5. Inorder successor replacement
 * Used in deletion when a node has two children:
 *
 * find the smallest node in the right subtree
 * copy it into the current node
 * remove the duplicate from the right subtree
 *
 * That is a standard BST deletion technique.
 * 
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * Time complexity
 *
 * Let h = height of the tree, and n = number of nodes.
 *
 * In a balanced BST, h = O(log n)
 * In a skewed BST, h = O(n)
 *
 * insert(key, value)
 * Average / balanced: O(log n)
 * Worst case: O(n)
 * get(key)
 * Average / balanced: O(log n)
 * Worst case: O(n)
 * getMin()
 * Calls findMin(root), walks left
 * Average / balanced: O(log n)
 * Worst case: O(n)
 * findMin(node)
 * Average / balanced: O(log n)
 * Worst case: O(n)
 * getMax()
 * Walks right
 * Average / balanced: O(log n)
 * Worst case: O(n)
 * remove(key)
 * Searches for node, may also find successor
 * Average / balanced: O(log n)
 * Worst case: O(n)
 * getInorderKeys()
 * Visits every node exactly once
 * O(n)
 * Space complexity
 * insert, get, findMin, getMax, getMin
 *
 * These are iterative.
 *
 * Auxiliary space: O(1)
 * remove
 *
 * Recursive.
 *
 * Balanced tree: O(log n) call stack
 * Worst case: O(n) call stack
 * getInorderKeys
 * Result list stores all keys: O(n)
 * Recursion stack:
 * Balanced: O(log n)
 * Worst case: O(n)
 *
 * So total auxiliary space is:
 *
 * O(n) overall because the result list dominates
 */
class DesignBinarySearchTree {

    // Binary Search Tree Node
    // Each node stores:
    // - key: used for ordering within the BST
    // - value: the value associated with the key
    // - left: pointer to left child (contains smaller keys)
    // - right: pointer to right child (contains larger keys)
    class TreeNode(var key: Int, var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    // Root node of the BST.
    // If root is null, the tree is empty.
    private var root: TreeNode? = null

    // Inserts a key-value pair into the BST.
    // If the key already exists, update its value instead.
    fun insert(key: Int, value: Int) {
        // Create a new node that may be inserted into the tree.
        val newNode = TreeNode(key, value)

        // If the tree is empty, make the new node the root.
        if (root == null) {
            root = newNode
            return
        }

        // Start traversal from the root.
        var current = root

        // Iteratively search for the correct insertion position.
        while (true) {
            // If the new key is smaller, go left.
            if (key < current!!.key) {
                // If left child is empty, insert here.
                if (current.left == null) {
                    current.left = newNode
                    return
                }
                // Otherwise continue searching down the left subtree.
                current = current.left

                // If the new key is larger, go right.
            } else if (key > current.key) {
                // If right child is empty, insert here.
                if (current.right == null) {
                    current.right = newNode
                    return
                }
                // Otherwise continue searching down the right subtree.
                current = current.right

                // If the key already exists, update the value.
            } else {
                current.value = value
                return
            }
        }
    }

    // Retrieves the value for the given key.
    // Returns -1 if the key does not exist.
    fun get(key: Int): Int {
        // Start from the root.
        var current = root

        // Traverse until either:
        // - we find the key
        // - we reach null (key not found)
        while (current != null) {
            current = if (key < current.key) {
                // Target key is smaller, search left subtree.
                current.left
            } else if (key > current.key) {
                // Target key is larger, search right subtree.
                current.right
            } else {
                // Found the key, return its value.
                return current.value
            }
        }

        // Key was not found.
        return -1
    }

    // Returns the value associated with the smallest key in the tree.
    // Returns -1 if the tree is empty.
    fun getMin(): Int {
        // Find the leftmost node starting from root.
        val current = findMin(root)
        return current?.value ?: -1
    }

    // Helper function to find the node with the minimum key
    // in a subtree rooted at 'node'.
    private fun findMin(node: TreeNode?): TreeNode? {
        var current = node

        // Keep moving left until there is no more left child.
        // The leftmost node has the smallest key.
        while (current != null && current.left != null) {
            current = current.left
        }

        return current
    }

    // Returns the value associated with the largest key in the tree.
    // Returns -1 if the tree is empty.
    fun getMax(): Int {
        // Start from the root.
        var current = root

        // Keep moving right until there is no more right child.
        // The rightmost node has the largest key.
        while (current != null && current.right != null) {
            current = current.right
        }

        return current?.value ?: -1
    }

    // Removes a node by key from the BST.
    fun remove(key: Int) {
        // Reassign root because deleting the root itself may change the tree's root.
        root = removeHelper(root, key)
    }

    // Recursive helper for deletion.
    // Returns the new root of the subtree after deletion.
    private fun removeHelper(curr: TreeNode?, key: Int): TreeNode? {
        // Base case: key not found in tree/subtree.
        if (curr == null) {
            return null
        }

        // If target key is larger, search in the right subtree.
        if (key > curr.key) {
            curr.right = removeHelper(curr.right, key)

            // If target key is smaller, search in the left subtree.
        } else if (key < curr.key) {
            curr.left = removeHelper(curr.left, key)

            // Found the node to delete.
        } else {
            // Case 1: node has no left child.
            // Replace node with its right child.
            if (curr.left == null) {
                return curr.right

                // Case 2: node has no right child.
                // Replace node with its left child.
            } else if (curr.right == null) {
                return curr.left

                // Case 3: node has two children.
            } else {
                // Find the inorder successor:
                // the smallest node in the right subtree.
                val minNode = findMin(curr.right)!!

                // Copy successor's key and value into current node.
                curr.key = minNode.key
                curr.value = minNode.value

                // Remove the duplicate successor node from the right subtree.
                curr.right = removeHelper(curr.right, minNode.key)
            }
        }

        // Return the updated subtree root.
        return curr
    }

    // Returns all keys in sorted order.
    fun getInorderKeys(): List<Int> {
        val result = mutableListOf<Int>()

        // Inorder traversal of a BST gives sorted keys.
        inorderTraversal(root, result)

        return result
    }

    // Recursive inorder traversal:
    // Left -> Node -> Right
    private fun inorderTraversal(root: TreeNode?, result: MutableList<Int>) {
        if (root != null) {
            // Traverse left subtree first.
            inorderTraversal(root.left, result)

            // Visit current node.
            result.add(root.key)

            // Traverse right subtree last.
            inorderTraversal(root.right, result)
        }
    }
}