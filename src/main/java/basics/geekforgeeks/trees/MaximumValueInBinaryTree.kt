package basics.geekforgeeks.trees

import basics.problems.simple.stack_queue.Queue

object MaximumValueInBinaryTree {
    fun findRecursive(root: TreeNode?): TreeNode? {
        if (root == null) return TreeNode(Int.MIN_VALUE)

        val left = findRecursive(root.left)
        val right = findRecursive(root.right)
        val max = if (left!!.`val` > right!!.`val`) left else right
        return if (max.`val` > root.`val`) max else root
    }

    fun findIterative(root: TreeNode?): TreeNode? {
        val queue = Queue<TreeNode?>()
        queue.enqueue(root)
        var maxValue = root
        while (!queue.empty()) {
            val current = queue.dequeue()
            if (current!!.`val` > maxValue!!.`val`) {
                maxValue = current
            }
            if (current.left != null) {
                queue.enqueue(current.left)
            }

            if (current.right != null) {
                queue.enqueue(current.right)
            }
        }
        return maxValue
    }
}