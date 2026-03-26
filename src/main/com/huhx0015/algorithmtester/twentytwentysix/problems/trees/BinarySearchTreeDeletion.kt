package com.huhx0015.algorithmtester.twentytwentysix.problems.trees

import com.huhx0015.algorithmtester.twentytwentysix.trees.BinarySearchTree
import com.huhx0015.algorithmtester.twentytwentysix.trees.TreeNode

/**
 * Problem: Delete Node in a BST
 * Difficulty: Medium
 *
 * You are given a root node reference of a BST and a key, delete the node with the given key in the BST, if present.
 * Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: There can be multiple results after deleting the node, return any one of them.
 *
 * Example 1:
 * Input: root = [5,3,9,1,4], key = 3
 * Output: [5,4,9,1]
 * Explanation: Another valid answer is:
 *
 * Example 2:
 * Input: root = [5,3,6,null,4,null,10,null,null,7], key = 3
 * Output: [5,4,6,null,null,null,10,7]
 * Constraints:
 *
 * 0 <= The number of nodes in the tree <= 10,000.
 * -100,000 <= key, Node.val <= 100,000
 * All the values Node.val are unique.
 */
object BinarySearchTreeDeletion {

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

        val removeValue1 = 7
        val removeValue2 = 5
        val removeValue3 = 3

        val result1 = remove(root = treeNode1, value = removeValue1)
        val search1 = BinarySearchTree.search(root = result1, target = removeValue1)
        println("Binary Search Tree Result: Removed $removeValue1: ${search1 == false}\n")

        val result2 = remove(root = treeNode1, value = removeValue2)
        val search2 = BinarySearchTree.search(root = result2, target = removeValue2)
        println("Binary Search Tree Result: Removed $removeValue2: ${search2 == false}\n")

        val result3 = remove(root = treeNode1, value = removeValue3)
        val search3 = BinarySearchTree.search(root = result3, target = removeValue3)
        println("Binary Search Tree Result: Removed $removeValue3: ${search3 == false}\n")

        val result4 = deleteNode(root = treeNode1, key = removeValue1)
        val search4 = BinarySearchTree.search(root = result4, target = removeValue1)
        println("Binary Search Tree Result: Removed $removeValue1: ${search4 == false}\n")

        val result5 = deleteNode(root = treeNode1, key = removeValue1)
        val search5 = BinarySearchTree.search(root = result5, target = removeValue1)
        println("Binary Search Tree Result: Removed $removeValue1: ${search5 == false}\n")

        val result6 = deleteNode(root = treeNode1, key = removeValue1)
        val search6 = BinarySearchTree.search(root = result6, target = removeValue1)
        println("Binary Search Tree Result: Removed $removeValue1: ${search6 == false}\n")
    }

    // deleteNode(): Time Complexity: Balanced: O(log n) | Unbalanced: O(n)
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {

        // If root is null, or the key wasn't found in the root TreeNode, null is returned.
        if (root == null) {
            return null
        }

        when {
            // If key is greater than the root.value, we assign root.right and recursively call deleteNode on the right
            // side of the root.
            key > root.value -> {
                root.right = deleteNode(root.right, key)
            }
            // If key is less than the root.value, we assign root.left and recursively call deleteNode on the left side
            // of the root.
            key < root.value -> {
                root.left = deleteNode(root.left, key)
            }
            // Otherwise, the key is equal to the root.value. If the left side of the root is null, we return the right
            // side of the root.
            root.left == null -> {
                return root.right
            }
            // Otherwise, the key is equal to the root.value. If the right side of the root is null, we return the left
            // side of the root.
            root.right == null -> {
                return root.left
            }
            // Otherwise, we perform the removal process at the current node.
            else -> {
                // Need to get the minimum value of the node of the root.
                val minimumValueNode = minValueNode(root.right)
                root.value = minimumValueNode?.value!!
                root.right = deleteNode(root.right, minimumValueNode.value)
            }
        }
        return root
    }

    // remove(): Remove a node and return the root of the BST.
    // Time Complexity: BALANCED: O(log n) | UNBALANCED: O(n)
    fun remove(root: TreeNode?, value: Int): TreeNode? {

        // If the root is null, there is nothing to remove, so we return null. If the value is not found in the tree,
        // `null` will be returned.
        if (root == null) {
            println("Binary Search Tree Removal: Could not remove $value, root was null")
            return null
        }

        // If the value is greater than the current node, we recursively call the function with the right child of the
        // current node.
        // If the value is less than the current node, we recursively call the function with the left child of the current
        // node.
        // Else: This indicates that the `value` was found in the tree.
        if (value > root.value) {
            println("Binary Search Tree Removal: Value $value was greater than root value ${root.value}, recursively calling remove on the right node.")
            root.right = remove(root.right, value)
        } else if (value < root.value) {
            println("Binary Search Tree Removal: Value $value was less than root value ${root.value}, recursively calling remove on the left node.")
            root.left = remove(root.left, value)
        } else {
            println("Binary Search Tree Removal: Value $value was found, $value neither greater or less than the root value ${root.value}")

            // If the root.left or root.right are null, we are at the depth, so we return:
            // Left node is null: Return right node
            // Right node is null: Return left node
            if (root.left == null) {
                println("Binary Search Tree Removal: Root left was null, returning root right.")
                return root.right
            } else if (root.right == null) {
                println("Binary Search Tree Removal: Root right was null, returning root left.")
                return root.left
            } else {
                // Otherwise, we perform the node removal, starting with finding the node with the minimum value of the
                // current root treeNode.
                val minNode = minValueNode(root.right) // Returns the node with the minimum value in the current `root`.
                root.value = minNode!!.value // Sets the current `root` value to be the value of the minNode.value.

                println("Binary Search Tree Removal: Performing the removal process, updated root node with minNode value ${minNode.value}, setting root.right to the result of remove() recursive call on root.right with minNode value ${minNode.value} ")
                root.right = remove(root.right, minNode.value) // Recursively call to the right side of the node.
            }
        }
        println("Binary Search Tree Removal: Finished removal of $value from the root.")
        return root
    }

    // minValueNode(): Return the minimum value node of the BST.
    fun minValueNode(root: TreeNode?): TreeNode? {
        var curr = root

        // Traverses through the left side of the root node side, since all nodes on the left of the root will be lesser
        // in value than the root value.
        while (curr != null && curr.left != null) {
            curr = curr.left
        }
        println("Binary Search Tree Removal: minValueNode(): Found the node with the lowest value with value: ${curr?.value}")
        return curr
    }
}