package basics.problems.simple.leetcode

object BinaryTrees {
    val list = mutableListOf<String>()
    fun sumRootToLeaf(node: INode<Int>?, acc: String): String {
        println(acc)
        if(node == null) {
            println("node is null")
            return acc
        }
        var acc1 = acc + node.data
        if(node.left != null) {
            println("left: $acc1, ${node.data}")
            acc1 += sumRootToLeaf(node.left, acc1)
        }

        var acc2 = acc + node.data
        if(node.right != null) {
            println("right: $acc2, ${node.data}")
            acc2 += sumRootToLeaf(node.right, acc2)
        }

        println("acc1 = $acc1, acc2 = $acc2")
        return ""
    }

    fun sumRootToLeaf1(node: INode<Int>?, acc: String): String {
//        println(acc)
        if(node == null) {
            println("node is null")
            return acc
        }

        val acc1 = acc + node.data
        println("acc1 = $acc1")
        val x = sumRootToLeaf1(node.left, acc1)
        val y = sumRootToLeaf1(node.right, acc1)
//        println("x = $x, y = $y")

        list.add(x)
        list.add(y)
        println("list = $list")
        return ""
//        var acc1 = acc + node.data
//        if(node.left != null) {
////            println("left: $acc1, ${node.data}")
//            acc1 += sumRootToLeaf1(node.left, acc1)
//        }
//
//        var acc2 = acc + node.data
//        if(node.right != null) {
////            println("right: $acc2, ${node.data}")
//            acc2 += sumRootToLeaf1(node.right, acc2)
//        }
//
//        println("acc1 = $acc1, acc2 = $acc2")
//        return acc1
    }
}

fun main() {
    val iNode = createINodes()
    BTreePrinter.printNode(iNode)
    println(BinaryTrees.sumRootToLeaf1(iNode, ""))
}

object BTreePrinterTest {
    fun test1(): INode<Int> {
        val root = INode(2)
        val n11 = INode(7)
        val n12 = INode(5)
        val n21 = INode(2)
        val n22 = INode(6)
        val n23 = INode(3)
        val n24 = INode(6)
        val n31 = INode(5)
        val n32 = INode(8)
        val n33 = INode(4)
        val n34 = INode(5)
        val n35 = INode(8)
        val n36 = INode(4)
        val n37 = INode(5)
        val n38 = INode(8)
        root.left = n11
        root.right = n12
        n11.left = n21
        n11.right = n22
        n12.left = n23
        n12.right = n24
        n21.left = n31
        n21.right = n32
        n22.left = n33
        n22.right = n34
        n23.left = n35
        n23.right = n36
        n24.left = n37
        n24.right = n38
        return root
    }

    private fun test2(): INode<Int> {
        val root = INode(2)
        val n11 = INode(7)
        val n12 = INode(5)
        val n21 = INode(2)
        val n22 = INode(6)
        val n23 = INode(9)
        val n31 = INode(5)
        val n32 = INode(8)
        val n33 = INode(4)
        root.left = n11
        root.right = n12
        n11.left = n21
        n11.right = n22
        n12.right = n23
        n22.left = n31
        n22.right = n32
        n23.left = n33
        return root
    }
}

class INode<T : Comparable<*>?>(var data: T) {
    var left: INode<T>? = null
    var right: INode<T>? = null
}

fun createINodes(size: Int = 3): INode<Int> {
    val root = INode(1)
    var currINode: INode<Int>? = root
    for (i in 2..size) {
        val leftNode = INode(i)
        val rightNode = INode(i + 1)
        currINode?.left = leftNode
        currINode?.right = rightNode
        currINode = currINode?.left
    }
    println(root.toString())
    return root
}

object BTreePrinter {
    fun <T : Comparable<*>?> printNode(root: INode<T>?) {
        val maxLevel = maxLevel(root)
        printNodeInternal(listOf(root), 1, maxLevel)
    }

    private fun <T : Comparable<*>?> printNodeInternal(INodes: List<INode<T>?>, level: Int, maxLevel: Int) {
        if (INodes.isEmpty() || isAllElementsNull(INodes)) return
        val floor = maxLevel - level
        val endgeLines = Math.pow(2.0, Math.max(floor - 1, 0).toDouble()).toInt()
        val firstSpaces = Math.pow(2.0, floor.toDouble()).toInt() - 1
        val betweenSpaces = Math.pow(2.0, (floor + 1).toDouble()).toInt() - 1
        printWhitespaces(firstSpaces)
        val newINodes: MutableList<INode<T>?> = ArrayList()
        for (node in INodes) {
            if (node != null) {
                print(node.data)
                newINodes.add(node.left)
                newINodes.add(node.right)
            } else {
                newINodes.add(null)
                newINodes.add(null)
                print(" ")
            }
            printWhitespaces(betweenSpaces)
        }
        println("")
        for (i in 1..endgeLines) {
            for (j in INodes.indices) {
                printWhitespaces(firstSpaces - i)
                if (INodes[j] == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1)
                    continue
                }
                if (INodes[j]!!.left != null) print("/") else printWhitespaces(1)
                printWhitespaces(i + i - 1)
                if (INodes[j]!!.right != null) print("\\") else printWhitespaces(1)
                printWhitespaces(endgeLines + endgeLines - i)
            }
            println("")
        }
        printNodeInternal(newINodes, level + 1, maxLevel)
    }

    private fun printWhitespaces(count: Int) {
        for (i in 0 until count) print(" ")
    }

    private fun <T : Comparable<*>?> maxLevel(INode: INode<T>?): Int {
        return if (INode == null) 0 else Math.max(maxLevel(INode.left), maxLevel(INode.right)) + 1
    }

    private fun <T> isAllElementsNull(list: List<T?>): Boolean {
        for (`object` in list) {
            if (`object` != null) return false
        }
        return true
    }
}