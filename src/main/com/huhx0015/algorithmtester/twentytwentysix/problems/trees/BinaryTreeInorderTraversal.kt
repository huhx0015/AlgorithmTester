package com.huhx0015.algorithmtester.twentytwentysix.problems.trees

import com.huhx0015.algorithmtester.twentytwentysix.trees.TreeNode

/**
 * Problem: Binary Tree Inorder Traversal
 * Difficulty: Easy
 *
 * You are given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [4,2,5,1,6,3,7]
 *
 * Example 2:
 * Input: root = [1,2,3,null,4,5,null]
 * Output: [2,4,1,5,3]
 * Example 3:
 *
 * Input: root = []
 *
 * Output: []
 * Constraints:
 *
 * 0 <= number of nodes in the tree <= 100
 * -100 <= Node.val <= 100
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
object BinaryTreeInorderTraversal {

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

        val result1 = inorderTraversalRecursive(treeNode1)
        println("Inorder Traversal (Recursive): Traversal order is ${result1.toList()}\n")

        val result2 = inorderTraversalIterative(treeNode1)
        println("Inorder Traversal (Recursive): Traversal order is ${result2.toList()}")
    }

    val orderedList: MutableList<Int> = mutableListOf()

    // inorderTraversalRecursive(): Time Complexity: O(n) | Space Complexity: O(n)
    fun inorderTraversalRecursive(root: TreeNode?): List<Int> {
        if (root == null) {
            println("Inorder Traversal (Recursive): Root was null, returning orderedList.")
            return orderedList
        }

        inorderTraversalRecursive(root.left)

        orderedList.add(root.value)
        println("Inorder Traversal (Recursive): Visited node with root value: ${root.value}")

        inorderTraversalRecursive(root.right)

        println("Inorder Traversal (Recursive): Finished traversing, returning orderedList.")
        return orderedList
    }

    // inorderTraversalIterative(): Iterative approach using a ArrayDeque.
    // Time Complexity: O(n) | Space Complexity: O(n)
    fun inorderTraversalIterative(root: TreeNode?): List<Int> {
        val orderedListIterative = mutableListOf<Int>()
        val stack = ArrayDeque<TreeNode>()
        var current = root

        while (current != null || stack.isNotEmpty()) {

            while (current != null) {
                stack.addLast(current) // Add the current node to the end.
                current = current.left
            }

            current = stack.removeLast()

            orderedListIterative.add(current.value) // Add the current node.
            println("Inorder Traversal (Iterative): Visited node with current value: ${current.value}")

            current = current.right
        }

        println("Inorder Traversal (Iterative): Finished traversing, returning orderedList.")
        return orderedListIterative
    }
}