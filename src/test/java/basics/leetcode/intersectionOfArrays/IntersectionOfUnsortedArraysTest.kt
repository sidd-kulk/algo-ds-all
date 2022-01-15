package basics.leetcode.intersectionOfArrays

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class IntersectionOfUnsortedArraysTest {

    @Test
    fun `should return intersection of arrays`() {
        var output = IntersectionOfUnsortedArrays.find(intArrayOf(10,15,20,5,30), intArrayOf(30,5,30,80))
        assertArrayEquals(intArrayOf(30, 5), output)

        output = IntersectionOfUnsortedArrays.find(intArrayOf(10,20), intArrayOf(20,30))
        assertArrayEquals(intArrayOf(20), output)
    }
}