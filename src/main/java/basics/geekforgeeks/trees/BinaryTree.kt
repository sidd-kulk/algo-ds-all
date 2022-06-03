package basics.geekforgeeks.trees

import basics.Utils
import basics.problems.simple.stack_queue.Queue
import com.sun.source.tree.Tree
import java.lang.reflect.Method
import java.math.BigInteger
import java.security.MessageDigest
import java.util.concurrent.ThreadLocalRandom
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext
import kotlin.math.abs
import kotlin.random.Random
import kotlin.system.exitProcess

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return `val`.toString()
    }
}

fun closest(root: TreeNode, target: Int): Int {
    TODO()
}

fun min(root: TreeNode?): Int {
    if (root == null) return Int.MAX_VALUE

    val leftMin = min(root.left)
    val rightMin = min(root.right)

    return Utils.min(root.`val`, leftMin, rightMin)
}

fun max(root: TreeNode?): Int {
    if (root == null) return Int.MIN_VALUE

    val leftMin = max(root.left)
    val rightMin = max(root.right)

    return Utils.max(root.`val`, leftMin, rightMin)
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
    val root = constructBinaryTree()
    println(closest(root, 5))

}

fun md5(input: String): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
}

fun constructBinaryTree(): TreeNode {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(6)

    root.right = TreeNode(4)
    root.right?.right = TreeNode(5)
    root.right?.left = TreeNode(7)
    root.right?.left?.right = TreeNode(8)

    return root
}

fun randomString(length: Int = 100): String {
    val charPool: List<Char> = listOf<Char>() + ('a'..'z')
    return (1..length)
        .map { kotlin.random.Random.nextInt(0, charPool.size) }
        .map(charPool::get)
        .joinToString("");
}

//        thread {
//            val STRING_LENGTH = 30000
//
//            for (i in 0 until 30000) {
//
//            }
//        }
