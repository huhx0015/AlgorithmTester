package com.huhx0015.algorithmtester.twentytwentysix.datastructures

/**
 * Neetcode.io
 *
 * Problem: Design Dynamic Array (Resizable Array)
 * Difficulty: Easy
 *
 * Design a Dynamic Array (aka a resizable array) class, such as an ArrayList in Java or a vector in C++.
 *
 * Your DynamicArray class should support the following operations:
 *
 * DynamicArray(int capacity) will initialize an empty array with a capacity of capacity, where capacity > 0.
 * int get(int i) will return the element at index i. Assume that index i is valid.
 * void set(int i, int n) will set the element at index i to n. Assume that index i is valid.
 * void pushback(int n) will push the element n to the end of the array.
 * int popback() will pop and return the element at the end of the array. Assume that the array is non-empty.
 * void resize() will double the capacity of the array.
 * int getSize() will return the number of elements in the array.
 * int getCapacity() will return the capacity of the array.
 * If we call void pushback(int n) but the array is full, we should resize the array first.
 *
 * Example 1:
 *
 * Input:
 * ["Array", 1, "getSize", "getCapacity"]
 *
 * Output:
 * [null, 0, 1]
 * Example 2:
 *
 * Input:
 * ["Array", 1, "pushback", 1, "getCapacity", "pushback", 2, "getCapacity"]
 *
 * Output:
 * [null, null, 1, null, 2]
 * Example 3:
 *
 * Input:
 * ["Array", 1, "getSize", "getCapacity", "pushback", 1, "getSize", "getCapacity", "pushback", 2, "getSize", "getCapacity", "get", 1, "set", 1, 3, "get", 1, "popback", "getSize", "getCapacity"]
 *
 * Output:
 * [null, 0, 1, null, 1, 1, null, 2, 2, 2, null, 3, 3, 1, 2]
 * Note:
 *
 * The index i provided to get(int i) and set(int i) is guaranteed to be greater than or equal to 0 and less than the number of elements in the array.
 *
 * Time Complexity: O(n)
 *
 * Operation	Big-O Time	Notes
 * Access: O(1)
 * Insertion: O(1) | O(n) if insertion in the middle since shifting will be required
 * Deletion: O(1) | O(n) if deletion in the middle since shifting will be required
 */
class DynamicArray(capacity: Int) {

    private var array: IntArray // Store this array
    private var arrayCapacity: Int // Capacity (number of elements that can fit in the array)
    private var arrayLength: Int = 0 // Size (number of elements) in the array

    init {
        array = IntArray(capacity)
        arrayCapacity = capacity
    }

    // get(): Gets the value at position i in array.
    fun get(i: Int): Int {
        return array[i]
    }

    // set(): Updates the array value at position i with value n.
    fun set(i: Int, n: Int) {
        array[i] = n
    }

    // pushback(): Pushes a new value into the array. If the arrayCapacity is reached, it is resized prior to pushing a new value.
    fun pushback(n: Int) {
        // If the arrayLength equals the current arrayCapacity, the arrayCapacity is doubled with resize().
        if (arrayLength == arrayCapacity) {
            resize()
        }
        array[arrayLength] = n // Pushes the value n into array at position arrayLength.
        arrayLength++ // arrayLength is now incremented
    }

    // popback(): Pops the last value off of the array.
    fun popback(): Int {
        if (arrayLength > 0) {
            arrayLength-- // Decrements the arrayLength, making the last position (unavailable).
        }
        return array[arrayLength]
    }

    // resize(): Resizes the array by doubling its capacity.
    private fun resize() {
        arrayCapacity *= 2 // Doubles the capacity of the array.
        val newArray = IntArray(arrayCapacity) // Create a new array with the doubled capacity.

        // Copy values from old array into newArray.
        array.mapIndexed { index, value ->
            newArray[index] = value
        }
        array = newArray
    }

    // getSize(): Gets the size of the array.
    fun getSize(): Int {
        return arrayLength
    }

    // getCapacity(): Gets the capacity of the array.
    fun getCapacity(): Int {
        return arrayCapacity
    }
}