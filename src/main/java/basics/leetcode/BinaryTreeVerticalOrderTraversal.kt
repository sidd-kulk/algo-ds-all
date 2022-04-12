package basics.leetcode

import kotlin.math.abs
import kotlin.math.max

object BinaryTreeVerticalOrderTraversal {
    fun verticalOrder(root: TreeNode?, nodeIndex: Int = 0, ls: MutableList<MutableList<Int?>?> = mutableListOf()) {
        if (root != null) {
            verticalOrder(root.left, nodeIndex - 1)
            if (ls.size > abs(nodeIndex)) {
                if (ls[abs(nodeIndex)] != null) {
                    ls[abs(nodeIndex)]
                } else {

                }
            }
            println("${root.`val`}, nodeIndex = $nodeIndex")
            verticalOrder(root.right, nodeIndex + 1)
        }
    }

}

fun inorder(node: TreeNode?) {
    if (node != null) {
        inorder(node.left)
        println("$node")
        inorder(node.right)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    override fun toString(): String {
        return `val`.toString()
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)

    root.right = TreeNode(3)
    root.right!!.left = TreeNode(6)
    root.right!!.right = TreeNode(7)
    BinaryTreeVerticalOrderTraversal.verticalOrder(root)
}