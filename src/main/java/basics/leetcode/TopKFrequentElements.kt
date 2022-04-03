package basics.leetcode

/**
 * Leetcode 347
 * https://leetcode.com/problems/top-k-frequent-elements/
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
 */
object TopKFrequentElements {
    /**
     *  Brute Force.
     *  Use a Map.  Capture Frequencies.  Sort by Value.  LinkedHashMap FTW.  Iterate over the LHM, add to Array.  Profit.
     *  Bad Approach.
     *  Time: Theta(2N*LogN)
     *  Space : Theta(2N)
     */
    fun bruteForce(arr: IntArray, k: Int): IntArray {
        if (k == arr.size) return arr
        val map = mutableMapOf<Int, Int>()
        val ret = Array(k) { _ -> 0 }

        for (n in arr) {
            map[n] = map.getOrDefault(n, 0) + 1
        }

        val x: List<MutableMap.MutableEntry<Int, Int>> = map.entries.sortedByDescending { it.value }

        for (i in 0 until k) {
            ret[i] = x[i].key
        }
        return ret.toIntArray()
    }
}