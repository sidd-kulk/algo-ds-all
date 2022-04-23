package basics.geekforgeeks.trees

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ChildrenSumPropertyBinaryTreeTest {

    @Test
    fun validate() {
        val root = constructTree()
        assertTrue(ChildrenSumPropertyBinaryTree.validate(root))

        val root1 = TreeNode(1)
        assertTrue(ChildrenSumPropertyBinaryTree.validate(root1))

        val root2 = TreeNode(3)
        root2.left = TreeNode(3)
        root2.right = TreeNode(3)
        assertFalse(ChildrenSumPropertyBinaryTree.validate(root2))
    }

    @Test
    fun validateBetter() {
        val root = constructTree()
        assertTrue(ChildrenSumPropertyBinaryTree.validateBetter(root))

        val root1 = TreeNode(1)
        assertTrue(ChildrenSumPropertyBinaryTree.validateBetter(root1))

        val root2 = TreeNode(3)
        root2.left = TreeNode(3)
        root2.right = TreeNode(3)
        assertFalse(ChildrenSumPropertyBinaryTree.validateBetter(root2))
    }

    private fun constructTree(): TreeNode {
        val root = TreeNode(10)
        root.left = TreeNode(5)
        root.left?.left = TreeNode(2)
        root.left?.right = TreeNode(3)

        root.right = TreeNode(5)
        root.right?.left = TreeNode(2)
        root.right?.right = TreeNode(3)
        return root
    }
}