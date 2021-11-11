package basics.problems.simple.`stack-queue`

import java.util.*

class Stack<T> {
    private val linkedList = LinkedList<T>()
    fun push(t: T) {
        linkedList.add(0, t)
    }

    fun pop(): T {
        return linkedList.remove()
    }

    fun size(): Int {
        return linkedList.size
    }
}