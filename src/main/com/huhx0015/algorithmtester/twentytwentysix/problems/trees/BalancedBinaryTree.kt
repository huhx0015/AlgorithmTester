package com.huhx0015.algorithmtester.twentytwentysix.problems.trees

import com.huhx0015.algorithmtester.twentytwentysix.trees.TreeNode
import kotlin.math.abs
import kotlin.math.max

/**
 * NeetCode.io
 *
 * Problem: Balanced Binary Tree
 * Difficulty: Easy
 *
 * Given a binary tree, return true if it is height-balanced and false otherwise.
 *
 * A height-balanced binary tree is defined as a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Example 1:
 * Input: root = [1,2,3,null,null,4]
 * Output: true
 *
 * Example 2:
 * Input: root = [1,2,3,null,null,4,null,5]
 * Output: false
 *
 * Example 3:
 * Input: root = []
 * Output: true
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 1000].
 * -1000 <= Node.val <= 1000
 */
object BalancedBinaryTree {

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

        val result = isBalanced(root = treeNode1)
        println("Balanced Binary Tree: Is tree balanced: $result\n")
    }

    // isBalanced(): Determines if the root TreeNode is balanced.
    // Time Complexity: O(n^2) | Space Complexity: O(h)
    fun isBalanced(root: TreeNode?): Boolean {
        // If the root is empty, we return true.
        if (root == null) {
            println("Balanced Binary Tree: Tree was empty, returning true.")
            return true
        }

        val leftHeightCount = getHeight(root.left)
        println("Balanced Binary Tree: Finished traversing left side, left side height was: $leftHeightCount")

        val rightHeightCount = getHeight(root.right)
        println("Balanced Binary Tree: Finished traversing right side, right side height was: $leftHeightCount")

        val isBalanced = abs(leftHeightCount - rightHeightCount) <= 1

        // Need to recursively call isBalanced to ensure that the left and right sides of the root are also balanced.
        return isBalanced && isBalanced(root.left) && isBalanced(root.right)
    }

    // getHeight(): Returns the height of the node, recursively traverses the left and right sides to determine height.
    fun getHeight(node: TreeNode?): Int {
        if (node == null) {
            println("Balanced Binary Tree: getHeight: Node was null, returning 0")
            return 0
        }

        val left = getHeight(node.left)
        println("Balanced Binary Tree: getHeight: Recursively traversed left, left height was $left")

        val right = getHeight(node.right)
        println("Balanced Binary Tree: getHeight: Recursively traversed left, right height was $right")

        return 1 + max(left, right)
    }
}