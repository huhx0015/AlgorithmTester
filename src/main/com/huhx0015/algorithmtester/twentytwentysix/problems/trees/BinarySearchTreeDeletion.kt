package com.huhx0015.algorithmtester.twentytwentysix.problems.trees

import com.huhx0015.algorithmtester.twentytwentysix.trees.TreeNode

object BinarySearchTreeDeletion {

    // remove(): Remove a node and return the root of the BST.
    // Time Complexity: BALANCED: O(log n) | UNBALANCED: O(n)
    fun remove(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) {
            return null
        }
        if (`val` > root.`val`) {
            root.right = remove(root.right, `val`)
        } else if (`val` < root.`val`) {
            root.left = remove(root.left, `val`)
        } else {
            if (root.left == null) {
                return root.right
            } else if (root.right == null) {
                return root.left
            } else {
                val minNode = minValueNode(root.right)
                root.`val` = minNode!!.`val`
                root.right = remove(root.right, minNode.`val`)
            }
        }
        return root
    }

    // minValueNode(): Return the minimum value node of the BST.
    fun minValueNode(root: TreeNode?): TreeNode? {
        var curr = root
        while (curr != null && curr.left != null) {
            curr = curr.left
        }
        return curr
    }

}