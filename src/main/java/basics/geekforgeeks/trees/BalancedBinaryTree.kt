package basics.geekforgeeks.trees

import kotlin.math.abs
import kotlin.math.max

// https://leetcode.com/problems/balanced-binary-tree/
object BalancedBinaryTree {
    private fun depth(node: TreeNode?): Int {
        if (node == null) return 0
        val leftDepth = depth(node.left)
        val rightDepth = depth(node.right)
        return max(leftDepth, rightDepth) + 1
    }

    fun checkBruteForce(root: TreeNode?): Boolean { // O(n^2)
        if (root == null) return true
        val leftDepth = depth(root.left)
        val rightDepth = depth(root.right)

        return abs(leftDepth - rightDepth) <= 1 && checkBruteForce(root.left) && checkBruteForce(root.right)
    }

    fun insert
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
    root.left?.left = TreeNode(3)


//    [1,2,2,3,null,null,3,4,null,null,4]


    println(BalancedBinaryTree.checkBruteForce(root))
}