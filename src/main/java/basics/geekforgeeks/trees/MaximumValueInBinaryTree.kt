package basics.geekforgeeks.trees

object MaximumValueInBinaryTree {
    fun find(root: TreeNode?): TreeNode? {
        if(root == null) return TreeNode(Int.MIN_VALUE)

        val left = find(root.left)
        val right = find(root.right)
        val max = if(left!!.`val` > right!!.`val`) left else right
        return if(max.`val` > root.`val`) max else root
    }
}