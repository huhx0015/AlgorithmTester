package com.huhx0015.algorithmtester.twentytwentysix.search

object BinarySearchRange {

    @JvmStatic fun main(args: Array<String>) {
        val low = 1
        val high = 100

        val result = binarySearch(low = low, high = high)
        println("Binary Range: Value was $result")
    }

    // binarySearch(): Binary search on some range of values.
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    fun binarySearch(low: Int, high: Int): Int {
        var lo = low // Lowest value of the range.
        var hi = high // Highest value of the range.

        // Loops while lo is less than or equal to hi.
        while (lo <= hi) {
            val mid = (lo + hi) / 2 // Mid pointer value.

            if (isCorrect(mid) > 0) {
                hi = mid - 1
                println("Binary Range: Value $mid was too large, updating hi $hi")
            } else if (isCorrect(mid) < 0) {
                lo = mid + 1
                println("Binary Range: Value $mid was too small, updating lo $lo")
            } else {
                println("Binary Range: Found the value $mid")
                return mid
            }
        }

        println("Binary Range: Failed to find the value")
        return -1
    }

    // isCorrect(): Return 1 if n is too big, -1 if too small, 0 if correct.
    fun isCorrect(n: Int): Int {
        return when {
            n > 10 -> {
                println("Binary Range: isCorrect: $n value too big")
                1
            }
            n < 10 -> {
                println("Binary Range: isCorrect: $n value too small")
                -1
            }
            else -> {
                println("Binary Range: isCorrect: Found the value at $n")
                0
            }
        }
    }
}