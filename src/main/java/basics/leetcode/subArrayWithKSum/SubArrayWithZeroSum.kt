package basics.leetcode.subArrayWithKSum

/**
 * A Sub problem of it's more complex cousin.
 * In this problem we just find subarray with zero sum.
 * Then solve the other more complex one
 */
object SubArrayWithZeroSum {
    fun solveBruteForce(arr: IntArray): Boolean {
        // 10,1,-4,-3,5,1
        for(i in arr.indices){
            var sum = 0
            for(j in i until arr.size){
                sum += arr[j]
                if(sum == 0) return true
            }
        }
        return false
    }
}