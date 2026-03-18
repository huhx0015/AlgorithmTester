package com.huhx0015.algorithmtester.twentytwentysix.problems.sorting

import com.huhx0015.algorithmtester.twentytwentysix.problems.sorting.MergeKSortedLinkedLists.ListNode
import com.huhx0015.algorithmtester.twentytwentysix.problems.sorting.MergeKSortedLinkedLists.mergeKListsBruteForce
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MergeKSortedLinkedListsTest {
    
    val listNode1 = ListNode(1)
    val listNode2 = ListNode(2)
    val listNode3 = ListNode(4)
    val listNode4 = ListNode(1)
    val listNode5 = ListNode(3)
    val listNode6 = ListNode(5)
    val listNode7 = ListNode(3)
    val listNode8 = ListNode(6)

    @BeforeEach
    fun setup() {
        listNode1.next = listNode2
        listNode2.next = listNode3
        listNode4.next = listNode5
        listNode5.next = listNode6
        listNode7.next = listNode8
    }

    @Test
    fun testMergeKListsBruteForce() {
        val inputArray1: Array<ListNode?> = arrayOf(
            listNode1,
            listNode4,
            listNode7
        )
        val inputArray2: Array<ListNode?> = emptyArray()
        val inputArray3: Array<ListNode?> = arrayOf(null)

        val resultBruteForce1 = mergeKListsBruteForce(inputArray1)
        assertEquals(ListNode(1), resultBruteForce1)

        val resultBruteForce2 = mergeKListsBruteForce(inputArray2)
        assertEquals(null, resultBruteForce2)

        val resultBruteForce3 = mergeKListsBruteForce(inputArray3)
        assertEquals(null, resultBruteForce3)
    }
}