package basics.leetcode

import kotlin.math.max

object LongestSubArrayLengthWithKSum {
    fun findLengthBruteForce(array: IntArray, k: Int): Int {
        var longest = 0

        for (i in array.indices) {
            var sum = 0
            for (j in i until array.size) {
                sum += array[j]
                if (sum == k) {
                    longest = max(longest, j - i + 1)
                }
            }
        }
        return longest
    }


    fun findLengthOptimal(array: IntArray, k: Int): Int {
        var longest = 0
        val map = mutableMapOf<Int, Int>()
        var prefixSum = 0
        for (i in array.indices) {
            prefixSum += array[i]
            if (prefixSum == k) {
                longest = max(longest, i + 1)
            } else if (map.containsKey(prefixSum - k)) {
                val j = map[prefixSum - k]
                longest = max(longest, i - j!!)
            }
            if (!map.containsKey(prefixSum)) map[prefixSum] = i

        }
        return longest
    }
}