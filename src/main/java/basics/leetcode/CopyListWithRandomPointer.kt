package basics.leetcode

/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 **/

class Node(var `val`: Int, var next: Node? = null, var random: Node? = null)

// https://leetcode.com/problems/copy-list-with-random-pointer/
object CopyListWithRandomPointer {
    private var hs = mutableMapOf<Node?, Node?>()

    private fun cloneNode(node: Node?): Node? {
        return if (node != null) {
            if (hs.containsKey(node)) {
                hs[node]
            } else {
                hs[node] = Node(node.`val`)
                hs[node]
            }
        } else null
    }

    fun copyRandomList(head: Node?): Node? {
        if (head == null) return null
        var curr = head
        var newNodeInstance: Node? = Node(curr.`val`)
        hs[curr] = newNodeInstance

        while (curr != null) {
            newNodeInstance?.random = cloneNode(curr.random)
            newNodeInstance?.next = cloneNode(curr.next)

            curr = curr.next
            newNodeInstance = newNodeInstance?.next
        }
        return hs[head]
    }
}
