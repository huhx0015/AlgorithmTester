package test.com.huhx0015.algorithmtester.datastructures;

import main.com.huhx0015.algorithmtester.datastructures.CustomHashTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Michael Yoon Huh on 6/9/2017.
 */
class CustomHashTableTest {

    private static final String TEST_KEY_HELLO = "Hello";
    private static final String TEST_KEY_WHERE = "Where";
    private static final String TEST_KEY_GO = "Go";
    private static final String TEST_KEY_PIZZA = "Pizza";
    private static final String TEST_MY_NAME_IS_CHARLIE = "Hi my name is Charlie.";

    private static final String TEST_VALUE_GOODBYE = "Hello";
    private static final String TEST_VALUE_IS = "Is";
    private static final String TEST_VALUE_STOP = "Stop";

    @Test
    void testHashTable() {
        CustomHashTable hashTable = new CustomHashTable();

        hashTable.put(TEST_KEY_HELLO, TEST_VALUE_GOODBYE);
        hashTable.put(TEST_KEY_WHERE, TEST_VALUE_IS);
        hashTable.put(TEST_KEY_GO, TEST_VALUE_STOP);

        assertEquals(TEST_VALUE_GOODBYE, hashTable.get(TEST_KEY_HELLO));
        assertEquals(TEST_VALUE_STOP, hashTable.get(TEST_KEY_GO));
        assertEquals(TEST_VALUE_IS, hashTable.get(TEST_KEY_WHERE));
        assertEquals(null, hashTable.get(TEST_KEY_PIZZA));

        hashTable.remove(TEST_KEY_GO);
        assertEquals(null, hashTable.get(TEST_KEY_GO));

        hashTable.remove(TEST_MY_NAME_IS_CHARLIE);
    }
}