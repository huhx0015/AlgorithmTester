package com.huhx0015.algorithmtester.twentytwentysix.search

object BinarySearch {

    @JvmStatic fun main(args: Array<String>) {
        val inputIntArray = intArrayOf(1, 2, 3, 4, 23, 50, 78, 3000, 5000)
        val target1 = 23
        val target2 = 3
        val target3 = 77
        val target4 = 3000

        binarySearch(arr = inputIntArray, target = target1)
        binarySearch(arr = inputIntArray, target = target2)
        binarySearch(arr = inputIntArray, target = target3)
        binarySearch(arr = inputIntArray, target = target4)
    }

    // binarySearch(): Standard binary search algorithm.
    // NOTE: Input array must be sorted for this to work correctly!
    fun binarySearch(arr: IntArray, target: Int): Int {
        var left = 0 // Left most pointer, initially set at the start position of the array.
        var right = arr.size - 1 // Right most pointer, initially set at the end position of the array.

        // Loops while `left` value is less than or equal to the `right` value.
        while (left <= right) {
            val mid = (left + right) / 2 // Mid-point value dividing the sum of left and right values.
            println("Binary Search: WHILE: The middle point is now $mid, left pointer is $left, right pointer is $right")

            // If the `target` value is greater than the value at the mid position of the array, updates the left
            // pointer to be `mid` + 1.
            // Otherwise, if the `target` value is less than the value of the mid position of the array, updates
            // the right pointer to be `mid` - 1.
            if (target > arr[mid]) {
                left = mid + 1
                println("Binary Search: WHILE: Target $target is greater than ${arr[mid]} so left pointer is now at position $left")
            } else if (target < arr[mid]) {
                right = mid - 1
                println("Binary Search: WHILE: Target $target is less than ${arr[mid]} so right pointer is now at position $left")
            } else {
                // Returns the position of where the target was found in the array.
                println("Binary Search: The target value $target was found at position $mid\n")
                return mid
            }
        }

        // If -1 is returned, the target value could not be found in the array.
        println("Binary Search: The target value $target was not found in the array\n")
        return -1
    }
}