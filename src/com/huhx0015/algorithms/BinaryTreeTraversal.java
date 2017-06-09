package com.huhx0015.algorithms;

import com.huhx0015.datastructures.Node;

/**
 * Created by Michael Yoon Huh on 4/7/2017.
 */
public class BinaryTreeTraversal {

    // LEFT - NODE - RIGHT
    public void inOrderTraversal(Node node) {

        // If node is NOT null...
        if (node != null) {

            inOrderTraversal(node.left); // Traverse LEFT side.
            visit(node); // Do something with our NODE.
            inOrderTraversal(node.right); // Traverse RIGHT side.
        }

    }

    // NODE - LEFT - RIGHT
    public void preOrderTraversal(Node node) {

        if (node != null) {

            visit(node); // Do something with our NODE.
            preOrderTraversal(node.left); // Traverse LEFT side.
            preOrderTraversal(node.right); // Traverse RIGHT side.
        }
    }

    // LEFT - RIGHT - NODE
    public void postOrderTraversal(Node node) {

        if (node != null) {

            postOrderTraversal(node.left); // Traverse LEFT side.
            postOrderTraversal(node.right); // Traverse RIGHT side.
            visit(node); // Do something with our NODE.
        }
    }

    public void visit(Node node) {
        System.out.println("Node visited: " + node.name);
    }
}
