package com.huhx0015.algorithmtester.twentyseventeen.problems.linkedlist

import java.util.Collections
import java.util.LinkedList

/**
 * Created by Michael Yoon Huh on 3/29/2017.
 *
 * Cracking the Coding Interview:
 */

object CTCI2LinkedLists {

    /** CTCI : 2.1 SOLUTIONS ___________________________________________________________________  */

    // 2.1: REMOVE DUPLICATES BY SORTING FIRST (INTEGER) | O(n log n) + O(n)
    fun removeDupIntegers(list: LinkedList<Int>): LinkedList<Int> {

        // Collections.sort on LinkedList utilizes MergeSort, which is O(n log n):
        // http://stackoverflow.com/questions/32334319/why-does-collections-sort-use-mergesort-but-arrays-sort-does-not
        Collections.sort(list, null) // Sorts the linked list.

        // Time Complexity: O(n)
        for (i in 0..list.size) {
            if (i < list.size) {
                removeDupIntegerHelper(list[i], i + 1, list)
                println("removeDupIntegers(): Element " + i + ": " + list[i])
            }
        }
        return list
    }

    private fun removeDupIntegerHelper(compare: Int, index: Int, list: LinkedList<Int>) {
        if (index < list.size) {
            if (compare == list[index]) {
                list.removeAt(index)
                println("removeDupIntegerHelper: Duplicate found, removing " + compare)
                removeDupIntegerHelper(compare, index, list)
            }
        }
    }
}
