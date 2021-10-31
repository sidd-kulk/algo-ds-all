package basics.problems.simple

import java.util.*


class LLinkedList<T>() {
    private var rootNode = NNode<T>()
    fun add(t: T) {
        val nNode = NNode(t)
        if(rootNode.next == null) {
            rootNode.next = nNode
        } else {
            var currNode: NNode<T>? = rootNode
            while(currNode?.next != null) {
                currNode = currNode.next
            }
            currNode?.next = nNode
        }
    }

    override fun toString(): String {
        var currNode: NNode<T>? = rootNode
        val sb = StringBuilder()
        while(currNode != null) {
            sb.append("($currNode)-->")
            currNode = currNode.next
        }
        return sb.toString()
    }
}

class NNode<T>(var data: T? = null, var next: NNode<T>? = null) {
    override fun toString(): String {
        return if(this.data != null) this.data.toString() else "null"
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
}

object Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if(head?.next == null) return head

        var cn = head
        var pn: ListNode? = null
        while(cn != null) {
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