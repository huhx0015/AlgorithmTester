package com.huhx0015.algorithmtester.twentytwentysix.problems.sorting

import java.util.TreeMap

object TreeMapSort {

    @JvmStatic fun main(args: Array<String>) {
        val inputIntArray1 = intArrayOf(2, 3, 4, 1, 6)
        val inputIntArray2 = intArrayOf(6, 4, 3, 2, 1)

        println("treeMapSort (IntArray): Original array was ${inputIntArray1.toList()}")
        val resultIntArray1 = treeMapSort(inputIntArray1)
        println("treeMapSort (IntArray): Sorted array is: ${resultIntArray1.toList()}\n")

        println("treeMapSort (IntArray): Original array was ${inputIntArray2.toList()}")
        val resultIntArray2 = treeMapSort(inputIntArray2)
        println("treeMapSort (IntArray): Sorted array is: ${resultIntArray2.toList()}")
    }

    // treeMapSort(): Uses TreeMap structure to store the key to key-count value.
    // Time Complexity: O(n log k + n + k) → O(n log k)
    // Space Complexity: O(k)
    fun treeMapSort(array: IntArray): IntArray {
        if (array.isEmpty()) return array // Early return if array is empty.

        // Use TreeMap to store the key to key-count value. TreeMaps are sorted by key values.
        val valueTreeMap: TreeMap<Int, Int> = TreeMap()

        for (value in array) {
            val valueCount = (valueTreeMap[value] ?: 0) + 1
            valueTreeMap[value] = valueCount
        }

        var arrayPointer = 0
        valueTreeMap.forEach { entry ->
            val valueCount = entry.value

            for (i in 0 until valueCount) {
                array[arrayPointer] = entry.key
                arrayPointer++
            }
        }

        return array
    }
}