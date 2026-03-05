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
        assertEquals(testHeadNodeValue2, testLinkedList.head.next?.value)
    }

    @Test
    fun testDoublyLinkedListInsertEnd() {
        val testLinkedList = DoublyLinkedList()
        val testTailNodeValue1 = 128
        testLinkedList.insertEnd(testTailNodeValue1)
        assertEquals(testTailNodeValue1, testLinkedList.tail.prev?.value)

        val testTailNodeValue2 = 256
        testLinkedList.insertEnd(testTailNodeValue2)
        assertEquals(testTailNodeValue2, testLinkedList.tail.prev?.value)
    }

    @Test
    fun testDoublyLinkedListRemoveFront() {
        val testLinkedList = DoublyLinkedList()
        val testHeadNodeValue1 = 44
        testLinkedList.insertFront(testHeadNodeValue1)
        assertEquals(testHeadNodeValue1, testLinkedList.head.next?.value)

        val testHeadNodeValue2 = 88
        testLinkedList.insertFront(testHeadNodeValue2)
        assertEquals(testHeadNodeValue2, testLinkedList.head.next?.value)

        testLinkedList.removeFront()
        assertEquals(testHeadNodeValue1, testLinkedList.head.next?.value)
    }

    @Test
    fun testDoublyLinkedListRemoveEnd() {
        val testLinkedList = DoublyLinkedList()
        val testTailNodeValue1 = 72
        testLinkedList.insertEnd(testTailNodeValue1)
        assertEquals(testTailNodeValue1, testLinkedList.tail.prev?.value)

        val testTailNodeValue2 = 144
        testLinkedList.insertEnd(testTailNodeValue2)
        assertEquals(testTailNodeValue2, testLinkedList.tail.prev?.value)

        testLinkedList.removeEnd()
        assertEquals(testTailNodeValue1, testLinkedList.head.next?.value)
    }
}