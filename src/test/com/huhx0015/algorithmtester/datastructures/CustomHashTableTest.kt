package test.com.huhx0015.algorithmtester.datastructures

import main.com.huhx0015.algorithmtester.datastructures.CustomHashTable
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

/**
 * Created by Michael Yoon Huh on 6/9/2017.
 */
internal class CustomHashTableTest {

    @Test
    fun testHashTable() {
        val hashTable = CustomHashTable()

        hashTable.put(TEST_KEY_HELLO, TEST_VALUE_GOODBYE)
        hashTable.put(TEST_KEY_WHERE, TEST_VALUE_IS)
        hashTable.put(TEST_KEY_GO, TEST_VALUE_STOP)

        assertEquals(TEST_VALUE_GOODBYE, hashTable[TEST_KEY_HELLO])
        assertEquals(TEST_VALUE_STOP, hashTable[TEST_KEY_GO])
        assertEquals(TEST_VALUE_IS, hashTable[TEST_KEY_WHERE])
        assertEquals(null, hashTable[TEST_KEY_PIZZA])

        hashTable.remove(TEST_KEY_GO)
        assertEquals(null, hashTable[TEST_KEY_GO])

        hashTable.remove(TEST_MY_NAME_IS_CHARLIE)
    }

    companion object {
        private val TEST_KEY_HELLO = "Hello"
        private val TEST_KEY_WHERE = "Where"
        private val TEST_KEY_GO = "Go"
        private val TEST_KEY_PIZZA = "Pizza"

        private val TEST_MY_NAME_IS_CHARLIE = "Hi my name is Charlie."

        private val TEST_VALUE_GOODBYE = "Hello"
        private val TEST_VALUE_IS = "Is"
        private val TEST_VALUE_STOP = "Stop"
    }
}