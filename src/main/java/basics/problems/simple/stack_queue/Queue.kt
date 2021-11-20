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
        for (i in stack){
            sb.append("$i -->")
        }
        return sb.toString()
    }
}

fun main() {
    val q = Queue<Int>()
    q.enqueue(4)
    q.dequeue()
    q.enqueue(2)
    q.enqueue(3)
    println(q)
    println(q.peek())

//    val s = Stack<Int>()
//    s.push(1)
//    s.push(2)
//    s.push(3)
//    println(s)
//    println(s.peek())
}