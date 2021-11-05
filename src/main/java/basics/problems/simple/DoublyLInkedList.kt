package basics.problems.simple

class DoublyLInkedListNode(val `val`: Int) {
    var prev: DoublyLInkedListNode? = null
    var next: DoublyLInkedListNode? = null
    var child: DoublyLInkedListNode? = null
    override fun toString(): String {
        return this.`val`.toString()
    }
}

typealias Node = DoublyLInkedListNode

// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
object FlattenHierarchy {
    fun flatten(root: Node?): Node? {
        var currNode: Node? = root
        while (currNode != null) {
            if (currNode.child != null) {
                var childNode: Node? = currNode.child
                while (childNode?.next != null) {
                    childNode = childNode.next
                }
                val next = currNode.next
                val child = currNode.child
                childNode?.next = next
                next?.prev = childNode
                currNode.next = child
                child?.prev = currNode
                currNode.child = null
            }
            currNode = currNode.next
        }
        return root
    }
}

fun main() {
    val root: Node = Node(1)
    root.next = Node(2)
    root.next?.next = Node(3)
    val n = root.next
    n?.child = Node(4)
    val c = n?.child
    c?.next = Node(5)
    c?.next?.next = Node(6)
    val a = c?.next?.next
    a?.child = Node(7)

    FlattenHierarchy.flatten(root)
}