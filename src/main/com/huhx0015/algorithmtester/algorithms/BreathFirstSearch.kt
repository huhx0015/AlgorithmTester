package main.com.huhx0015.algorithmtester.algorithms

import main.com.huhx0015.algorithmtester.datastructures.Node
import java.util.LinkedList

/**
 * Created by Michael Yoon Huh on 4/29/2017.

 * Result with test node should be: A, B, D, C,
 */
object BreathFirstSearch {

    @JvmStatic fun main(args: Array<String>) {

        val a = Node("A")
        val b = Node("B")
        val c = Node("C")
        val d = Node("D")
        val e = Node("E")
        val f = Node("F")

        a.adjacent = arrayOf(b, d)
        b.adjacent = arrayOf(c, d)
        c.adjacent = arrayOf(e)
        d.adjacent = arrayOf(f)

        search(a)
    }

    fun search(root: Node) {

        // Creates a new Queue of Nodes, using LinkedList.
        val queue = LinkedList<Node>()

        queue.add(root) // We add the root to the queue. (equivalent to enqueue()).

        // While the queue is not empty, we visit each of the root's neighbor nodes.
        while (!queue.isEmpty()) {

            val frontNode = queue.remove() // Removes from the front of the queue.
            visit(frontNode) // We visit the node.

            // We then visit adjacent nodes, if they exist.
            if (frontNode.adjacent != null) {

                for (node in frontNode.adjacent) {

                    // Checks if this node is visited or not.
                    if (node.visited == false) {
                        node.visited = true
                        queue.add(node) // The node is added to the queue.
                    }
                }
            }
        }

    }

    private fun visit(node: Node) {
        println("search(): Visited Node: " + node.name)
    }
}
