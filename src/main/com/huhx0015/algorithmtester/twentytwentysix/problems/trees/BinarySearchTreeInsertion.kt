package com.huhx0015.algorithmtester.twentytwentysix.problems.trees

import com.huhx0015.algorithmtester.twentytwentysix.trees.BinarySearchTree
import com.huhx0015.algorithmtester.twentytwentysix.trees.TreeNode

object BinarySearchTreeInsertion {

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

        val insertValue1 = 9
        val insertValue2 = 17
        val insertValue3 = 2

        val result1 = insert(root = treeNode1, value = insertValue1)
        val search1 = BinarySearchTree.search(root = result1, target = insertValue1)
        println("Binary Search Tree Result: Inserted $insertValue1: $search1\n")

        val result2 = insert(root = treeNode1, value = insertValue2)
        val search2 = BinarySearchTree.search(root = result2, target = insertValue2)
        println("Binary Search Tree Result: Inserted $insertValue1: $search2\n")

        val result3 = insert(root = treeNode1, value = insertValue3)
        val search3 = BinarySearchTree.search(root = result3, target = insertValue3)
        println("Binary Search Tree Result: Inserted $insertValue1: $search3\n")
    }

    // insert(): Insert a new node and return the root of the BST.
    // Time Complexity: Balanced: O(log n)
    fun insert(root: TreeNode?, value: Int): TreeNode {

        // If the current node is null, we return a new node with the value val.
        if (root == null) {
            println("Binary Search Tree Insertion: Root was null, returning node with value $value")
            return TreeNode(value)
        }

        // If the value is greater than the current node, we recursively call the function with the right child of the
        // current node.
        // If the value is less than the current node, we recursively call the function with the left child of the current
        // node.
        if (value > root.value) {
            println("Binary Search Tree Insertion: Value $value was greater than the root value ${root.value}, recursively calling insert on root right node.")
            root.right = insert(root.right, value)
        } else if (value < root.value) {
            println("Binary Search Tree Insertion: Value $value was less than the root value ${root.value}, recursively calling insert on root left node.")
            root.left = insert(root.left, value)
        }
        println("Binary Search Tree Insertion: Root with root value $value was inserted, binary search tree insertion completed.")
        return root // We return the current node after the recursive call.
    }
}