package basics.leetcode.longestConsecutiveSubsequence

import kotlin.math.max

object LongestConsecutiveSubsequence {
    fun lengthBruteForce(nums: IntArray): Int {
        if (nums.size <= 1) return nums.size

        val sorted = nums.sorted()
        var maxLength = 1
        var length = 1
        for (i in 1 until sorted.size) {
            if(sorted[i] == sorted[i-1]) {
                maxLength = max(maxLength, length)
                continue
            }
            if (sorted[i] == 1 + sorted[i - 1]) {
                length++
            } else {
                maxLength = max(maxLength, length)
                length = 1
            }
        }
        return max(maxLength, length)
    }
}