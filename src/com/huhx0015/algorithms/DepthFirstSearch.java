package com.huhx0015.algorithms;

import com.huhx0015.datastructures.Node;

/**
 * Created by Michael Yoon Huh on 4/29/2017.
 *
 * Result with test node should be: A, B, C, E, D, F
 */
public class DepthFirstSearch {

    public static void main(String[] args) {

        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");

        a.adjacent = new Node[] { b, d };
        b.adjacent = new Node[] { c, d };
        c.adjacent = new Node[] { e };
        d.adjacent = new Node[] { f };

        search(a);
    }

    public static void search(Node root) {

        // Check if root is null.
        if (root == null) {
            return;
        }

        // Visit the root.
        visit(root);
        root.visited = true;

        // Check if root has any adjacent nodes.
        if (root.adjacent != null) {

            // Iterate through each adjacent node.
            for (Node node : root.adjacent) {

                // If the node has not been visited yet, we search it.
                if (node.visited == false) {
                    search(node);
                }
            }
        }
    }

    public static void visit(Node node) {
        System.out.println("search(): Visited Node: " + node.name);
    }
}
