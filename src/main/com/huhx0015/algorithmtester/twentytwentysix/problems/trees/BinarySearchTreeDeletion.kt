package com.huhx0015.algorithmtester.twentytwentysix.problems.trees

import com.huhx0015.algorithmtester.twentytwentysix.problems.trees.BinarySearchTreeInsertion.insert
import com.huhx0015.algorithmtester.twentytwentysix.trees.BinarySearchTree
import com.huhx0015.algorithmtester.twentytwentysix.trees.TreeNode

/**
 * Problem: Insert into a Binary Search Tree
 * Difficulty: Medium
 *
 * You are given the root node of a binary search tree (BST) and a value val to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 *
 * Note: There may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 *
 * Example 1:
 * Input: root = [5,3,9,1,4], val = 6
 *
 * Output: [5,3,9,1,4,6]
 * Example 2:
 *
 * Input: root = [5,3,6,null,4,null,10,null,null,7], val = 9
 *
 * Output: [5,3,6,null,4,null,10,null,null,7,null,null,9]
 * Constraints:
 *
 * 0 <= The number of nodes in the tree <= 10,000.
 * -100,000,000 <= val, Node.val <= 100,000,000
 * All the values Node.val are unique.
 * It's guaranteed that val does not exist in the original BST.
 *
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