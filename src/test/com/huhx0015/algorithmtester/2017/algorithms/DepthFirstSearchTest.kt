package test.com.huhx0015.algorithmtester.algorithms

import main.com.huhx0015.algorithmtester.algorithms.DepthFirstSearch
import main.com.huhx0015.algorithmtester.datastructures.Node
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * Created by Michael Yoon Huh on 6/9/2017.
 */
internal class DepthFirstSearchTest {

    private var mTestNode: Node? = null

    @BeforeEach
    fun initTestNode() {
        mTestNode = Node("A")
        val b = Node("B")
        val c = Node("C")
        val d = Node("D")
        val e = Node("E")
        val f = Node("F")

        mTestNode!!.adjacent = arrayOf(b, d)
        b.adjacent = arrayOf(c, d)
        c.adjacent = arrayOf(e)
        d.adjacent = arrayOf(f)
    }

    @Test
    fun testSearch() {
        DepthFirstSearch.search(mTestNode)
    }
}