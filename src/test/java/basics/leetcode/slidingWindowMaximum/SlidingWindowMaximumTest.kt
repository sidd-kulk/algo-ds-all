package basics.leetcode.slidingWindowMaximum

import basics.geekforgeeks.SlidingWindowDistinctNumbers
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SlidingWindowMaximumTest {

    @Test
    fun countBruteForce() {
        arrayOf(
            Triple(intArrayOf(20,30,40,40), intArrayOf(10,20,20,10,30,40,10), 4),
            Triple(intArrayOf(10,10), intArrayOf(10,10,10,10), 3),
            Triple(intArrayOf(10,20,20), intArrayOf(10,10,5,3,20,5), 4),
            Triple(intArrayOf(1,-1), intArrayOf(1,-1), 1),
            Triple(intArrayOf(), intArrayOf(), 4),
            Triple(intArrayOf(1), intArrayOf(1), 1)
        ).forEach {
            assertArrayEquals(it.first, SlidingWindowMaximum.countBruteForce(it.second, it.third))
        }
    }
}