package basics.geekforgeeks.longestConsecutiveSubsequence

import basics.leetcode.longestConsecutiveSubsequence.LongestConsecutiveSubsequence
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class LongestConsecutiveSubsequenceTest {

    @Test
    fun lengthBruteForce() {
        arrayOf(
            Pair(intArrayOf(), 0),
            Pair(intArrayOf(1), 1),
            Pair(intArrayOf(1, 9, 3, 4, 2, 20), 4),
            Pair(intArrayOf(8,20,7,30), 2),
            Pair(intArrayOf(20,30,40), 1),
            Pair(intArrayOf(0,3,7,2,5,8,4,6,0,1), 9),
            Pair(intArrayOf(1,2,0,1), 3),
            Pair(intArrayOf(9,1,4,7,3,-1,0,5,8,-1,6), 7)
        ).forEach {
            assertEquals(it.second, LongestConsecutiveSubsequence.lengthBruteForce(it.first))
        }
    }

    @Test
    fun lengthOptimal() {
        arrayOf(
            Pair(intArrayOf(), 0),
            Pair(intArrayOf(1), 1),
            Pair(intArrayOf(1, 9, 3, 4, 2, 20), 4),
            Pair(intArrayOf(8,20,7,30), 2),
            Pair(intArrayOf(20,30,40), 1),
            Pair(intArrayOf(0,3,7,2,5,8,4,6,0,1), 9),
            Pair(intArrayOf(1,2,0,1), 3),
            Pair(intArrayOf(9,1,4,7,3,-1,0,5,8,-1,6), 7)
        ).forEach {
            assertEquals(it.second, LongestConsecutiveSubsequence.lengthOptimal(it.first))
        }
    }
}