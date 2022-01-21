package basics.geekforgeeks

object SlidingWindowDistinctNumbers {
    fun countBruteForce(nums: IntArray, k: Int): IntArray {
        if (k > nums.size) return intArrayOf()
        if (nums.size <= 1) return intArrayOf(nums.size)
        val noOfWindows = nums.size - k + 1

        val output = mutableListOf<Int>()

        for (i in 0 until noOfWindows) {
            val set = mutableSetOf<Int>()
            for (j in i until i + k) {
                set.add(nums[j])
            }
            output.add(set.size)
        }

        return output.toIntArray()
    }
}