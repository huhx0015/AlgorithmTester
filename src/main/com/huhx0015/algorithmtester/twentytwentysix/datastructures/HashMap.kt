package com.huhx0015.algorithmtester.twentytwentysix.datastructures

/**
 * A simple hash map implementation using:
 * 1) string-key hashing via ASCII/Unicode code summation, and
 * 2) open addressing with linear probing for collision resolution.
 */
class HashMap {

    /**
     * Represents one key-value entry stored in the hash table.
     */
    class Pair(var key: String, var `val`: String)

    // Tracks how many key-value entries are currently stored.
    var size: Int = 0
    // Tracks the current total number of buckets in the backing array.
    var capacity: Int = 2
    // Backing storage where each index is either null or a Pair entry.
    var map: Array<Pair?> = arrayOfNulls(2)

    /**
     * Computes a bucket index for a key using a simple additive hash.
     *
     * Algorithm:
     * - Sum character codes in the key.
     * - Use modulo with capacity to keep index in bounds.
     */
    fun hash(key: String): Int {
        // Start the running total for character-code accumulation.
        var index = 0
        // Visit every character position in the key.
        for (i in key.indices) {
            // Add this character's numeric code to the running total.
            index += key[i].code
        }
        // Convert the raw hash total into a valid array index.
        return index % capacity
    }

    /**
     * Retrieves the value for a key, or null when the key is absent.
     *
     * Algorithm:
     * - Start at the key's hashed index.
     * - Probe linearly until finding the key or a null slot.
     */
    fun get(key: String): String? {
        // Compute the initial lookup position from the key hash.
        var index = hash(key)
        // Continue probing while entries exist in visited slots.
        while (map[index] != null) {
            // Check whether the current slot contains the requested key.
            if (map[index]!!.key == key) {
                // Return the matching value immediately.
                return map[index]!!.`val`
            }
            // Move to the next slot for linear probing.
            index++
            // Wrap around to stay within array bounds.
            index %= capacity
        }
        // Reaching a null slot means the key is not present.
        return null
    }

    /**
     * Inserts a new key-value pair or updates the value if key already exists.
     *
     * Algorithm:
     * - Probe from the hashed index until:
     *   a) an empty bucket is found (insert), or
     *   b) the same key is found (update).
     * - Rehash (resize) when load reaches at least 50%.
     */
    fun put(key: String, value: String) {
        // Compute the initial insertion/update position.
        var index = hash(key)

        // Keep probing until we insert or update and return.
        while (true) {
            // Case 1: Empty slot found -> create and store a new entry.
            if (map[index] == null) {
                // Place the key-value pair in the available bucket.
                map[index] = Pair(key, value)
                // Increase item count because we inserted a new key.
                size++
                // If load factor is at least 1/2, grow and redistribute entries.
                if (size >= capacity / 2) {
                    // Double capacity and reinsert all existing items.
                    rehash()
                }
                // Insertion complete.
                return
            // Case 2: Existing key found -> overwrite stored value.
            } else if (map[index]!!.key == key) {
                // Update value without changing size.
                map[index]!!.`val` = value
                // Update complete.
                return
            }
            // Collision with another key -> probe next bucket.
            index++
            // Wrap index to remain within table boundaries.
            index %= capacity
        }
    }

    /**
     * Removes a key-value pair when the key exists.
     *
     * Note:
     * This direct null-removal approach can break linear probing chains.
     * A production-safe approach typically uses tombstones or cluster reinsertions.
     */
    fun remove(key: String) {
        // Fast exit if the key is not currently stored.
        if (get(key) == null) {
            // Nothing to remove.
            return
        }

        // Start searching from the key's hashed bucket.
        var index = hash(key)
        // Probe until the target key is found (it is guaranteed to exist here).
        while (true) {
            // Check whether the current entry matches the removal key.
            if (map[index]!!.key == key) {
                // Removing an element using open-addressing actually causes a bug,
                // because we may create a hole in the list, and our get() may
                // stop searching early when it reaches this hole.
                // Clear the slot to remove the entry.
                map[index] = null
                // Decrement item count after successful removal.
                size--
                // Removal complete.
                return
            }
            // Continue linear probing when current key does not match.
            index++
            // Wrap probing index to remain in range.
            index %= capacity
        }
    }

    /**
     * Doubles table capacity and reinserts all existing entries.
     *
     * Algorithm:
     * - Allocate a larger array.
     * - Reset size.
     * - Reinsert old entries so hash indices reflect new capacity.
     */
    fun rehash() {
        // Grow bucket count to reduce collisions and load factor.
        capacity *= 2
        // Allocate new backing storage with updated capacity.
        val newMap: Array<Pair?> = arrayOfNulls(capacity)

        // Keep reference to the old storage for iteration.
        val oldMap = map
        // Replace active map with the newly allocated table.
        map = newMap
        // Reset size because entries will be re-added via put().
        size = 0
        // Reinsert each non-null entry into its new hashed position.
        for (p in oldMap) {
            // Skip empty buckets from the old table.
            if (p != null) {
                // Reinsert using normal put() to apply new capacity hashing.
                put(p.key, p.`val`)
            }
        }
    }

    /**
     * Prints all non-null key-value pairs currently stored in the table.
     */
    fun print() {
        // Visit every bucket in the backing array.
        for (p in map) {
            // Print only buckets that contain entries.
            if (p != null) {
                // Output key and value in a simple single-line format.
                println("${p.key} ${p.`val`}")
            }
        }
    }
}