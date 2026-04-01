package com.huhx0015.algorithmtester.twentytwentysix.datastructures

/**
 *  Time Complexity: O(n)
 *  Space Complexity: O(n)
 *  Lookup: O(1)
 */
object Hash {

    @JvmStatic fun main(args: Array<String>) {
        val names = arrayOf("alice", "brad", "collin", "brad", "dylan", "kim")
        val countMap = HashMap<String, Int>()

        for (name in names) {

            // If countMap does not contain name, we set an initial value of 1.
            if (!countMap.containsKey(name)) {
                countMap[name] = 1
            } else {
                // Otherwise, we lookup and get the value in the HashMap, add + 1, and update the HashMap.
                countMap[name] = countMap[name]!! + 1
            }
        }
        println(countMap)
    }
}