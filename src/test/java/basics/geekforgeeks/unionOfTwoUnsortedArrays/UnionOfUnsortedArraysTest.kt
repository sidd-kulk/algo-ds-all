package basics.geekforgeeks.unionOfTwoUnsortedArrays

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class UnionOfUnsortedArraysTest {

    @Test
    fun `should find union of two unsorted arrays`() {
        var output = UnionOfUnsortedArrays.find(intArrayOf(15,20,5,15), intArrayOf(15,15,15,20,10))
        assertArrayEquals(intArrayOf(15,20,5,10), output)

        output = UnionOfUnsortedArrays.find(intArrayOf(10,12,15), intArrayOf(18,12))
        assertArrayEquals(intArrayOf(10,12,15,18), output)

        output = UnionOfUnsortedArrays.find(intArrayOf(3,3,3,3), intArrayOf(3))
        assertArrayEquals(intArrayOf(3), output)

        output = UnionOfUnsortedArrays.find(intArrayOf(), intArrayOf(3,4))
        assertArrayEquals(intArrayOf(3,4), output)
    }
}