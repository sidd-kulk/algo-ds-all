package basics.geekforgeeks

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BinarySearchTest {

    @Test
    fun search() {
        assertEquals(5,BinarySearch.search(intArrayOf(10,20,30,40,50,60,70), 60))
        assertEquals(0,BinarySearch.search(intArrayOf(10,20,30,40,50,60,70), 10))
        assertEquals(-1,BinarySearch.search(intArrayOf(10,20,30,40,50,60,70), 15))
    }
}