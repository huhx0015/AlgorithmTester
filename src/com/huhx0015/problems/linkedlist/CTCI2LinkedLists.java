package com.huhx0015.problems.linkedlist;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Michael Yoon Huh on 3/29/2017.
 */

public class CTCI2LinkedLists {

    /** CTCI : 2.1 SOLUTIONS ___________________________________________________________________ **/

    // 2.1: REMOVE DUPLICATES BY SORTING FIRST (INTEGER) | O(n log n) + O(n)
    public static LinkedList<Integer> removeDupIntegers(LinkedList<Integer> list) {

        // Collections.sort on LinkedList utilizes MergeSort, which is O(n log n):
        // http://stackoverflow.com/questions/32334319/why-does-collections-sort-use-mergesort-but-arrays-sort-does-not
        Collections.sort(list, null); // Sorts the linked list.

        // Time Complexity: O(n)
        for (int i = 0; i < list.size(); i++) {
            removeDupIntegerHelper(list.get(i), i + 1, list);
            System.out.println("removeDupIntegers(): Element " + i + ": " + list.get(i));
        }
        return list;
    }

    private static void removeDupIntegerHelper(int compare, int index, LinkedList<Integer> list) {
        if (index < list.size()) {
            if (compare == list.get(index)) {
                list.remove(index);
                System.out.println("removeDupIntegerHelper: Duplicate found, removing " + compare);
                removeDupIntegerHelper(compare, index, list);
            }
        }
    }
}
