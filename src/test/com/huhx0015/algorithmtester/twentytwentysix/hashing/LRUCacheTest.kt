package com.huhx0015.algorithmtester.twentytwentysix.hashing

import com.huhx0015.algorithmtester.twentytwentysix.problems.hashing.LRUCache
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LRUCacheTest {

    @Test
    fun testLRUCache() {
        val lruCache = LRUCache(2)

        lruCache.put(1, 10)  // cache: {1=10}
        val getValue1 = lruCache.get(1)      // return 10
        assertEquals(10, getValue1)
        println("LRU Cache: Getting value at key 1: $getValue1")

        lruCache.put(2, 20)  // cache: {1=10, 2=20}
        lruCache.put(3, 30)  // cache: {2=20, 3=30}, key=1 was evicted
        val getValue2 = lruCache.get(2) // returns 20
        assertEquals(20, getValue2)

        val getValue3 = lruCache.get(1) // return -1 (not found)
        assertEquals(-1, getValue3)
    }
}