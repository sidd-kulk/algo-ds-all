package basics.problems.simple

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class StackUsingArrayTest {

    @Test
    fun testAll(){
        val myStack = StackUsingArray(3)
        myStack.push(5)
        myStack.push(10)
        myStack.push(20)

        assertEquals(20, myStack.pop())
        assertEquals(2, myStack.size())
        assertEquals(10, myStack.peek())
        assertEquals(false, myStack.isEmpty())

        myStack.push(30)
        myStack.push(40)
        myStack.push(50)
        assertEquals(5, myStack.size())
    }
}