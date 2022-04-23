package basics.geekforgeeks.trees

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class MaximumValueInBinaryTreeTest {

    @Test
    fun find() {
        val root = constructTestBinaryTree()
        Assertions.assertEquals(8, MaximumValueInBinaryTree.findRecursive(root)?.`val`)
        Assertions.assertEquals(8, MaximumValueInBinaryTree.findIterative(root)?.`val`)
    }

    private fun constructTestBinaryTree(): TreeNode {
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
}