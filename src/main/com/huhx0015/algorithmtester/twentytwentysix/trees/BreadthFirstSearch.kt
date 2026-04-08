package com.huhx0015.algorithmtester.twentytwentysix.trees

/**
 *  Notes:
 *  Data Structure to Use: Queue (FIFO: First in, first out) - Deque (double ended Queue)
 *
 *  Time Complexity: O(n) | Space Complexity: O(n) | Where `n` is number of nodes in the tree.
 */
object BreadthFirstSearch {

    @JvmStatic fun main(args: Array<String>) {
        val treeNode1 = TreeNode(3)
        val treeNode2 = TreeNode(1)
        val treeNode3 = TreeNode(5)
        val treeNode4 = TreeNode(7)
        val treeNode5 = TreeNode(10)
        treeNode1.left = treeNode2
        treeNode1.right = treeNode3
        treeNode3.left = treeNode4
        treeNode3.right = treeNode5

        bfs(root = treeNode1)
    }

    fun bfs(root: TreeNode?) {
        // Create a queue to process nodes in FIFO order (First-In, First-Out)
        val queue = ArrayDeque<TreeNode>()

        // If the root exists, add it to the queue to start traversal
        if (root != null) {
            queue.add(root)
        }

        // Tracks the current level (depth) of the tree
        var level = 0

        // Continue looping while there are nodes to process
        while (queue.isNotEmpty()) {
            print("level $level: ")

            // Capture the number of nodes currently in the queue
            // This represents ALL nodes at the current level
            val levelLength = queue.size

            // Iterate through all nodes at this level
            for (i in 0 until levelLength) {
                // Remove the front node from the queue (FIFO behavior)
                val curr = queue.removeFirst()

                print("${curr.value} ")

                // If the current node has a left child,
                // add it to the queue to be processed in the next level
                if (curr.left != null) {
                    queue.add(curr.left!!)
                }

                // If the current node has a right child,
                // add it to the queue to be processed in the next level
                if (curr.right != null) {
                    queue.add(curr.right!!)
                }
            }

            // Move to the next level after processing all nodes at current level
            level++

            println()
        }
    }
}