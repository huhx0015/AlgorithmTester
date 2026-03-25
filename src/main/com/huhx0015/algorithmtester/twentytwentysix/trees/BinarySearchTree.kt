package com.huhx0015.algorithmtester.twentytwentysix.trees

object BinarySearchTree {

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

        val result1 = search(treeNode1, 1)
        println("Binary Search Tree: Searched tree, result was: $result1\n")

        val result2 = search(treeNode1, 2)
        println("Binary Search Tree: Searched tree, result was: $result2\n")

        val result3 = search(treeNode1, 10)
        println("Binary Search Tree: Searched tree, result was: $result3\n")
    }

    // search(): Time Complexity: BALANCED: O(log n) | UNBALANCED: O(h) where h is the height of the tree.
    fun search(root: TreeNode?, target: Int): Boolean {
        // If we reach a null node, we return false because the target does not exist in the current tree.
        if (root == null) {
            println("Binary Search Tree: Target $target was not found.")
            return false
        }

        println("Binary Search Tree: Visited ${root.value}.")

        return when {
            // If the target is greater than the current node, we search the right subtree.
            target > root.value -> search(root.right, target)

            // If the target is less than the current node, we search the left subtree.
            target < root.value -> search(root.left, target)

            // If the target is equal to the current node, we return true.
            else -> {
                println("Binary Search Tree: Target $target was found at ${root.value}")
                true
            }
        }
    }
}