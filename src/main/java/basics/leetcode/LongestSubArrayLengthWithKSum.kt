package basics.leetcode

import kotlin.math.max

object LongestSubArrayLengthWithKSum {
    fun findLengthBruteForce(array: IntArray, k: Int): Int {
        var longest = 0

        for(i in array.indices){
            var sum = 0
            for(j in i until array.size) {
                sum += array[j]
                if(sum == k){
                    longest = max(longest, j - i + 1)
                }
            }
        }
        return longest
    }
}