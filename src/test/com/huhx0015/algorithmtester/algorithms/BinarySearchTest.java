package test.com.huhx0015.algorithmtester.algorithms;

import main.com.huhx0015.algorithmtester.datastructures.Node;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static main.com.huhx0015.algorithmtester.algorithms.BinarySearch.arraySearch;
import static main.com.huhx0015.algorithmtester.algorithms.BinarySearch.nodeSearch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by Michael Yoon Huh on 6/9/2017.
 */
class BinarySearchTest {

    private static final int[] TEST_ARRAY = {1, 3, 5, 7, 8, 10, 12, 15, 20};

    private static final int TEST_SEARCH_VALUE = 12;
    private static final int TEST_BAD_VALUE = 9999;
    private static final int TEST_INVALID_POSITION = -1;

    private static Node mTestNode;

    @BeforeAll
    static void initTestNode() {
        mTestNode = new Node(8);
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        Node node4 = new Node(7);
        Node node5 = new Node(10);
        Node node6 = new Node(12);
        Node node7 = new Node(15);
        Node node8 = new Node(20);

        // LEFT SIDE
        mTestNode.left = node3;
        node3.left = node2;
        node3.right = node4;
        node2.left = node1;

        // RIGHT SIDE
        mTestNode.right = node6;
        node6.left = node5;
        node6.right = node7;
        node7.right = node8;
    }

    @Test
    void testArraySearch() {
        int resultPosition = arraySearch(TEST_ARRAY, TEST_SEARCH_VALUE, 0, TEST_ARRAY.length - 1);
        assertEquals(TEST_SEARCH_VALUE, TEST_ARRAY[resultPosition]);

        int wrongPosition = arraySearch(TEST_ARRAY, TEST_BAD_VALUE, 0, TEST_ARRAY.length - 1);
        assertEquals(TEST_INVALID_POSITION, wrongPosition);
    }

    @Test
    void testNodeSearch() {
        Node resultNode = nodeSearch(mTestNode, TEST_SEARCH_VALUE);
        assertNotNull(resultNode);
        assertEquals(TEST_SEARCH_VALUE, resultNode.value);

        Node badNode = nodeSearch(mTestNode, TEST_BAD_VALUE);
        assertEquals(null, badNode);
    }
}