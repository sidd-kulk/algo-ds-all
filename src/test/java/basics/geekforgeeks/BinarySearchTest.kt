package basics.geekforgeeks

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BinarySearchTest {

    @Test
    fun iterative() {
        assertEquals(5,BinarySearch.iterative(intArrayOf(10,20,30,40,50,60,70), 60))
        assertEquals(0,BinarySearch.iterative(intArrayOf(10,20,30,40,50,60,70), 10))
        assertEquals(-1,BinarySearch.iterative(intArrayOf(10,20,30,40,50,60,70), 15))
    }

    @Test
    fun recursive() {
        assertEquals(5,BinarySearch.recursive(intArrayOf(10,20,30,40,50,60,70), 60))
        assertEquals(0,BinarySearch.recursive(intArrayOf(10,20,30,40,50,60,70), 10))
        assertEquals(-1,BinarySearch.recursive(intArrayOf(10,20,30,40,50,60,70), 15))
    }
}