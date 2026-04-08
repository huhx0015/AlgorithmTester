package com.huhx0015.algorithmtester.twentytwentysix.problems.trees

import com.huhx0015.algorithmtester.twentytwentysix.problems.trees.BinaryTreeRightSideView.rightSideView
import com.huhx0015.algorithmtester.twentytwentysix.trees.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreeRightSideViewTest {

    @Test
    fun testBinaryTreeRightSideViewTest() {
        val treeNode1 = TreeNode(3)
        val treeNode2 = TreeNode(1)
        val treeNode3 = TreeNode(5)
        val treeNode4 = TreeNode(7)
        val treeNode5 = TreeNode(10)

        treeNode1.left = treeNode2
        treeNode1.right = treeNode3
        treeNode3.left = treeNode4
        treeNode3.right = treeNode5

        val result = rightSideView(root = treeNode1)
        assertEquals(listOf(3, 5, 10), result)
    }
}