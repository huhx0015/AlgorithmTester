package com.huhx0015.algorithmtester.twentytwentysix.problems.trees

import com.huhx0015.algorithmtester.twentytwentysix.trees.TreeNode

/**
 * Neetcode.io
 *
 * Problem: Binary Tree Level Order Traversal
 * Difficulty: Medium
 * Given a binary tree root, return the level order traversal of it as a nested list, where each sublist contains the
 * values of nodes at a particular level in the tree, from left to right.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [[1],[2,3],[4,5,6,7]]
 *
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 *
 * Example 3:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 * 0 <= The number of nodes in the tree <= 1000.
 * -1000 <= Node.val <= 1000
 *
 * Pattern: Breadth First Search
 */
object BinaryTreeLevelOrderTraversal {

    // treeNode1:
    //              3
    //          1       5
    //               7     10
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

        val result = levelOrder(root = treeNode1)
        println("Level Order: Result was ${result.toList()}")
    }

    // levelOrder(): Time Complexity: O(n) | Space Complexity: O(n)
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        // ArrayQueue (double-ended queue) is used to store the traversed results, level by level.
        val queue: ArrayDeque<TreeNode> = ArrayDeque()

        val traversalList: MutableList<List<Int>> = mutableListOf()

        // We add the root node to the queue (if not null), as it is the first level to traverse. If the root node is
        // null, an empty list is returned.
        if (root != null) {
            println("Level Order: Adding root with value ${root.value}")
            queue.add(root)
        } else {
            println("Level Order: Root was empty, returning empty array.")
            return traversalList
        }

        var currentTreeLevel = 0 // Used to track the current tree level.

        // Loops until the queue is empty.
        while (queue.isNotEmpty()) {
            println("Level Order: WHILE: Loop at tree level: $currentTreeLevel")

            val levelLength = queue.size // Determines the size of the queue.
            val levelTraversalList: MutableList<Int> = mutableListOf() // Used to store the list of values in this level.

            // Iterates through all nodes at the current level.
            for (i in 0 until levelLength) {
                val currentNode = queue.removeFirst() // Removes the front node of the queue.
                println("Level Order: FOR: Current node value is: ${currentNode.value}")

                levelTraversalList.add(currentNode.value) // Add the current node to the traversal list.

                // Checks the left node of the current node, if it exists, it is added to the queue.
                currentNode.left?.let { node ->
                    println("Level Order: FOR: Current node has existing left child node with value ${node.value}, adding to queue.")
                    queue.add(node)
                }

                // Checks the right node of the current node, if it exists, it is added to the queue.
                currentNode.right?.let { node ->
                    println("Level Order: FOR: Current node has existing right child node with value ${node.value}, adding to queue.")
                    queue.add(node)
                }

                currentTreeLevel++ // Increments the currentTreeLevel.
            }

            println("Level Order: WHILE: Adding the tree level $currentTreeLevel traversal list: ${levelTraversalList.toList()}")
            traversalList.add(levelTraversalList) // Adds the levelTraversalList to the traversalList.
        }

        return traversalList
    }
}