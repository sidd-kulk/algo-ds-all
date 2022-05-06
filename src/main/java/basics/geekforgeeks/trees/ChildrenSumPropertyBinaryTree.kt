package basics.geekforgeeks.trees

object ChildrenSumPropertyBinaryTree {
    fun validate(root: TreeNode?): Boolean {
        var isValid = true
        fun subTreeSum(node: TreeNode?): Int {
            if (node == null) return 0
            if (node.left == null && node.right == null) return node.`val`

            val sum = subTreeSum(node.left) + subTreeSum(node.right)
            if (sum != node.`val`) {
                isValid = false
            }
            return sum
        }
        subTreeSum(root)
        return isValid
    }

    fun validateBetter(root: TreeNode?): Boolean {
        if (root == null) return true
        if (root.left == null && root.right == null) return true

        var sum = 0
        if (root.left != null) sum += root.left!!.`val`

        if (root.right != null) sum += root.right!!.`val`

        return (sum == root.`val` && validateBetter(root.left) && validateBetter(root.right))
    }
}