package com.huhx0015.algorithmtester.twentytwentysix.problems.trees

import com.huhx0015.algorithmtester.twentytwentysix.trees.TreeNode

/**
 * NeetCode.io
 *
 * Problem: Kth Smallest Integer in BST
 * Difficulty: Medium
 *
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) in the tree.
 *
 * A binary search tree satisfies the following constraints:
 *
 * The left subtree of every node contains only nodes with keys less than the node's key.
 * The right subtree of every node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees are also binary search trees.
 *
 * Example 1:
 * Input: root = [2,1,3], k = 1
 * Output: 1
 *
 *          2
 *      1       3
 *
 * Example 2:
 * Input: root = [4,3,5,2,null], k = 4
 * Output: 5
 *
 *                      4
 *                  3      5
 *              2
 *
 * Constraints:
 *
 * 1 <= k <= The number of nodes in the tree <= 1000.
 * 0 <= Node.val <= 1000
 *
 * Strategy: Think of the array sorted first. Then what is the value at the k position?
 * For example 2, the array input is [4,3,5,2,null] with k = 4. When this is sorted, it is [2,3,4,5], we don't include
 * null in the list.
 * "Kth index" always starts at 1, NOT 0.
 * Perform in-order traversal for this.
 */
object KthSmallestIntegerBST {

    @JvmStatic fun main(args: Array<String>) {
        val treeNode1 = TreeNode(3)
        val treeNode2 = TreeNode(1)
        val treeNode3 = TreeNode(5)
        val treeNode4 = TreeNode(7)
        val treeNode5 = TreeNode(10)

        treeNode1.left = treeNode2
        treeNode1.right = treeNode3
        treeNode3.left = treeNode4
        treeNode3.right = treeNode5

        kthSmallest(treeNode1, k = 1)
        kthSmallest(treeNode1, k = 2)
        kthSmallest(treeNode1, k = 3)
        kthSmallest(treeNode1, k = 5)
    }

    // kthSmallest(): Time Complexity: O(n) | Space Complexity: O(n)
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        if (root == null) return -1 // Returns -1 if root has no nodes.

        // Used to store the sorted list of values in the root NodeTree.
        val sortedList: MutableList<Int> = mutableListOf()
        traverse(root, sortedList)
        println("Kth Smallest: Kth value with k $k is ${sortedList[k - 1]}\n")
        return sortedList[k - 1] // K is 1-indexed, starts at 1, not 0.
    }

    // traverse(): Helper function that performs an in-order traversal.
    fun traverse(node: TreeNode?, sortedList: MutableList<Int>) {
        if (node == null) {
            println("Kth Smallest: traverse: Node was null.")
            return
        }

        // Performs an in-order traversal of the node TreeNode. LEFT -> ROOT -> RIGHT
        traverse(node.left, sortedList) // Traverses the left tree.
        sortedList.add(node.value) // Adds the current value to the sortedList.
        println("Kth Smallest: traverse: Current node value is: ${node.value}")
        traverse(node.right, sortedList) // Traverses the right tree.
    }
}