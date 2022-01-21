package basics.leetcode.longestConsecutiveSubsequence

import kotlin.math.max

object LongestConsecutiveSubsequence {
    fun lengthBruteForce(nums: IntArray): Int {
        if (nums.size <= 1) return nums.size

        val sorted = nums.sorted()
        var maxLength = 1
        var length = 1
        for (i in 1 until sorted.size) {
            if (sorted[i] == sorted[i - 1]) {
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

    fun lengthOptimal(nums: IntArray): Int { // O(n) lookups coz watch geek for geek video.  It's weird.
        if (nums.size <= 1) return nums.size
        var longest = 1
        val set = nums.toSet()
        for (i in set) {
            var count = 1
            if (!set.contains(i - 1)) {
                var j = i
                while (set.contains(++j)) {
                    count++
                }
            }
            longest = max(longest, count)
        }

        return longest
    }
}