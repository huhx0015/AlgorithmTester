package com.huhx0015.algorithmtester.twentytwentysix.patterns

import com.huhx0015.algorithmtester.twentytwentysix.trees.TreeNode

/**
 * Pattern: Breadth First Search
 * Data Structures: Queue (ArrayDeque)
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * Step 1: Trigger Words
 *
 * If the problem mentions:
 *
 * “level order traversal”
 * “minimum depth”
 * “shortest path” (unweighted)
 * “nearest / closest”
 * “process level by level”
 *
 * 👉 Think BFS immediately
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🧩 Step 2: Key Signals
 * Signal	Why BFS
 * Level-based output	BFS naturally groups levels
 * Shortest path (unweighted)	BFS guarantees shortest
 * Tree traversal by depth	BFS processes depth in order
 * ⚖️ BFS vs DFS
 * Pattern	Use When
 * BFS	Level order, shortest path
 * DFS	Depth exploration, recursion problems
 * 🔥 Quick Decision Rule
 *
 * Ask:
 *
 * 👉 “Do I care about levels or shortest distance?”
 *
 * YES → BFS
 * NO → DFS
 *
 * Core Template:
 *
 * val queue = ArrayDeque<TreeNode>()
 * queue.add(root)
 *
 * while (queue.isNotEmpty()) {
 *     val node = queue.removeFirst()
 *
 *     node.left?.let { queue.add(it) }
 *     node.right?.let { queue.add(it) }
 * }
 */
class BreadthFirstSearch {

    // Core BFS Template (Level Order Traversal)
    fun bfs(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>() // Stores values level by level
        if (root == null) return result // Edge case: empty tree

        val queue: ArrayDeque<TreeNode> = ArrayDeque() // Queue for BFS
        queue.add(root) // Start with root node

        while (queue.isNotEmpty()) { // Process until all nodes are visited
            val levelSize = queue.size // Number of nodes at current level
            val currentLevel = mutableListOf<Int>() // Store current level values

            for (i in 0 until levelSize) { // Process all nodes in this level
                val node = queue.removeFirst() // Dequeue front node
                currentLevel.add(node.value) // Add its value to current level

                // Add children to queue for next level
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }

            result.add(currentLevel) // Save completed level
        }

        return result
    }

    // BFS Without Levels (Simple Traversal)
    fun bfsFlat(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        if (root == null) return result

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst() // Process node
            result.add(node.value)

            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }

        return result
    }

    // Minimum Depth (Classic BFS Use Case)
    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0

        val queue = ArrayDeque<Pair<TreeNode, Int>>() // Pair(node, depth)
        queue.add(root to 1)

        while (queue.isNotEmpty()) {
            val (node, depth) = queue.removeFirst()

            // First leaf node encountered → shortest path
            if (node.left == null && node.right == null) {
                return depth
            }

            node.left?.let { queue.add(it to depth + 1) }
            node.right?.let { queue.add(it to depth + 1) }
        }

        return 0
    }

    // BFS for Graphs (with Visited Set)
    fun bfsGraph(start: Int, graph: Map<Int, List<Int>>): List<Int> {
        val result = mutableListOf<Int>()
        val visited = mutableSetOf<Int>() // Prevent cycles
        val queue = ArrayDeque<Int>()

        queue.add(start)
        visited.add(start)

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            result.add(node)

            for (neighbor in graph[node] ?: emptyList()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor)
                    queue.add(neighbor)
                }
            }
        }

        return result
    }

    // BFS Level Tracking (Right Side View Example)
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        if (root == null) return result

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size

            for (i in 0 until levelSize) {
                val node = queue.removeFirst()

                // Last node in this level
                if (i == levelSize - 1) {
                    result.add(node.value)
                }

                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
        }

        return result
    }
}