package basics.leetcode

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class LongestSubArrayLengthWithKSumTest {

    @Test
    fun findLengthBruteForce() {
        assertEquals(3, LongestSubArrayLengthWithKSum.findLengthBruteForce(intArrayOf(5,8,-4,-4,9,-2,-2), 0))
        assertEquals(4, LongestSubArrayLengthWithKSum.findLengthBruteForce(intArrayOf(3,1,0,1,8,2,3,6), 5))
        assertEquals(0, LongestSubArrayLengthWithKSum.findLengthBruteForce(intArrayOf(8,3,7), 15))
        assertEquals(4, LongestSubArrayLengthWithKSum.findLengthBruteForce(intArrayOf(8,3,1,5,-6,6,2,2), 4))
    }

    @Test
    fun findLengthOptimal() {
        assertEquals(3, LongestSubArrayLengthWithKSum.findLengthOptimal(intArrayOf(5,8,-4,-4,9,-2,-2), 0))
        assertEquals(4, LongestSubArrayLengthWithKSum.findLengthOptimal(intArrayOf(3,1,0,1,8,2,3,6), 5))
        assertEquals(0, LongestSubArrayLengthWithKSum.findLengthOptimal(intArrayOf(8,3,7), 15))
        assertEquals(4, LongestSubArrayLengthWithKSum.findLengthOptimal(intArrayOf(8,3,1,5,-6,6,2,2), 4))
    }
}