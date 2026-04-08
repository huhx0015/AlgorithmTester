package com.huhx0015.algorithmtester.twentytwentysix.problems.trees

import com.huhx0015.algorithmtester.twentytwentysix.problems.trees.BinaryTreeLevelOrderTraversal.levelOrder
import com.huhx0015.algorithmtester.twentytwentysix.trees.TreeNode

/**
 * Neetcode.io
 *
 * Problem: Binary Tree Right Side View
 * Difficulty: Medium
 *
 * You are given the root of a binary tree. Return only the values of the nodes that are visible from the right side of
 * the tree, ordered from top to bottom.
 *
 * Example 1:
 * Input: root = [1,2,3,null,4,null,5]
 * Output: [1,3,5]
 *
 * Example 2:
 * Input: root = [1,2,3,4,null,null,null,5]
 * Output: [1,3,4,5]
 *
 * Example 3:
 * Input: root = [1,null,2]
 * Output: [1,2]
 *
 * Example 4:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 * 0 <= number of nodes in the tree <= 100
 * -100 <= Node.val <= 100
 */
object BinaryTreeRightSideView {

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

        val result = rightSideView(root = treeNode1)
        println("Right Side View: Result was ${result.toList()}")
    }

    fun rightSideView(root: TreeNode?): List<Int> {
        val queue: ArrayDeque<TreeNode> = ArrayDeque() // Queue used to store the nodes as we traverse the tree.

        // Used to store only the values of the nodes on the right side view of the tree.
        val rightSideViewTraversalList: MutableList<Int> = mutableListOf()

        // Checks if the root is null first, if it is null, there are no nodes on the right side of the tree, so an
        // empty list is returned.
        if (root == null) {
            println("Right Side View: Root was null, returning empty list.")
            return rightSideViewTraversalList
        } else {
            println("Right Side View: Adding root with value ${root.value} to the queue.")
            queue.add(root) // Adds the root to the queue.
        }

        // Loops through the queue while not empty to perform the tree level traversal.
        while (queue.isNotEmpty()) {
            val levelLength = queue.size // Determines the level length from the size of the queue.
            println("Right Side View: WHILE: Current level length is: $levelLength")

            // Iterates through all nodes in this level to find the right side of the tree.
            for (i in 0 until levelLength) {
                val currentNode = queue.removeFirst() // Removes the first node from the queue.

                // If it is the last node in this level, it's the rightmost node.
                if (i == levelLength - 1) {
                    println("Right Side View: FOR: Found the rightmost node: ${currentNode.value}")
                    rightSideViewTraversalList.add(currentNode.value)
                }

                // Checks the left node of the current node, if it exists, it is added to the queue.
                currentNode.left?.let { node ->
                    println("Right Side View: FOR: Current node has existing left child node with value ${node.value}, adding to queue.")
                    queue.add(node)
                }

                // Checks the right node of the current node, if it exists, it is added to the queue.
                currentNode.right?.let { node ->
                    println("Right Side View: FOR: Current node has existing right child node with value ${node.value}, adding to queue.")
                    queue.add(node)
                }
            }
        }

        return rightSideViewTraversalList
    }
}