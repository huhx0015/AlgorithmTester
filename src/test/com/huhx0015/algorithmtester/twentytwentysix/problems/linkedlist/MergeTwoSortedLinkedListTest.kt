package com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist

import com.huhx0015.algorithmtester.twentytwentysix.datastructures.SinglyLinkedList.ListNode
import com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist.MergeTwoSortedLinkedList.mergeTwoLists
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MergeTwoSortedLinkedListTest {

    @Test
    fun testMergeTwoSortedLinkedList() {
        val inputLinkedList1 = ListNode(value = 1,
            next = ListNode(value = 2,
                next = ListNode(value = 4,
                    next = null
                )
            )
        )
        val inputLinkedList2 = ListNode(value = 1,
            next = ListNode(value = 3,
                next = ListNode(value = 5,
                    next = null
                )
            )
        )
        val mergedSortedList1 = mergeTwoLists(inputLinkedList1, inputLinkedList2)
        assertEquals(1, mergedSortedList1?.value)
    }
}