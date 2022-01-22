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

    fun countOptimal(nums: IntArray, k: Int): IntArray {
        /**
         *  Trick: First only iterate over the first window and add its size to the output array
         *  Then iterate over the rest of items starting k
         *  For each iteration, update the frequency map.  If any frequency becomes 0, remove the item.
         */
        if (k > nums.size) return intArrayOf()
        if (nums.size <= 1) return intArrayOf(nums.size)

        val output = mutableListOf<Int>()

        val map = mutableMapOf<Int, Int>()

        for(i in 0 until k){
            if (map.containsKey(nums[i])) {
                map[nums[i]] = map[nums[i]]!! + 1
            } else {
                map[nums[i]] = 1
            }
        }
        output.add(map.size)
        for(i in k until nums.size) {
            map[nums[i-k]] = map[nums[i-k]]!! - 1
            if(map[nums[i-k]] == 0) map.remove(nums[i-k])

            if (map.containsKey(nums[i])) {
                map[nums[i]] = map[nums[i]]!! + 1
            } else {
                map[nums[i]] = 1
            }

            output.add(map.size)
        }
        return output.toIntArray()
    }
}