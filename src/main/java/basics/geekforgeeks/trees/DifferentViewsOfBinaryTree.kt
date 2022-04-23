package basics.geekforgeeks.trees

import basics.problems.simple.stack_queue.Queue
import java.util.*

object LeftViewOfBinaryTree {
    fun iterativeUsingQueueBadCode(root: TreeNode?): MutableList<Int> {
        val queue = LinkedList<TreeNode?>()
        queue.add(root)
        queue.add(null)
        var isIt = true
        val list = mutableListOf<Int>()
        while (queue.size > 1) {
            val current = queue.poll()
            if (current == null) {
                print("\n")
                queue.add(null)
                isIt = true
                continue
            }
            if (isIt) {
                list.add(current.`val`)
                print("$current,")
                isIt = false
            }

            if (current.left != null) {
                queue.add(current.left)
            }
            if (current.right != null) {
                queue.add(current.right)
            }
        }
        return list
    }

    fun iterativeUsingQueueGoodCode(root: TreeNode?): MutableList<Int> {
        val list = mutableListOf<Int>()
        val queue = LinkedList<TreeNode?>()
        queue.add(root)
        while (!queue.isEmpty()) {
            for (i in 0 until queue.size) {
                val current = queue.poll()
                if (i == 0) list.add(current!!.`val`)
                if (current?.left != null) {
                    queue.add(current.left)
                }
                if (current?.right != null) {
                    queue.add(current.right)
                }
            }
        }
        return list
    }

}

fun main() {
    val root = constructBinaryTree()
    println(LeftViewOfBinaryTree.iterativeUsingQueueGoodCode(root))
}