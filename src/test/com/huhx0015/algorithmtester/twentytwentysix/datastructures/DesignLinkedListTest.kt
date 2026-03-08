package com.huhx0015.algorithmtester.twentytwentysix.datastructures

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DesignLinkedListTest {

    @Test
    fun testDesignLinkedList() {
        val myLinkedList = MyLinkedList()
        val testValue1 = 1
        val testValue2 = 3
        val testPosition1 = 1
        val testValue3 = 2

        myLinkedList.addAtHead(testValue1)
        myLinkedList.addAtTail(testValue2)
        myLinkedList.addAtIndex(testPosition1, testValue3) // linked list becomes 1->2->3

        Assertions.assertEquals(testValue3, myLinkedList.get(testPosition1)) // return 2
        myLinkedList.deleteAtIndex(testPosition1) // now the linked list is 1->3
        Assertions.assertEquals(testValue2, myLinkedList.get(testPosition1)) // return 3
    }
}