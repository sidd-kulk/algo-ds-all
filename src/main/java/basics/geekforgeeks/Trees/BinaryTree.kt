package basics.geekforgeeks.Trees

import basics.problems.simple.stack_queue.Queue

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return `val`.toString()
    }
}

fun levelOrderTraversalBruteForce(root: TreeNode) {
    fun inner(node: TreeNode?, map: MutableMap<Int, MutableList<Int>>, index: Int): MutableMap<Int, MutableList<Int>> {
        if (node == null) {
            return map
        }

        val list = map.getOrDefault(index, mutableListOf())
        list.add(node.`val`)
        map[index] = list

        inner(node.left, map, index + 1)
        inner(node.right, map, index + 1)
        return map
    }

    val map = inner(root, mutableMapOf(), 0)
    var counter = 0
    while (map[counter] != null) {
        print(map[counter++]?.joinToString(",") + ",")
    }
}

fun levelOrderTraversalUsingQueue(root: TreeNode?): MutableList<TreeNode?> {
    val queue = Queue<TreeNode?>()
    val list = mutableListOf<TreeNode?>()
    queue.enqueue(root)
    while (!queue.empty()) {
        val current = queue.dequeue()
        list.add(current)
        if (current?.left != null) {
            queue.enqueue(current.left)
        }
        if (current?.right != null) {
            queue.enqueue(current.right)
        }
    }
    return list
}

fun levelOrderTraversalNewLinesWithQueueWithNullMarker(root: TreeNode?) {
    val queue = Queue<TreeNode?>()
    queue.enqueue(root)
    queue.enqueue(null)
    while (queue.size() > 1) {
        val current = queue.dequeue()
        if (current == null) {
            print("\n")
            queue.enqueue(null)
            continue
        }
        print("$current,")
        if (current.left != null) {
            queue.enqueue(current.left)
        }
        if (current.right != null) {
            queue.enqueue(current.right)
        }
    }
}

fun levelOrderTraversalNewLinesWithQueueWithoutNullMarker(root: TreeNode?) {
    val queue = Queue<TreeNode?>()
    queue.enqueue(root)
    while (!queue.empty()) {
        for (i in 0 until queue.size()) {
            val current = queue.dequeue()
            print("$current,")
            if (current?.left != null) {
                queue.enqueue(current.left)
            }
            if (current?.right != null) {
                queue.enqueue(current.right)
            }
        }
        println()
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(6)

    root.right = TreeNode(4)
    root.right?.right = TreeNode(5)
    root.right?.left = TreeNode(7)
    root.right?.left?.right = TreeNode(8)

//    levelOrderTraversalUsingQueue(root)
    levelOrderTraversalNewLinesWithQueueWithNullMarker(root)
    levelOrderTraversalNewLinesWithQueueWithoutNullMarker(root)
}