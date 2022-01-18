package basics.leetcode.subArrayWithKSum

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class LongestSubArrayWithKSumTest {

    @Test
    fun `should find longest subarray with sum K`() {
        arrayOf(
            Triple(intArrayOf(8,3,1,5,-6,6,2,2), 4, 4),
            Triple(intArrayOf(5, -10, 7, -10, 8), -5, 4),
            Triple(intArrayOf(5, -10, 7, -10, 8), 5, 3),
            Triple(intArrayOf(5,0,0,1), 6, 4),
            Triple(intArrayOf(5,8,1,2,6,7,-7,3), 3, 3)
        ).forEach {
            assertEquals(it.third, LongestSubArrayWithKSum.find(it.first, it.second))
        }
    }
}