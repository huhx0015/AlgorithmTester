package com.huhx0015.algorithmtester.twentytwentysix.problems.trees

import com.huhx0015.algorithmtester.twentytwentysix.trees.TreeNode

object BinarySearchTreeInsertion {

    // insert(): Insert a new node and return the root of the BST.
    // Time Complexity: Balanced: O(log n)
    fun insert(root: TreeNode?, `val`: Int): TreeNode {

        // If the current node is null, we return a new node with the value val.
        if (root == null) {
            return TreeNode(`val`)
        }

        // If the value is greater than the current node, we recursively call the function with the right child of the
        // current node.
        // If the value is less than the current node, we recursively call the function with the left child of the current
        // node.
        if (`val` > root.`val`) {
            root.right = insert(root.right, `val`)
        } else if (`val` < root.`val`) {
            root.left = insert(root.left, `val`)
        }
        return root // We return the current node after the recursive call.
    }
}