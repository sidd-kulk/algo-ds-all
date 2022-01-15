package basics.leetcode.subArrayWithKSum

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SubArrayWithKSumTest {

    @Test
    fun `find if the array has a subarray with zero sum`() {
        arrayOf<IntArray>(
            intArrayOf(1, -1),
            intArrayOf(1, -1, 0),
            intArrayOf(1, 4, 13, -3, -10, 5),
            intArrayOf(1, 1, 0)
        ).forEach {
            assertTrue(SubArrayWithKSum.solveBruteForceSelfIncluded(it))
        }

        arrayOf<IntArray>(
            intArrayOf(1, 4, 13, -3, -11, 5),
            intArrayOf(1),
            intArrayOf(1, 1, 1, 1, 1)
        ).forEach {
            assertFalse(SubArrayWithKSum.solveBruteForceSelfIncluded(it))
        }
    }

    @Test
    fun `find if the array has a subarray with K sum excluding self`() {
        arrayOf<Pair<IntArray, Int>>(
            Pair(intArrayOf(1, -1), 0),
            Pair(intArrayOf(1, -1, 0), -1),
            Pair(intArrayOf(1, 4, 13, -3, -10, 5), 18),
            Pair(intArrayOf(1, 1, 0), 2),
        ).forEach {
            assertTrue(SubArrayWithKSum.subArrayWithKSumSelfExcluded(it.first, it.second))
        }

        arrayOf<Pair<IntArray, Int>>(
            Pair(intArrayOf(1, 4, 13, -3, -11, 5), 11),
            Pair(intArrayOf(1), 9),
            Pair(intArrayOf(1, 1, 1, 1, 1), 10),
        ).forEach {
            assertFalse(SubArrayWithKSum.subArrayWithKSumSelfExcluded(it.first, it.second))
        }
    }
}