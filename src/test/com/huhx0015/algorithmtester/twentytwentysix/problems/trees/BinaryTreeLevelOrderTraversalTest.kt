package com.huhx0015.algorithmtester.twentytwentysix.problems.trees

import com.huhx0015.algorithmtester.twentytwentysix.problems.trees.BinaryTreeLevelOrderTraversal.levelOrder
import com.huhx0015.algorithmtester.twentytwentysix.trees.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreeLevelOrderTraversalTest {

    @Test
    fun testBinaryTreeLevelOrderTraversalTest() {
        val treeNode1 = TreeNode(3)
        val treeNode2 = TreeNode(1)
        val treeNode3 = TreeNode(5)
        val treeNode4 = TreeNode(7)
        val treeNode5 = TreeNode(10)

        treeNode1.left = treeNode2
        treeNode1.right = treeNode3
        treeNode3.left = treeNode4
        treeNode3.right = treeNode5

        val result = levelOrder(root = treeNode1)
        assertEquals(listOf(listOf(3), listOf(1, 5), listOf(7, 10)), result)
    }
}