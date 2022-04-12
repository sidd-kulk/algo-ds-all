package basics.problems.simple.stack_queue

import java.util.*

// https://leetcode.com/problems/implement-queue-using-stacks/
class Queue<T> { // Using Stacks
    private var stack = Stack<T>()

    fun enqueue(t: T) {
        val temp = Stack<T>()
        while (!stack.empty()) {
            temp.push(stack.pop())
        }
        stack.push(t)
        while (!temp.empty()) {
            stack.push(temp.pop())
        }
    }

    fun dequeue(): T {
        return stack.pop()
    }

    fun peek(): T {
        return stack.peek()
    }

    fun empty(): Boolean {
        return stack.size == 0
    }

    override fun toString(): String {
        val sb = StringBuilder()
        for (i in stack) {
            sb.append("$i -->")
        }
        return sb.toString()
    }
}

class QueueUsingLinkedList<T> {
    private val linkedList = LinkedList<T>()

    var front: T? = null
        get() = field

    var rear: T? = null
        get() = field


    fun enqueue(ele: T) {
        if (this.isEmpty()) front = ele
        linkedList.add(ele)

        rear = ele
    }

    fun dequeue(): T? {
        if (this.isEmpty()) return null

        val popped = linkedList.pop()
        front = linkedList.peek()
        return popped
    }

    fun isEmpty(): Boolean {
        return linkedList.isEmpty()
    }

    fun size(): Int {
        return linkedList.size
    }

    fun peek(): T? {
        if (this.isEmpty()) return null
        return linkedList.peek()
    }

    override fun toString(): String {
        return linkedList.joinToString(",")
    }
}

fun main() {
    val q = QueueUsingLinkedList<Int>()
//    q.enqueue(4)
//    q.enqueue(2)
//    q.enqueue(3)
    q.dequeue()
    println(q)
    println(q.rear)
    println(q.front)
    println(q.peek())

//    val s = Stack<Int>()
//    s.push(1)
//    s.push(2)
//    s.push(3)
//    println(s)
//    println(s.peek())
}