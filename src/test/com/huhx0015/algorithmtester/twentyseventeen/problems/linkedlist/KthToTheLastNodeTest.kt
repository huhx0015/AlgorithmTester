package com.huhx0015.algorithmtester.twentyseventeen.problems.linkedlist

import com.huhx0015.algorithmtester.twentyseventeen.problems.linkedlist.KthToTheLastNode.LinkedListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

/**
 * Created by Michael Yoon Huh on 6/13/2017.
 */
internal class KthToTheLastNodeTest {

    var rootNode: LinkedListNode? = null

    @BeforeEach
    fun initLinkedList() {
        rootNode = LinkedListNode("Angel Food")
        val firstNode = LinkedListNode("Bundt")
        val secondNode = LinkedListNode("Cheese")
        val thirdNode = LinkedListNode("Devil's Food")
        val fourthNode = LinkedListNode("Eccles")

        rootNode!!.next = firstNode
        firstNode.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = fourthNode
    }

    @Test
    fun testKthToTheLastNode() {
        val node = KthToTheLastNode.kthToLastNode(2, rootNode)
        assertEquals(TEST_KTH_VALUE, node?.value)
    }

    @Test
    fun testKthToTheLastNodeBruteForce() {
        val node = KthToTheLastNode.kthToLastNodeBruteForce(2, rootNode)
        assertEquals(TEST_KTH_VALUE, node?.value)
    }

    companion object {
        private val TEST_KTH_VALUE = "Devil's Food"
    }
}