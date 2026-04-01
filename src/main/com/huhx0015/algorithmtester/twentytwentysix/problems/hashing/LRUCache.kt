package com.huhx0015.algorithmtester.twentytwentysix.problems.hashing

/**
 * NeetCode.io
 *
 * Problem: LRU Cache
 * Difficulty: Medium
 *
 * Implement the Least Recently Used (LRU) cache class LRUCache. The class should support the following operations
 *
 * LRUCache(int capacity) Initialize the LRU cache of size capacity.
 * int get(int key) Return the value corresponding to the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the introduction of the new pair causes the cache to exceed its capacity, remove the least recently used key.
 * A key is considered used if a get or a put operation is called on it.
 *
 * Ensure that get and put each run in O(1) average time complexity.
 *
 * Example 1:
 *
 * Input:
 * ["LRUCache", [2], "put", [1, 10],  "get", [1], "put", [2, 20], "put", [3, 30], "get", [2], "get", [1]]
 *
 * Output:
 * [null, null, 10, null, null, 20, -1]
 *
 * Explanation:
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 10);  // cache: {1=10}
 * lRUCache.get(1);      // return 10
 * lRUCache.put(2, 20);  // cache: {1=10, 2=20}
 * lRUCache.put(3, 30);  // cache: {2=20, 3=30}, key=1 was evicted
 * lRUCache.get(2);      // returns 20
 * lRUCache.get(1);      // return -1 (not found)
 * Constraints:
 *
 * 1 <= capacity <= 100
 * 0 <= key <= 1000
 * 0 <= value <= 1000
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class LRUCache(capacity: Int) {

    val cacheSize = capacity // Max capacity reference of the cacheMap.
    val cacheMap: HashMap<Int, Int> = HashMap(capacity) // HashMap initialized to the size of `capacity`.

    // Queue (FIFO) that stores the least recently used keys. The first element will be the least recently used key.
    val leastRecentlyUsedKeyStack: ArrayDeque<Int> = ArrayDeque()

    // get(): Return the value corresponding to the key if the key exists, otherwise return -1.
    fun get(key: Int): Int {
        val value = cacheMap[key]

        // Update the key in leastRecentlyUsedKeyStack, since accessing it means that it was used.
        if (value != null) {
            leastRecentlyUsedKeyStack.remove(key) // Removes the key from the stack.
            leastRecentlyUsedKeyStack.add(key) // Adds the updated key value to the leastRecentlyUsedKeyStack.
        }
        return value ?: -1 // Returns the value if it exists (non-null), otherwise returns -1.
    }

    // put(): Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the
    // introduction of the new pair causes the cache to exceed its capacity, remove the least recently used key.
    fun put(key: Int, value: Int) {

        // Checks if the key already exists in the cacheMap. If so, we update the value.
        if (cacheMap.containsKey(key)) {
            leastRecentlyUsedKeyStack.remove(key) // Removes the key from the stack.
            leastRecentlyUsedKeyStack.add(key) // Adds the updated key value to the leastRecentlyUsedKeyStack.
            cacheMap[key] = value
        } else {

            // If we have reached max capacity of the cacheMap, we remove the last used key from the cacheMap.
            if (cacheMap.size == cacheSize) {
                // Removes the first element (key) and returns the element that was removed.
                val leastRecentlyUsedKey = leastRecentlyUsedKeyStack.removeFirst()

                // Removes the key/value using the removed key from leastRecentlyUsedKeyStack.
                cacheMap.remove(leastRecentlyUsedKey)
            }

            leastRecentlyUsedKeyStack.add(key) // Adds the updated key value to the leastRecentlyUsedKeyStack.
            cacheMap[key] = value // Adds the new key/value to the cacheMap.
        }
    }
}

object MyLRUCache {

    @JvmStatic fun main(args: Array<String>) {
        val lruCache = LRUCache(2)

        lruCache.put(1, 10)  // cache: {1=10}
        val getValue1 = lruCache.get(1)      // return 10
        println("LRU Cache: Getting value at key 1: $getValue1")

        lruCache.put(2, 20)  // cache: {1=10, 2=20}
        lruCache.put(3, 30)  // cache: {2=20, 3=30}, key=1 was evicted
        val getValue2 = lruCache.get(2) // returns 20
        println("LRU Cache: Getting value at key 2: $getValue2")

        val getValue3 = lruCache.get(1) // return -1 (not found)
        println("LRU Cache: Getting value at key 1: $getValue3")
    }
}