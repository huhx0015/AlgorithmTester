package com.huhx0015.algorithmtester.twentytwentysix.datastructures

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DoublyLInkedListTest {

    @Test
    fun testDoublyLinkedListInsertFront() {
        val testLinkedList = DoublyLinkedList()
        val testHeadNodeValue1 = 74
        testLinkedList.insertFront(testHeadNodeValue1)
        assertEquals(testHeadNodeValue1, testLinkedList.head.next?.value)

        val testHeadNodeValue2 = 64
        testLinkedList.insertFront(testHeadNodeValue2)
        assertEquals(testHeadNodeValue1, testLinkedList.head.next?.next?.value)
    }

    @Test
    fun testDoublyLinkedListInsertEnd() {

    }

    @Test
    fun testDoublyLinkedListRemoveFront() {

    }

    @Test
    fun testDoublyLinkedListRemoveEnd() {

    }
}