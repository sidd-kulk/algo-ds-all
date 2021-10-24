package basics.problems.simple

import java.util.*


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

fun main() {
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