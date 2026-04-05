package com.huhx0015.algorithmtester.twentytwentysix.problems.trees

import com.huhx0015.algorithmtester.twentytwentysix.problems.trees.ConstructBinaryTreePreorderInorderTraversal.buildTree
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConstructBinaryTreePreorderInorderTraversalTest {

    @Test
    fun testConstructBinaryTreePreorderInorderTraversal() {
        val inputPreorder1 = intArrayOf(1, 2, 3, 4)
        val inputInorder1 = intArrayOf(2, 1, 3, 4)
        val inputPreorder2 = intArrayOf(1)
        val inputInorder2 = intArrayOf(1)
        val result1 = buildTree(preorder = inputPreorder1, inorder = inputInorder1)
        val result2 = buildTree(preorder = inputPreorder2, inorder = inputInorder2)

        assertEquals(1, result1?.value)
        assertEquals(1, result2?.value)
    }
}