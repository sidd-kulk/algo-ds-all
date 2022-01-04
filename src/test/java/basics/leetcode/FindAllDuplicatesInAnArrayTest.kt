package basics.leetcode

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class FindAllDuplicatesInAnArrayTest {

    @Test
    fun `should find number that repeats in the array using brute force approach`() {
        assertArrayEquals(intArrayOf(1,2), FindAllDuplicatesInAnArray.findBruteForce(intArrayOf(1,1,2,2)).toIntArray())
        assertArrayEquals(intArrayOf(1,2), FindAllDuplicatesInAnArray.findBruteForce(intArrayOf(1,1,2,2,0)).toIntArray())
        assertArrayEquals(intArrayOf(), FindAllDuplicatesInAnArray.findBruteForce(intArrayOf(1,2,0)).toIntArray())
        assertArrayEquals(intArrayOf(), FindAllDuplicatesInAnArray.findBruteForce(intArrayOf()).toIntArray())
    }
}