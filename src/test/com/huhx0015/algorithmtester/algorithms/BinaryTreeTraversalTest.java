package test.com.huhx0015.algorithmtester.algorithms;

import main.com.huhx0015.algorithmtester.datastructures.Node;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static main.com.huhx0015.algorithmtester.algorithms.BinaryTreeTraversal.inOrderTraversal;
import static main.com.huhx0015.algorithmtester.algorithms.BinaryTreeTraversal.postOrderTraversal;
import static main.com.huhx0015.algorithmtester.algorithms.BinaryTreeTraversal.preOrderTraversal;

/**
 * Created by Michael Yoon Huh on 6/9/2017.
 */
class BinaryTreeTraversalTest {

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
    void testInOrderTraversal() {
        inOrderTraversal(mTestNode);
    }

    @Test
    void testPreOrderTraversal() {
        preOrderTraversal(mTestNode);
    }

    @Test
    void testPostOrderTraversal() {
        postOrderTraversal(mTestNode);
    }
}