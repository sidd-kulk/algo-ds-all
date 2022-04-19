package basics.geekforgeeks.Trees

import com.sun.source.tree.Tree

object NthLevelNodeInBinaryTree {
    fun get(root: TreeNode?, k: Int): MutableList<Int> {
        fun inner(node: TreeNode?, c: Int, list: MutableList<Int>): MutableList<Int> {
            if (node == null) {
                return list
            }
            if (c == 0) {
                list.add(node.`val`)
                return list
            }

            inner(node.left, c - 1, list)
            inner(node.right, c - 1, list)
            return list
        }

        val list = mutableListOf<Int>()
        if (k == 0) {
            list.add(root!!.`val`)
            return list
        }

        return inner(root, k, mutableListOf())
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
    root.left?.left = TreeNode(4)

    root.right = TreeNode(3)

    println(NthLevelNodeInBinaryTree.get(root, 2))
}
