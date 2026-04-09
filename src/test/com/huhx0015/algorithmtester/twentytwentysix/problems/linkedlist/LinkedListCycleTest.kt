package com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist

import com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist.LinkedListCycle.ListNode
import com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist.LinkedListCycle.hasCycle
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LinkedListCycleTest {

    @Test
    fun testLinkedListCycle() {
        val node1 = ListNode(`val` = 1)
        val node2 = ListNode(`val` = 2)
        val node3 = ListNode(`val` = 3)
        val node4 = ListNode(`val` = 4)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node1

        val result1 = hasCycle(head = node1)
        assertEquals(true, result1)

        node4.next = null
        val result2 = hasCycle(head = node1)
        assertEquals(false, result2)
    }
}