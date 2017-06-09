package com.huhx0015.datastructures;

/**
 * CustomHashTable:
 *
 * put():
 * No collisions: (amortized) runtime is O(1)
 * Collision: runtime is O(k) with k being number of collision items in the linked list.
 *
 * get():
 * No collisions: (amortized) runtime is O(1)
 * Collison: runtime is O(k), with k being number of collision items in linked list.
 *
 * http://robl.co/implement-your-own-hashmap/
 *
 * Created by Michael Yoon Huh on 5/29/2017.
 */
public class CustomHashTable {

    private int tableSize = 256;
    private HashEntry[] hashTable;

    /** CONSTRUCTORS **/

    public CustomHashTable() {
        this.hashTable = new HashEntry[tableSize];
    }

    public CustomHashTable(int size) {
        this.tableSize = size;
        this.hashTable = new HashEntry[tableSize];
    }

    /** HASH METHODS **/

    // put(): Adds the value into the hash table.
    public void put(Object key, Object value) {

        int hashValue = hash(key); // Gets the hash value associated with this key.

        // Create a new HashEntry object to store.
        HashEntry newEntry = new HashEntry(key, value);

        // COLLISION CHECK: Check if entry position in table is available.
        if (hashTable[hashValue] == null) {
            System.out.println("put(): Stored new entry at position: " + hashValue + " in hash table.");
            hashTable[hashValue] = newEntry; // The entry is stored.
        }

        // Otherwise, this means that the entry has already been filled (collision) and we need to handle this.
        else {

            System.out.println("put(): Collision detected. Preparing to add entry into table.");

            // Get the existing entry first.
            HashEntry oldEntry = hashTable[hashValue];

            // Check all entries to see if this object already exists.
            // Loops until we reach the end of the linked list.
            while (oldEntry.next != null) {

                // Check if new key matches entry key.
                if (newEntry.getKey().equals(oldEntry.getKey())) {
                    oldEntry.setValue(newEntry.getValue()); // Updates the existing entry value with the new value.
                }

                // Updates the pointer for the next loop.
                oldEntry = oldEntry.next;
            }

            // At this point, the oldEntry's next pointer is null, so we add the new entry here.
            System.out.println("put(): Stored new entry at the end of the collision list at hash position " + hashValue + " in hash table.");
            oldEntry.next = newEntry;
        }
    }

    // get(): Gets the value associated with the key.
    public Object get(Object key) {

        int hashValue = hash(key); // Gets the hash value associated with this key.

        HashEntry entry = hashTable[hashValue];

        // We check entry and it's collision list for any matches.
        while (entry != null) {

            // If we found a match, we return the value.
            if (entry.getKey().equals(key)) {
                System.out.println("get(): Match found for this key at hash position: " + hashValue);
                return entry.getValue();
            }

            entry = entry.next; // Updates the pointer.
        }

        // At this point, no entry was found in the hash table with the queried key.
        System.out.println("get(): No entry found in hash table with this key.");
        return null;
    }

    // remove(): Removes the object associated with the key from the hash table.
    public void remove(Object key) {

        int hashValue = hash(key); // Gets the hash value for this key.

        HashEntry entry = hashTable[hashValue]; // Gets the hash entry at the hash value position.

        if (entry != null) {

            // First check the head entry if there's a key match.
            if (key.equals(entry.getKey())) {
                hashTable[hashValue] = null; // Sets the entry at this position to be null.
                System.out.println("remove(): Key found in table, entry at hash value position " + hashValue + " has been removed.");
                return;
            } else {
                HashEntry nextEntry = entry.getNext();

                // Checks the collision entries for matches.
                while (nextEntry != null) {

                    // Checks each collision entry for a key match.
                    if (key.equals(nextEntry.getKey())) {
                        entry.setNext(null); // Sets the next entry to be null.
                        System.out.println("remove(): Key found in table, collision entry at hash value position " + hashValue + " has been removed.");
                        return;
                    }

                    // Updates the pointers for the collision chain linked list.
                    entry = nextEntry;
                    nextEntry = nextEntry.next;
                }

                // If this line is reached, there were no entries that could be removed.
                System.out.println("remove(): No entry found in hash table with this key.");
            }

        } else {
            System.out.println("remove(): No entry found in hash table with this key.");
        }
    }

    // hash(): Returns a hash value of key.
    private int hash(Object key) {

        // Generate a hash value using built-in hashCode() method.
        // We do modulo on the tablesize, since the hashValue could be greater than tablesize, resulting in a array out
        // of bounds index error.
        int hashValue = Math.abs(key.hashCode() % tableSize);
        System.out.println("hash(): Hash value for this key: " + hashValue);
        return hashValue;
    }

    /** HASH ENTRY SUBCLASS **/

    private class HashEntry {

        private Object key;
        private Object value;
        private HashEntry next; // Use a linked list to handle collisions.

        public HashEntry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public HashEntry getNext() {
            return next;
        }

        public void setNext(HashEntry next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        CustomHashTable hashTable = new CustomHashTable();

        hashTable.put("Hello", "Goodbye");
        hashTable.put("Where", "Is");
        hashTable.put("Go", "Stop");

        System.out.println((String) hashTable.get("Hello"));
        System.out.println((String) hashTable.get("Where"));
        System.out.println((String) hashTable.get("Go"));
        System.out.println((String) hashTable.get("Where"));
        System.out.println((String) hashTable.get("Pizza"));

        hashTable.remove("Go");
        hashTable.remove("Hi my name is Charlie.");
    }
}
