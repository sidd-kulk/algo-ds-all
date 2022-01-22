package basics.geekforgeeks

object CountMoreThanNByKOccurrences {
    /**
     *  Given an Array of size n and a Number k.  Find those numbers which occur more than
     *  n/k times.
     *  e.g. [30,10,20,20,10,20,30,30], k=4 --> n/k = 8/4 = 2.  20 and 30 occur more than 2 times.
     */

    /**
     * Skipping Brute Force.  For Brute force, first sort the array and then count
     * by iterating and comparing to previous element
     */


    fun countOptimalWithHashing(nums: IntArray, k: Int): IntArray {
        if(k > nums.size) return intArrayOf()

        val map = mutableMapOf<Int, Int>()

        for(i in nums){
            map[i] = map.getOrDefault(i, 0) + 1
        }

        val countGreaterThan = nums.size / k
        val output = mutableListOf<Int>()

        for(entry in map.entries) {
            if(entry.value > countGreaterThan) {
                output.add(entry.key)
            }
        }
        return output.toIntArray()
    }

}
