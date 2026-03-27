package com.huhx0015.algorithmtester.twentytwentysix.trees

object DepthFirstSearch {

    // treeNode1:
    //              3
    //          1       5
    //               7     10
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

        println("Inorder Traversal: Starting inorder traversal...")
        inorder(treeNode1)
        println("Inorder Traversal: Inorder traversal complete\n")

        println("Preorder Traversal: Starting preorder traversal...")
        preorder(treeNode1)
        println("Preorder Traversal: Preorder traversal complete\n")

        println("Postorder Traversal: Starting postorder traversal...")
        postorder(treeNode1)
        println("Postorder Traversal: Postorder traversal complete")
    }

    // inorder(): In order traversal: LEFT -> ROOT -> RIGHT
    // Time Complexity: O(n) | Space Complexity: O(h): h is the height of the tree
    fun inorder(root: TreeNode?) {
        if (root == null) {
            return
        }
        inorder(root.left)
        println(root.value)
        inorder(root.right)
    }

    // preorder(): Pre order traversal: ROOT -> LEFT -> RIGHT
    // Time Complexity: O(n) | Space Complexity: O(h): h is the height of the tree
    fun preorder(root: TreeNode?) {
        if (root == null) {
            return
        }
        println(root.value)
        preorder(root.left)
        preorder(root.right)
    }

    // postorder(): LEFT -> RIGHT -> ROOT
    // Time Complexity: O(n) | Space Complexity: O(h): h is the height of the tree
    fun postorder(root: TreeNode?) {
        if (root == null) {
            return
        }
        postorder(root.left)
        postorder(root.right)
        println(root.value)
    }
}