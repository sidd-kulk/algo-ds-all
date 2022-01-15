package basics.leetcode.subArrayWithKSum

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SubArrayWithZeroSumTest {

    @Test
    fun `find if the array has a subarray with zero sum`() {
        assertTrue(SubArrayWithKSum.solveBruteForceSelfIncluded(intArrayOf(1,-1)))
        assertTrue(SubArrayWithKSum.solveBruteForceSelfIncluded(intArrayOf(1,-1, 0)))
        assertTrue(SubArrayWithKSum.solveBruteForceSelfIncluded(intArrayOf(1,4,13,-3,-10,5)))
        assertTrue(SubArrayWithKSum.solveBruteForceSelfIncluded(intArrayOf(1,1,0)))

        assertFalse(SubArrayWithKSum.solveBruteForceSelfIncluded(intArrayOf(1,4,13,-3,-11,5)))
        assertFalse(SubArrayWithKSum.solveBruteForceSelfIncluded(intArrayOf(1)))
        assertFalse(SubArrayWithKSum.solveBruteForceSelfIncluded(intArrayOf(1,1,1,1,1)))
    }

    @Test
    fun `find if the array has a subarray with K sum excluding self`() {
        assertTrue(SubArrayWithKSum.subArrayWithKSumSelfExcluded(intArrayOf(1,-1), 0))
        assertTrue(SubArrayWithKSum.subArrayWithKSumSelfExcluded(intArrayOf(1,-1, 0), -1))
        assertTrue(SubArrayWithKSum.subArrayWithKSumSelfExcluded(intArrayOf(1,4,13,-3,-10,5), 18))
        assertTrue(SubArrayWithKSum.subArrayWithKSumSelfExcluded(intArrayOf(1,1,0), 2))

        assertFalse(SubArrayWithKSum.subArrayWithKSumSelfExcluded(intArrayOf(1,4,13,-3,-11,5), 11))
        assertFalse(SubArrayWithKSum.subArrayWithKSumSelfExcluded(intArrayOf(1), 9))
        assertFalse(SubArrayWithKSum.subArrayWithKSumSelfExcluded(intArrayOf(1,1,1,1,1), 10))
    }
}