package test.com.huhx0015.algorithmtester.problems.trees

import main.com.huhx0015.algorithmtester.problems.trees.ValidBinarySearchTree
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

/**
 * Created by Michael Yoon Huh on 6/13/2017.
 */
internal class ValidBinarySearchTreeTest {

    var testTreeRoot: ValidBinarySearchTree.BinaryTreeNode? = null

    @BeforeEach
    fun initTestTree() {
        testTreeRoot = ValidBinarySearchTree.BinaryTreeNode(5)
        val testTreeNode1 = ValidBinarySearchTree.BinaryTreeNode(3)
        val testTreeNode2 = ValidBinarySearchTree.BinaryTreeNode(2)
        val testTreeNode3 = ValidBinarySearchTree.BinaryTreeNode(4)
        val testTreeNode5 = ValidBinarySearchTree.BinaryTreeNode(8)
        val testTreeNode6 = ValidBinarySearchTree.BinaryTreeNode(6)
        val testTreeNode7 = ValidBinarySearchTree.BinaryTreeNode(9)

        // P: 5 | L: 4 | R: 8
        testTreeRoot!!.left = testTreeNode1
        testTreeRoot!!.right = testTreeNode5

        // P: 3 | L: 2 | R: 4
        testTreeNode1.left = testTreeNode2
        testTreeNode1.right = testTreeNode3

        // P: 8 | L: 6 | R: 9
        testTreeNode5.left = testTreeNode6
        testTreeNode5.right = testTreeNode7
    }

    @Test
    fun isBinarySearchTree() {
        assertEquals(true, ValidBinarySearchTree.validate(testTreeRoot!!))
    }
}