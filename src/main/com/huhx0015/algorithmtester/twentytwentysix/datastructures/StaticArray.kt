package com.huhx0015.algorithmtester.twentytwentysix.datastructures

class StaticArray {

    // Insert n into arr at the next open position.
    // Length is the number of 'real' values in arr, and capacity
    // is the size (aka memory allocated for the fixed size array).
    fun insertEnd(arr: IntArray, n: Int, length: Int, capacity: Int) {
        if (length < capacity) {
            arr[length] = n
        }
    }

    // Remove from the last position in the array if the array
    // is not empty (i.e. length is non-zero).
    fun removeEnd(arr: IntArray, length: Int): Int {
        var len = length
        if (len > 0) {
            // Overwrite last element with some default value.
            // We would also consider the length to be decreased by 1.
            arr[len - 1] = 0
            len--
        }
        return len
    }

    // Insert n into index i after shifting elements to the right.
    // Assuming i is a valid index and arr is not full.
    fun insertMiddle(arr: IntArray, i: Int, n: Int, length: Int) {
        // Shift starting from the end to i.
        for (index in length - 1 downTo i) {
            arr[index + 1] = arr[index]
        }
        // Insert at i
        arr[i] = n
    }

    // Remove value at index i before shifting elements to the left.
    // Assuming i is a valid index.
    fun removeMiddle(arr: IntArray, i: Int, length: Int) {
        // Shift starting from i + 1 to end.
        for (index in i + 1 until length) {
            arr[index - 1] = arr[index]
        }
        // No need to 'remove' arr[i], since we already shifted
    }

    fun printArr(arr: IntArray, length: Int) {
        for (i in 0 until length) {
            print("${arr[i]} ")
        }
        println()
    }
}
