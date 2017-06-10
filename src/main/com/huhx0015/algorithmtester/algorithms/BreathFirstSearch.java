package main.com.huhx0015.algorithmtester.algorithms;

import main.com.huhx0015.algorithmtester.datastructures.Node;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Michael Yoon Huh on 4/29/2017.
 *
 * Result with test node should be: A, B, D, C,
 */
public class BreathFirstSearch {

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

        // Creates a new Queue of Nodes, using LinkedList.
        Queue<Node> queue = new LinkedList<>();

        queue.add(root); // We add the root to the queue. (equivalent to enqueue()).

        // While the queue is not empty, we visit each of the root's neighbor nodes.
        while (!queue.isEmpty()) {

            Node frontNode = queue.remove(); // Removes from the front of the queue.
            visit(frontNode); // We visit the node.

            // We then visit adjacent nodes, if they exist.
            if (frontNode.adjacent != null) {

                for (Node node : frontNode.adjacent) {

                    // Checks if this node is visited or not.
                    if (node.visited == false) {
                        node.visited = true;
                        queue.add(node); // The node is added to the queue.
                    }
                }
            }
        }

    }

    private static void visit(Node node) {
        System.out.println("search(): Visited Node: " + node.name);
    }
}
