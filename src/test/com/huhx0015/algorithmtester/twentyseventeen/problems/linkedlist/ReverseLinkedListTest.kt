package com.huhx0015.algorithmtester.twentyseventeen.problems.linkedlist

import com.huhx0015.algorithmtester.twentyseventeen.problems.linkedlist.ReverseLinkedList.LinkedListNode
import com.huhx0015.algorithmtester.twentyseventeen.problems.linkedlist.ReverseLinkedList.printLinkedList
import com.huhx0015.algorithmtester.twentyseventeen.problems.linkedlist.ReverseLinkedList.reverseICMethod
import com.huhx0015.algorithmtester.twentyseventeen.problems.linkedlist.ReverseLinkedList.reverseRecursiveMethod1
import com.huhx0015.algorithmtester.twentyseventeen.problems.linkedlist.ReverseLinkedList.reverseRecursiveMethod2
import com.huhx0015.algorithmtester.twentyseventeen.problems.linkedlist.ReverseLinkedList.reverseRecursiveMethod3
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

/**
 * Created by Michael Yoon Huh on 6/13/2017.
 */
internal class ReverseLinkedListTest {

    var testHeadNode: LinkedListNode? = null

    @BeforeEach
    fun initLinkedList() {
        testHeadNode = LinkedListNode(1)

        val testNode1 = LinkedListNode(2)
        val testNode2 = LinkedListNode(3)
        val testNode3 = LinkedListNode(4)
        val testNode4 = LinkedListNode(5)
        val testNode5 = LinkedListNode(6)

        testHeadNode!!.next = testNode1
        testNode1.next = testNode2
        testNode2.next = testNode3
        testNode3.next = testNode4
        testNode4.next = testNode5
    }

    @Test
    fun testReverseRecursiveMethod1() {
        printLinkedList(reverseRecursiveMethod1(testHeadNode!!, null))
    }

    @Test
    fun testReverseRecursiveMethod2() {
        printLinkedList(reverseRecursiveMethod2(testHeadNode)!!)
    }

    @Test
    fun testReverseRecursiveMethod3() {
        printLinkedList(reverseRecursiveMethod3(testHeadNode, null)!!)
    }

    @Test
    fun testReverseICMethod() {
        printLinkedList(reverseICMethod(testHeadNode!!))
    }
}