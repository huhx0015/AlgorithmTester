package com.huhx0015.algorithmtester.twentyseventeen.algorithms

import com.huhx0015.algorithmtester.twentyseventeen.datastructures.Node

/**
 * Created by Michael Yoon Huh on 4/29/2017.
 *
 * Result with test node should be: A, B, C, E, D, F
 */
object DepthFirstSearch {

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

    fun search(root: Node?) {

        // Check if root is null.
        if (root == null) {
            return
        }

        // Visit the root.
        visit(root)
        root.visited = true

        // Check if root has any adjacent nodes.
        if (root.adjacent != null) {

            root.adjacent?.let {
                for (node in it) {

                    // If the node has not been visited yet, we search it.
                    if (node.visited == false) {
                        search(node)
                    }
                }
            }
        }
    }

    private fun visit(node: Node) {
        println("search(): Visited Node: " + node.name)
    }
}
