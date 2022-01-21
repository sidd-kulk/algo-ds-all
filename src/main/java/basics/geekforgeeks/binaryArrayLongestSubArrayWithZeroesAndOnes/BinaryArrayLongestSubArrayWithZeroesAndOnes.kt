package basics.geekforgeeks.binaryArrayLongestSubArrayWithZeroesAndOnes

import kotlin.math.max

/**
 * Given an array of 1s and 0s, find the length of the maximum
 * subarray with equal number of 1s and 0s.
 * E.g. [1,0,1,1,1,0,0] ==> 6 (The last 6)
 *      [1,1,1,1] ==> 0 (No 0s)
 *      [0,0,1,1,1,1,1,0] ==> 4 (first 4)
 *      [0,0,1,0,1,1] ==> 6 (entire array is a subarray with same no. of 0s and 1s)
 */
object BinaryArrayLongestSubArrayWithZeroesAndOnes {
    fun countBruteForce(binaryArray: IntArray): Int {
        var longest = 0

        for (i in binaryArray.indices) {
            var count1s = 0
            var count0s = 0
            for (j in i until binaryArray.size) {
                if (binaryArray[j] == 1) {
                    count1s++
                } else {
                    count0s++
                }

                if (count1s == count0s) {
                    longest = kotlin.math.max(longest, count0s + count1s)
                }
            }
        }
        return longest
    }

    fun countOptimal(binaryArray: IntArray): Int {
        // Hack is to replace all the 0s with -1  1,0,1,1,1,0,0
        val newArray = binaryArray.map {
            if (it == 0) -1 else it
        } // 1,-1,1,1,1,-1,-1
        var longest = 0
        var map = mutableMapOf<Int, Int>()
        var prefixSum = 0
        for (i in newArray.indices) {
            prefixSum += newArray[i]
            if (prefixSum == 0) {
                longest = i + 1
            } else if (map.containsKey(prefixSum)) {
                val j = map[prefixSum]
                longest = max(longest, i - j!!)
            }
            if (!map.containsKey(prefixSum)) map[prefixSum] = i
        }
        return longest
    }
}