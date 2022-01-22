package basics.leetcode.slidingWindowMaximum

import kotlin.math.max

object SlidingWindowMaximum {
    fun countBruteForce(nums: IntArray, k: Int): IntArray {
        if (k > nums.size) return intArrayOf()
        if (nums.size <= 1) return intArrayOf(nums.size)

        val noOfWindows = nums.size - k + 1
        val output = mutableListOf<Int>()
        for (i in 0 until noOfWindows) {
            var max = nums[i]
            for (j in i until i + k){
                max = max(max, nums[j])
            }
            output.add(max)
        }
        return output.toIntArray()
    }
}