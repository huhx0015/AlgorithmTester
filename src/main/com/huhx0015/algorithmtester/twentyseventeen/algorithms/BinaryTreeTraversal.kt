package com.huhx0015.algorithmtester.twentyseventeen.algorithms

import com.huhx0015.algorithmtester.twentyseventeen.datastructures.Node

/**
 * Created by Michael Yoon Huh on 4/7/2017.
 */
object BinaryTreeTraversal {

    // LEFT - NODE - RIGHT
    @JvmStatic
    fun inOrderTraversal(node: Node?) {

        if (node != null) {
            inOrderTraversal(node.left) // Traverse LEFT side.
            visit(node) // Do something with our NODE.
            inOrderTraversal(node.right) // Traverse RIGHT side.
        }
    }

    // NODE - LEFT - RIGHT
    @JvmStatic
    fun preOrderTraversal(node: Node?) {

        if (node != null) {
            visit(node) // Do something with our NODE.
            preOrderTraversal(node.left) // Traverse LEFT side.
            preOrderTraversal(node.right) // Traverse RIGHT side.
        }
    }

    // LEFT - RIGHT - NODE
    @JvmStatic
    fun postOrderTraversal(node: Node?) {

        if (node != null) {
            postOrderTraversal(node.left) // Traverse LEFT side.
            postOrderTraversal(node.right) // Traverse RIGHT side.
            visit(node) // Do something with our NODE.
        }
    }

    private fun visit(node: Node) {
        println("Node visited: " + node.value)
        node.visited = true
    }
}
