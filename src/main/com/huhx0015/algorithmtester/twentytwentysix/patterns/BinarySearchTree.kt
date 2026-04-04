package com.huhx0015.algorithmtester.twentytwentysix.patterns

import com.huhx0015.algorithmtester.twentytwentysix.trees.TreeNode

/**
 * Pattern: Binary Search Tree
 * Data Structure:
 * Depth-First Traversal (DFS): Stack (ArrayDeque) | val stack = ArrayDeque<TreeNode>()
 * Breadth-First Traversal (BFS): Queue | val queue = ArrayDeque<TreeNode>()
 * List / Array: Collecting values during traversal
 * Heap / Priority Queue
 * HashMap / Set: Visited Node Tracking
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * Step 1: Trigger Words
 *
 * If the problem mentions:
 *
 * “Binary Search Tree”
 * “BST”
 * “left < root < right”
 * “sorted tree”
 * “inorder gives sorted result”
 *
 * 👉 Immediately use BST logic
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 🧩 Step 2: Core Decisions
 *
 * 👉 Are you searching for a value?
 *
 * → Use BST search (O(log n))
 *
 * 👉 Are you inserting/deleting?
 *
 * → Use recursive BST modification
 *
 * 👉 Are you validating?
 *
 * → Use min/max bounds
 *
 * 👉 Are you extracting sorted values?
 *
 * → Use inorder traversal
 *
 * ⚖️ BST vs Binary Tree (Critical!)
 * Feature	BST	Regular Binary Tree
 * Ordered?	✅ Yes	❌ No
 * Can prune search?	✅ Yes	❌ No
 * Search complexity	O(log n)	O(n)
 * 🔥 Interview Trap
 *
 * If it’s just:
 *
 * “binary tree”
 *
 * ❌ Don’t assume BST
 * ✅ You must traverse whole tree
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * ⚡ Step 3: When to Use BST Optimization
 *
 * Ask:
 *
 * Is this a BST?
 * Can I use ordering to skip half the tree?
 *
 * 👉 If yes → don’t brute force traverse
 *
 * 🧠 Mental Model
 *
 * At every node:
 *
 * target < node → go left
 * target > node → go right
 */
class BinarySearchTree {

    fun searchBST(root: TreeNode?, target: Int): TreeNode? {
        if (root == null) return null // Base case: not found

        return when {
            target == root.value -> root // Found target
            target < root.value -> searchBST(root.left, target) // Search left
            else -> searchBST(root.right, target) // Search right
        }
    }

    fun insertIntoBST(root: TreeNode?, value: Int): TreeNode {
        if (root == null) return TreeNode(value) // Insert new node here

        if (value < root.value) {
            root.left = insertIntoBST(root.left, value) // Insert into left subtree
        } else {
            root.right = insertIntoBST(root.right, value) // Insert into right subtree
        }

        return root // Return unchanged root
    }

    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null // Base case

        when {
            key < root.value -> root.left = deleteNode(root.left, key) // Go left
            key > root.value -> root.right = deleteNode(root.right, key) // Go right
            else -> {
                // Found node to delete

                if (root.left == null) return root.right // Replace with right child
                if (root.right == null) return root.left // Replace with left child

                // Node has two children → find inorder successor (smallest in right subtree)
                val minNode = findMin(root.right!!)
                root.value = minNode.value // Replace value
                root.right = deleteNode(root.right, minNode.value) // Delete duplicate
            }
        }

        return root
    }

    fun findMin(node: TreeNode): TreeNode {
        var current = node
        while (current.left != null) {
            current = current.left!! // Keep going left to find smallest
        }
        return current
    }

    fun inorder(root: TreeNode?) {
        if (root == null) return

        inorder(root.left) // Visit left
        println(root.value) // Visit node
        inorder(root.right) // Visit right
    }

    fun isValidBST(root: TreeNode?): Boolean {
        return validate(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }

    fun validate(node: TreeNode?, min: Int, max: Int): Boolean {
        if (node == null) return true

        if (node.value <= min || node.value >= max) return false

        return validate(node.left, min, node.value) &&
                validate(node.right, node.value, max)
    }
}