package basics.problems.simple

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PalindromeLinkedListTest {

    @Test
    fun `should reverse LinkedList`() {
        val listNode = createLinkedList()
        val reversedListNode = reverse(clone(listNode))
        val reReversedLinkedNode = reverse(reversedListNode)
        assertEquals(listNode, reReversedLinkedNode)
    }

    @Test
    fun `should clone LinkedList`() {
        val listNode = createLinkedList()
        val clonedListNode = clone(listNode)
        assertEquals(listNode, clonedListNode)
        assertFalse(listNode === clonedListNode)
    }

    @Test
    fun isIt() {
        fun `should return false for negative case`() {
            val node = createLinkedList()
            assertFalse(PalindromeLinkedList.isIt(node))
        }

        fun `should return true for list 1 - 3 - 3 - 1`() {
            var node = ListNode(1)
            var rootNode = node
            for(i in arrayOf(3,3,1)){
                val newNode = ListNode(i)
                node.next = newNode
                node = newNode
            }
            assertTrue(PalindromeLinkedList.isIt(rootNode))
        }
        `should return false for negative case`()
        `should return true for list 1 - 3 - 3 - 1`()
    }

    private fun createLinkedList(size: Int = 5): ListNode? {
        if (size <= 0) return null

        var firstNode: ListNode? = ListNode(1)
        val rootNode = firstNode
        for (i in 2..size) {
            firstNode?.next = ListNode(i)
            firstNode = firstNode?.next
        }

        return rootNode
    }
}