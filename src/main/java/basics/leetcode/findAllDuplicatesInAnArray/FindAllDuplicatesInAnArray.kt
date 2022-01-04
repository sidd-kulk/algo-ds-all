package basics.leetcode.findAllDuplicatesInAnArray

// https://leetcode.com/problems/find-all-duplicates-in-an-array/
object FindAllDuplicatesInAnArray {
    fun findBruteForce(nums: IntArray): List<Int>{ // time: O(2n), space: O(n)
        val set = mutableSetOf<Int>()
        val output = mutableListOf<Int>()
        for (n in nums){
            if(set.contains(n)){
                output.add(n)
            } else {
                set.add(n)
            }
        }
        return output
    }
}