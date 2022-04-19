package basics.geekforgeeks.Trees

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