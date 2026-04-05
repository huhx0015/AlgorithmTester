package com.huhx0015.algorithmtester.twentytwentysix.problems.trees

import com.huhx0015.algorithmtester.twentytwentysix.trees.TreeNode

/**
 * Neetcode.io
 *
 * Problem: Construct Binary Tree from Preorder and Inorder Traversal
 * Difficulty: Medium
 *
 * You are given two integer arrays preorder and inorder.
 *
 * preorder is the preorder traversal of a binary tree
 * inorder is the inorder traversal of the same tree
 * Both arrays are of the same size and consist of unique values.
 * Rebuild the binary tree from the preorder and inorder traversals and return its root.
 *
 * Example 1:
 * Input: preorder = [1,2,3,4], inorder = [2,1,3,4]
 * Output: [1,2,3,null,null,null,4]
 *
 * Example 2:
 * Input: preorder = [1], inorder = [1]
 * Output: [1]
 *
 * Constraints:
 *
 * 1 <= inorder.length <= 1000.
 * inorder.length == preorder.length
 * -1000 <= preorder[i], inorder[i] <= 1000
 */
object ConstructBinaryTreePreorderInorderTraversal {

    @JvmStatic fun main(args: Array<String>) {
        val inputPreorder1 = intArrayOf(1, 2, 3, 4)
        val inputInorder1 = intArrayOf(2, 1, 3, 4)
        val inputPreorder2 = intArrayOf(1)
        val inputInorder2 = intArrayOf(1)

        val result1 = buildTree(preorder = inputPreorder1, inorder = inputInorder1)
        val result2 = buildTree(preorder = inputPreorder2, inorder = inputInorder2)

        println("Build Tree: Value of the root node for result: ${result1?.value}\n")
        println("Build Tree: Value of the root node for result: ${result2?.value}")
    }

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        // Base case:
        // If either array is empty, there is no tree/subtree to build → return null.
        if (preorder.isEmpty() || inorder.isEmpty()) {
            println("Build Tree: Returning null, preorder or inorder array was empty: preorder size: ${preorder.size} | inorder size: ${inorder.size}")
            return null
        }

        // The first element in preorder is ALWAYS the root of the current subtree.
        val rootValue = preorder[0]

        // Create the root node using that value.
        val root = TreeNode(rootValue)

        // Find the index of the root in inorder array.
        // This splits inorder into:
        // [left subtree | root | right subtree]
        val mid = inorder.indexOf(rootValue)

        // Recursively build the LEFT subtree.
        root.left = buildTree(
            // In preorder:
            // Skip the first element (root), then take the next 'mid' elements
            // These correspond to the left subtree.
            preorder.slice(1..mid).toIntArray(),

            // In inorder:
            // Everything BEFORE the root index is the left subtree.
            inorder.slice(0 until mid).toIntArray()
        )

        // Recursively build the RIGHT subtree.
        root.right = buildTree(
            // In preorder:
            // After root + left subtree, the remaining elements are the right subtree.
            preorder.slice(mid + 1 until preorder.size).toIntArray(),

            // In inorder:
            // Everything AFTER the root index is the right subtree.
            inorder.slice(mid + 1 until inorder.size).toIntArray()
        )

        // Return the constructed root node.
        println("Build Tree: Returning root node with value ${root.value}")
        return root
    }
}