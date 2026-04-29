package com.huhx0015.algorithmtester.twentytwentysix.problems.trees

import com.huhx0015.algorithmtester.twentytwentysix.problems.trees.InvertBinaryTree.TreeNode
import com.huhx0015.algorithmtester.twentytwentysix.problems.trees.InvertBinaryTree.invertTree
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class InvertBinaryTreeTest {

    @Test
    fun testInvertBinaryTree() {
        val treeNode1 = TreeNode(1)
        val treeNode2 = TreeNode(2)
        val treeNode3 = TreeNode(3)
        val treeNode4 = TreeNode(4)
        val treeNode5 = TreeNode(5)
        val treeNode6 = TreeNode(6)
        val treeNode7 = TreeNode(7)

        treeNode1.left = treeNode2
        treeNode1.right = treeNode3
        treeNode2.left = treeNode4
        treeNode2.right = treeNode5
        treeNode3.left = treeNode6
        treeNode3.right = treeNode7

        val result = invertTree(root = treeNode1)

        assertEquals(1, result?.`val`)
        assertEquals(3, result?.left?.`val`)
        assertEquals(2, result?.right?.`val`)
        assertEquals(7, result?.left?.left?.`val`)
        assertEquals(6, result?.left?.right?.`val`)
        assertEquals(5, result?.right?.left?.`val`)
        assertEquals(4, result?.right?.right?.`val`)
    }

    @Test
    fun testInvertBinaryTreeWithNullRoot() {
        val result = invertTree(root = null)
        assertNull(result)
    }
}
