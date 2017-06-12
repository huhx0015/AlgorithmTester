package test.com.huhx0015.algorithmtester.algorithms

import main.com.huhx0015.algorithmtester.datastructures.Node
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import main.com.huhx0015.algorithmtester.algorithms.BinaryTreeTraversal.inOrderTraversal
import main.com.huhx0015.algorithmtester.algorithms.BinaryTreeTraversal.postOrderTraversal
import main.com.huhx0015.algorithmtester.algorithms.BinaryTreeTraversal.preOrderTraversal

/**
 * Created by Michael Yoon Huh on 6/9/2017.
 */
internal class BinaryTreeTraversalTest {

    private var mTestNode: Node? = null

    @BeforeEach
    fun initTestNode() {
        mTestNode = Node(8)
        val node1 = Node(1)
        val node2 = Node(3)
        val node3 = Node(5)
        val node4 = Node(7)
        val node5 = Node(10)
        val node6 = Node(12)
        val node7 = Node(15)
        val node8 = Node(20)

        // LEFT SIDE
        mTestNode!!.left = node3
        node3.left = node2
        node3.right = node4
        node2.left = node1

        // RIGHT SIDE
        mTestNode!!.right = node6
        node6.left = node5
        node6.right = node7
        node7.right = node8
    }

    @Test
    fun testInOrderTraversal() {
        inOrderTraversal(mTestNode)
    }

    @Test
    fun testPreOrderTraversal() {
        preOrderTraversal(mTestNode)
    }

    @Test
    fun testPostOrderTraversal() {
        postOrderTraversal(mTestNode)
    }
}