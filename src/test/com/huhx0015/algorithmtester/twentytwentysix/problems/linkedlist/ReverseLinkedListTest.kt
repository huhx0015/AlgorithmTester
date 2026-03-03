package com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist

import com.huhx0015.algorithmtester.twentytwentysix.datastructures.SinglyLinkedList.ListNode
import com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist.ReverseLinkedList.reverseListIterative
import com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist.ReverseLinkedList.reverseListRecursive
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseLinkedListTest {

    @Test
    fun testReverseLinkedListRecursive() {
        val inputLinkedList1 = ListNode(value = 1, next =
            ListNode(value = 2,
                next = ListNode(value = 3,
                    next = ListNode(value = 4,
                        next = null
                    )
                )
            )
        )
        val reversedList1 = reverseListRecursive(head = inputLinkedList1)
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
        val reversedList2 = reverseListRecursive(head = inputLinkedList2)
        assertEquals(0, inputLinkedList2.value)
        assertEquals(3, reversedList2?.value)

        val inputLinkedList3 = ListNode(value = 64, next = null)
        val reversedList3 = reverseListRecursive(head = inputLinkedList3)
        assertEquals(64, inputLinkedList3.value)
        assertEquals(64, reversedList3?.value)
    }

    @Test
    fun testReverseLinkedListIterative() {
        val inputLinkedList1 = ListNode(value = 1, next =
            ListNode(value = 2,
                next = ListNode(value = 3,
                    next = ListNode(value = 4,
                        next = null
                    )
                )
            )
        )
        val reversedList1 = reverseListIterative(head = inputLinkedList1)
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
        val reversedList2 = reverseListIterative(head = inputLinkedList2)
        assertEquals(0, inputLinkedList2.value)
        assertEquals(3, reversedList2?.value)

        val inputLinkedList3 = ListNode(value = 64, next = null)
        val reversedList3 = reverseListRecursive(head = inputLinkedList3)
        assertEquals(64, inputLinkedList3.value)
        assertEquals(64, reversedList3?.value)
    }
}