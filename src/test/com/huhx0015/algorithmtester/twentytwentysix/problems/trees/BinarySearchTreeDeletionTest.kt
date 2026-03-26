package com.huhx0015.algorithmtester.twentytwentysix.problems.trees

import com.huhx0015.algorithmtester.twentytwentysix.problems.trees.BinarySearchTreeDeletion.deleteNode
import com.huhx0015.algorithmtester.twentytwentysix.problems.trees.BinarySearchTreeDeletion.remove
import com.huhx0015.algorithmtester.twentytwentysix.trees.BinarySearchTree
import com.huhx0015.algorithmtester.twentytwentysix.trees.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinarySearchTreeDeletionTest {

    @Test
    fun testBinarySearchTreeDeletion() {
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
        assertEquals(false, search1)

        val result2 = remove(root = treeNode1, value = removeValue2)
        val search2 = BinarySearchTree.search(root = result2, target = removeValue2)
        assertEquals(false, search2)

        val result3 = remove(root = treeNode1, value = removeValue3)
        val search3 = BinarySearchTree.search(root = result3, target = removeValue3)
        assertEquals(false, search3)
    }

    @Test
    fun testBinarySearchTreeDeleteNode() {
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

        val result1 = deleteNode(root = treeNode1, key = removeValue1)
        val search1 = BinarySearchTree.search(root = result1, target = removeValue1)
        assertEquals(false, search1)

        val result2 = deleteNode(root = treeNode1, key = removeValue2)
        val search2 = BinarySearchTree.search(root = result2, target = removeValue2)
        assertEquals(false, search2)

        val result3 = deleteNode(root = treeNode1, key = removeValue3)
        val search3 = BinarySearchTree.search(root = result3, target = removeValue3)
        assertEquals(false, search3)
    }
}