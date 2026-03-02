package com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist

import com.huhx0015.algorithmtester.twentytwentysix.datastructures.SinglyLinkedList.ListNode
import com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist.ReverseLinkedList.reverseList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseLinkedListTest {

    @Test
    fun testReverseLinkedList() {
        val inputLinkedList1 = ListNode(value = 1, next =
            ListNode(value = 2,
                next = ListNode(value = 3,
                    next = ListNode(value = 4,
                        next = null
                    )
                )
            )
        )
        val reversedList1 = reverseList(head = inputLinkedList1)
        assertEquals(1, inputLinkedList1.value)
        assertEquals(4, reversedList1?.value)

        val inputLinkedList2 = ListNode(value = 0,
            next = ListNode(value = 1,
                next = ListNode(value = 2,
                    next = ListNode(value = 3,
                        next = null
                    )
                )
            )
        )
        val reversedList2 = reverseList(head = inputLinkedList2)
        assertEquals(0, inputLinkedList2.value)
        assertEquals(3, reversedList2?.value)

        val inputLinkedList3 = ListNode(value = 64, next = null)
        val reversedList3 = reverseList(head = inputLinkedList3)
        assertEquals(64, inputLinkedList3.value)
        assertEquals(64, reversedList3?.value)
    }
}