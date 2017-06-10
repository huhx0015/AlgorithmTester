package test.com.huhx0015.algorithmtester.algorithms;

import main.com.huhx0015.algorithmtester.algorithms.DepthFirstSearch;
import main.com.huhx0015.algorithmtester.datastructures.Node;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Created by Michael Yoon Huh on 6/9/2017.
 */
class DepthFirstSearchTest {

    private static Node mTestNode;

    @BeforeAll
    static void initTestNode() {
        mTestNode = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");

        mTestNode.adjacent = new Node[] { b, d };
        b.adjacent = new Node[] { c, d };
        c.adjacent = new Node[] { e };
        d.adjacent = new Node[] { f };
    }

    @Test
    void testSearch() {
        DepthFirstSearch.search(mTestNode);
    }
}