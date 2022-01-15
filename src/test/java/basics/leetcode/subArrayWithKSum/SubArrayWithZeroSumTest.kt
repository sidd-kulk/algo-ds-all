package basics.leetcode.subArrayWithKSum

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SubArrayWithZeroSumTest {

    @Test
    fun `find if the array has a subarray with zero sum`() {
        assertTrue(SubArrayWithZeroSum.solveBruteForce(intArrayOf(1,-1)))
        assertTrue(SubArrayWithZeroSum.solveBruteForce(intArrayOf(1,-1, 0)))
        assertTrue(SubArrayWithZeroSum.solveBruteForce(intArrayOf(1,4,13,-3,-10,5)))
        assertTrue(SubArrayWithZeroSum.solveBruteForce(intArrayOf(1,1,0)))

        assertFalse(SubArrayWithZeroSum.solveBruteForce(intArrayOf(1,4,13,-3,-11,5)))
        assertFalse(SubArrayWithZeroSum.solveBruteForce(intArrayOf(1)))
        assertFalse(SubArrayWithZeroSum.solveBruteForce(intArrayOf(1,1,1,1,1)))
    }
}