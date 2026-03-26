package com.huhx0015.algorithmtester.twentytwentysix.problems.trees

import com.huhx0015.algorithmtester.twentytwentysix.problems.trees.BinarySearchTreeInsertion.insert
import com.huhx0015.algorithmtester.twentytwentysix.problems.trees.BinarySearchTreeInsertion.insertIntoBST
import com.huhx0015.algorithmtester.twentytwentysix.trees.BinarySearchTree
import com.huhx0015.algorithmtester.twentytwentysix.trees.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinarySearchTreeInsertionTest {

    @Test
    fun testBinarySearchTreeInsertion() {
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
        assertEquals(true, search1)

        val result2 = insert(root = treeNode1, value = insertValue2)
        val search2 = BinarySearchTree.search(root = result2, target = insertValue2)
        assertEquals(true, search2)

        val result3 = insert(root = treeNode1, value = insertValue3)
        val search3 = BinarySearchTree.search(root = result3, target = insertValue3)
        assertEquals(true, search3)
    }

    @Test
    fun testBinarySearchTreeInsertion2() {
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

        val result1 = insertIntoBST(root = treeNode1, value = insertValue1)
        val search1 = BinarySearchTree.search(root = result1, target = insertValue1)
        assertEquals(true, search1)

        val result2 = insertIntoBST(root = treeNode1, value = insertValue2)
        val search2 = BinarySearchTree.search(root = result2, target = insertValue2)
        assertEquals(true, search2)

        val result3 = insertIntoBST(root = treeNode1, value = insertValue3)
        val search3 = BinarySearchTree.search(root = result3, target = insertValue3)
        assertEquals(true, search3)
    }
}