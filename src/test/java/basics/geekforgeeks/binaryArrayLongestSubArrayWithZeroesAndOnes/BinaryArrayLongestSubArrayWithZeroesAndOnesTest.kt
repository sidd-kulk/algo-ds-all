package basics.geekforgeeks.binaryArrayLongestSubArrayWithZeroesAndOnes

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BinaryArrayLongestSubArrayWithZeroesAndOnesTest {

    @Test
//    [1,1,1,1] ==> 0 (No 0s)
//    *      [0,0,1,1,1,1,1,0] ==> 4 (first 4)
//    *      [0,0,1,0,1,1] ==> 6 (entire array is a subarray with same no. of 0s and 1s)
    fun countBruteForce() {
        assertEquals(6, BinaryArrayLongestSubArrayWithZeroesAndOnes.countBruteForce(intArrayOf(1,0,1,1,1,0,0)))
        assertEquals(0, BinaryArrayLongestSubArrayWithZeroesAndOnes.countBruteForce(intArrayOf(1,1,1,1)))
        assertEquals(4, BinaryArrayLongestSubArrayWithZeroesAndOnes.countBruteForce(intArrayOf(0,0,1,1,1,1,1,0)))
        assertEquals(6, BinaryArrayLongestSubArrayWithZeroesAndOnes.countBruteForce(intArrayOf(0,0,1,0,1,1)))
    }
}