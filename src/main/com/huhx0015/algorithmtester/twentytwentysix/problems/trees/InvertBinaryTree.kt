package com.huhx0015.algorithmtester.twentytwentysix.problems.trees

import com.huhx0015.algorithmtester.twentytwentysix.trees.DepthFirstSearch
import com.huhx0015.algorithmtester.twentytwentysix.trees.TreeNode

/**
 * NeetCode.io
 *
 * Problem: Invert Binary Tree
 * Difficulty: Easy
 *
 * You are given the root of a binary tree root. Invert the binary tree and return its root.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,3,2,7,6,5,4]
 *
 * Example 2:
 * Input: root = [3,2,1]
 * Output: [3,1,2]
 *
 * Example 3:
 * Input: root = []
 *
 * Output: []
 * Constraints:
 *
 * 0 <= The number of nodes in the tree <= 100.
 * -100 <= Node.val <= 100
 */
object InvertBinaryTree {

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

        invertTree(root = treeNode1)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    // invertTree(): Time Complexity: O(n) | Space Complexity: O(n), Worst: O(log n) when balanced tree
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            println("Invert Tree: Root is null")
            return null // Return null if root is empty.
        }

        val rootLeft = root.left
        val rootRight = root.right

        println("Invert Tree: Root value is ${root.`val`}, with root left value ${rootLeft?.`val`} and root right value ${rootRight?.`val`}")

        root.right = rootLeft
        root.left = rootRight

        println("Invert Tree: Swapped root left and right value, root left value is now ${root.left?.`val`} and root right value is now ${root.right?.`val`}")

        invertTree(root.left)
        invertTree(root.right)

        return root
    }
}