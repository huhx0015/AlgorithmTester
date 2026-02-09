package test.com.huhx0015.algorithmtester.algorithms

import main.com.huhx0015.algorithmtester.datastructures.Node
import org.junit.jupiter.api.Test
import main.com.huhx0015.algorithmtester.algorithms.BinarySearch.arraySearch
import main.com.huhx0015.algorithmtester.algorithms.BinarySearch.nodeSearch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach

/**
 * Created by Michael Yoon Huh on 6/9/2017.
 */
internal class BinarySearchTest {

    private var mTestNode: Node? = null

    companion object {
        private val TEST_ARRAY = intArrayOf(1, 3, 5, 7, 8, 10, 12, 15, 20)
        private val TEST_SEARCH_VALUE = 12
        private val TEST_BAD_VALUE = 9999
        private val TEST_INVALID_POSITION = -1
    }

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
    fun testArraySearch() {
        val resultPosition = arraySearch(TEST_ARRAY, TEST_SEARCH_VALUE, 0, TEST_ARRAY.size - 1)
        assertEquals(TEST_SEARCH_VALUE, TEST_ARRAY[resultPosition])

        val wrongPosition = arraySearch(TEST_ARRAY, TEST_BAD_VALUE, 0, TEST_ARRAY.size - 1)
        assertEquals(TEST_INVALID_POSITION, wrongPosition)
    }

    @Test
    fun testNodeSearch() {
        val resultNode = nodeSearch(mTestNode, TEST_SEARCH_VALUE)
        assertNotNull(resultNode)
        assertEquals(TEST_SEARCH_VALUE, resultNode!!.value)

        val badNode = nodeSearch(mTestNode, TEST_BAD_VALUE)
        assertEquals(null, badNode)
    }
}