package com.huhx0015.algorithmtester.twentyseventeen.datastructures

/**
 * Created by Michael Yoon Huh on 5/29/2017.

 * CustomHashTable:

 * put():
 * No collisions: (amortized) runtime is O(1)
 * Collision: runtime is O(k) with k being number of collision items in the linked list.

 * get():
 * No collisions: (amortized) runtime is O(1)
 * Collison: runtime is O(k), with k being number of collision items in linked list.

 * Reference: http://robl.co/implement-your-own-hashmap/
 */
class CustomHashTable {

    private var tableSize = 256
    private var hashTable: Array<HashEntry?>

    /** CONSTRUCTORS  */

    constructor() {
        this.hashTable = arrayOfNulls<HashEntry>(tableSize)
    }

    constructor(size: Int) {
        this.tableSize = size
        this.hashTable = arrayOfNulls<HashEntry>(tableSize)
    }

    /** HASH METHODS  */

    // put(): Adds the value into the hash table.
    fun put(key: Any, value: Any) {

        val hashValue = hash(key) // Gets the hash value associated with this key.

        // Create a new HashEntry object to store.
        val newEntry = HashEntry(key, value)

        // COLLISION CHECK: Check if entry position in table is available.
        if (hashTable[hashValue] == null) {
            println("put(): Stored new entry at position: $hashValue in hash table.")
            hashTable[hashValue] = newEntry // The entry is stored.
        }

        // Otherwise, this means that the entry has already been filled (collision) and we need to handle this.
        else {

            println("put(): Collision detected. Preparing to add entry into table.")

            // Get the existing entry first.
            var oldEntry = hashTable[hashValue]

            // Check all entries to see if this object already exists.
            // Loops until we reach the end of the linked list.
            while (oldEntry!!.next != null) {

                // Check if new key matches entry key.
                if (newEntry.key == oldEntry.key) {
                    oldEntry.value = newEntry.value // Updates the existing entry value with the new value.
                }

                // Updates the pointer for the next loop.
                oldEntry = oldEntry.next
            }

            // At this point, the oldEntry's next pointer is null, so we add the new entry here.
            println("put(): Stored new entry at the end of the collision list at hash position $hashValue in hash table.")
            oldEntry.next = newEntry
        }
    }

    // get(): Gets the value associated with the key.
    operator fun get(key: Any): Any? {

        val hashValue = hash(key) // Gets the hash value associated with this key.

        var entry: HashEntry? = hashTable[hashValue]

        // We check entry and it's collision list for any matches.
        while (entry != null) {

            // If we found a match, we return the value.
            if (entry.key == key) {
                println("get(): Match found for this key at hash position: " + hashValue)
                return entry.value
            }

            entry = entry.next // Updates the pointer.
        }

        // At this point, no entry was found in the hash table with the queried key.
        println("get(): No entry found in hash table with this key.")
        return null
    }

    // remove(): Removes the object associated with the key from the hash table.
    fun remove(key: Any) {

        val hashValue = hash(key) // Gets the hash value for this key.

        var entry: HashEntry? = hashTable[hashValue] // Gets the hash entry at the hash value position.

        if (entry != null) {

            // First check the head entry if there's a key match.
            if (key == entry.key) {
                hashTable[hashValue] = null // Sets the entry at this position to be null.
                println("remove(): Key found in table, entry at hash value position $hashValue has been removed.")
                return
            } else {
                var nextEntry: HashEntry? = entry.next

                // Checks the collision entries for matches.
                while (nextEntry != null) {

                    // Checks each collision entry for a key match.
                    if (key == nextEntry.key) {
                        entry!!.next = null // Sets the next entry to be null.
                        println("remove(): Key found in table, collision entry at hash value position $hashValue has been removed.")
                        return
                    }

                    // Updates the pointers for the collision chain linked list.
                    entry = nextEntry
                    nextEntry = nextEntry.next
                }

                // If this line is reached, there were no entries that could be removed.
                println("remove(): No entry found in hash table with this key.")
            }

        } else {
            println("remove(): No entry found in hash table with this key.")
        }
    }

    // hash(): Returns a hash value of key.
    private fun hash(key: Any): Int {

        // Generate a hash value using built-in hashCode() method.
        // We do modulo on the tablesize, since the hashValue could be greater than tablesize, resulting in a array out
        // of bounds index error.
        val hashValue = Math.abs(key.hashCode() % tableSize)
        println("hash(): Hash value for this key: " + hashValue)
        return hashValue
    }

    /** HASH ENTRY SUBCLASS  */

    private inner class HashEntry(var key: Any?, var value: Any?) {
        var next: HashEntry? = null // Use a linked list to handle collisions.
    }

    companion object {

        @JvmStatic fun main(args: Array<String>) {
            val hashTable = CustomHashTable()

            hashTable.put("Hello", "Goodbye")
            hashTable.put("Where", "Is")
            hashTable.put("Go", "Stop")

            println(hashTable["Hello"] as String?)
            println(hashTable["Where"] as String?)
            println(hashTable["Go"] as String?)
            println(hashTable["Where"] as String?)
            println(hashTable["Pizza"] as String?)

            hashTable.remove("Go")
            hashTable.remove("Hi my name is Charlie.")
        }
    }
}
