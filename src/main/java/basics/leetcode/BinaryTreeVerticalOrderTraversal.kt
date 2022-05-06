package basics.leetcode

import basics.geekforgeeks.trees.TreeNode
import java.util.*
import kotlin.math.min

object BinaryTreeVerticalOrderTraversal {

    fun traverse(root: TreeNode?): MutableList<MutableList<Int>> {
        val map = mutableMapOf<Int, LinkedList<Int>>()
        var min = Int.MAX_VALUE
        var prevRoot = root
        fun rec(node: TreeNode?, nodeIndex: Int) {
            if (node == null) return

            rec(node.left, nodeIndex - 1)

            val list = map.getOrDefault(nodeIndex, LinkedList())
            list.add(node.`val`)
            map[nodeIndex] = list
            min = min(nodeIndex, min)

            rec(node.right, nodeIndex + 1)
        }

        val list = mutableListOf<MutableList<Int>>()
        rec(root, 0)
        while (map[min] != null) {
            map[min]?.let { list.add(it) }
            min++
        }
        return list
    }
}

fun main() {
//    val root = TreeNode(1)
//    root.left = TreeNode(2)
//    root.left?.left = TreeNode(3)
//    root.left?.right = TreeNode(6)
//
//    root.right = TreeNode(4)
//    root.right?.right = TreeNode(5)
//    root.right?.left = TreeNode(7)
//    root.right?.left?.right = TreeNode(8)

    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(0)
    root.right = TreeNode(8)
    root.right!!.left = TreeNode(1)
    root.right!!.right = TreeNode(7)

    println(BinaryTreeVerticalOrderTraversal.traverse(root))
}