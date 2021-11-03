package basics.problems.simple

import java.util.*


class LLinkedList<T>() {
    private var rootNode = NNode<T>()
    fun add(t: T) {
        val nNode = NNode(t)
        if (rootNode.next == null) {
            rootNode.next = nNode
        } else {
            var currNode: NNode<T>? = rootNode
            while (currNode?.next != null) {
                currNode = currNode.next
            }
            currNode?.next = nNode
        }
    }

    override fun toString(): String {
        var currNode: NNode<T>? = rootNode
        val sb = StringBuilder()
        while (currNode != null) {
            sb.append("($currNode)-->")
            currNode = currNode.next
        }
        return sb.toString()
    }
}

class NNode<T>(var data: T? = null, var next: NNode<T>? = null) {
    override fun toString(): String {
        return if (this.data != null) this.data.toString() else "null"
    }
}

fun main() {
    val l = LLinkedList<Int>()
    l.add(2)
    l.add(3)
    println(l)
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        var currNode: ListNode? = this
        val sb = StringBuilder()
        while (currNode != null) {
            sb.append("(${currNode.`val`})-->")
            currNode = currNode.next
        }
        return sb.append("null").toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ListNode

        var thisNode: ListNode? = this
        var otherNode: ListNode? = other

        while (thisNode != null || otherNode != null) {
            if (thisNode?.`val` != otherNode?.`val`) return false

            thisNode = thisNode?.next
            otherNode = otherNode?.next
        }

        return true
    }

    override fun hashCode(): Int {
        return `val`
    }

}

object Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        var cn = head
        var pn: ListNode? = null
        while (cn != null) {
            val nn = cn.next
            cn.next = pn
            pn = cn
            cn = nn
        }
        return pn
    }
}

object ReverseLinkedList {
    fun reverseSinglyLinkedList(linkedList: LinkedList<Int>): LinkedList<Int> {
        val size = linkedList.size
        val array = IntArray(size)
        val iter = linkedList.listIterator()
        while (iter.hasNext()) {
            val element = iter.next()
            val index = iter.nextIndex()
            array[size - index - 1] = element
        }

        val reversedLinkedList = LinkedList<Int>()
        for (i in array) {
            reversedLinkedList.add(i)
        }

        return reversedLinkedList
    }
}

object MxNReverseList {
    fun reverse(node: ListNode, m: Int, n: Int): ListNode? {
        if (m > n) return null

        var currNode: ListNode? = node
        var counter = 1
        var beforeLeft: ListNode? = null

        while (counter < m) {
            beforeLeft = currNode
            currNode = currNode?.next
            counter++
        }

        var prev: ListNode? = null
        var startLeft: ListNode? = currNode

        while (counter in m..n) {
            val next = currNode?.next
            currNode?.next = prev
            prev = currNode
            currNode = next
            counter++
        }

        beforeLeft?.next = prev
        startLeft?.next = currNode

        return if (m > 1) node else prev
    }
}

fun reverse(node: ListNode?): ListNode? {
    if (node == null) return null
    var currNode: ListNode? = node
    var prev: ListNode? = null

    while (currNode != null) {
        val next = currNode.next
        currNode.next = prev
        prev = currNode
        currNode = next
    }

    return prev
}

fun clone(node: ListNode?): ListNode? {
    if (node == null) return null

    var currNode: ListNode? = node.next
    var newListNode: ListNode = ListNode(node.`val`)
    val start = newListNode
    while (currNode != null) {
        val nextNode: ListNode = ListNode(currNode!!.`val`)
        newListNode.next = nextNode
        currNode = currNode?.next
        newListNode = nextNode
    }
    return start
}

// https://leetcode.com/problems/palindrome-linked-list/
object PalindromeLinkedList {

    fun isIt(n: ListNode?): Boolean {


        val reversed = reverse(clone(n))

        TODO()
    }
}