package com.huhx0015.algorithmtester.twentytwentysix.trees

import com.huhx0015.algorithmtester.twentytwentysix.trees.BinarySearchTree.search
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinarySearchTreeTest {

    @Test
    fun testBinarySearchTree() {
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
        assertEquals(true, result1)

        val result2 = search(treeNode1, 2)
        assertEquals(false, result2)

        val result3 = search(treeNode1, 10)
        assertEquals(true, result3)
    }
}