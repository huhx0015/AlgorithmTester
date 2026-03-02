package com.huhx0015.algorithmtester.twentytwentysix.datastructures

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SinglyLinkedListTest {

    private val list: SinglyLinkedList = SinglyLinkedList()

    @Test
    fun testSinglyLinkedList() {
        val testNodeValue1 = 70
        list.insertHead(testNodeValue1)
        assertEquals(testNodeValue1, list.get(0))

        val testNodeValue2 = 64
        list.insertTail(testNodeValue2)
        assertEquals(testNodeValue2, list.tail?.value)

        val testNodeValue3 = 128
        list.insertHead(testNodeValue3)
        assertEquals(testNodeValue3, list.get(0))
        assertEquals(testNodeValue2, list.get(2))
        assertEquals(testNodeValue1, list.get(1))

        list.remove(0)
        assertEquals(testNodeValue2, list.get(1))
        assertEquals(testNodeValue1, list.get(0))

        list.remove(1)
        assertEquals(testNodeValue1, list.get(0))

        list.remove(0)
        assertEquals(-1, list.head.value)
    }
}