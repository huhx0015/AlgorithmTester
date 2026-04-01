package com.huhx0015.algorithmtester.twentytwentysix.trees

import com.huhx0015.algorithmtester.twentytwentysix.problems.trees.KthSmallestIntegerBST.kthSmallest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthSmallestIntegerBSTTest {

    @Test
    fun testKthSmallestIntegerBST() {
        val treeNode1 = TreeNode(3)
        val treeNode2 = TreeNode(1)
        val treeNode3 = TreeNode(5)
        val treeNode4 = TreeNode(7)
        val treeNode5 = TreeNode(10)

        treeNode1.left = treeNode2
        treeNode1.right = treeNode3
        treeNode3.left = treeNode4
        treeNode3.right = treeNode5

        val result1 = kthSmallest(treeNode1, k = 1)
        val result2 = kthSmallest(treeNode1, k = 2)
        val result3 = kthSmallest(treeNode1, k = 3)
        val result4 = kthSmallest(treeNode1, k = 5)

        assertEquals(1, result1)
        assertEquals(3, result2)
        assertEquals(7, result3)
        assertEquals(10, result4)
    }
}