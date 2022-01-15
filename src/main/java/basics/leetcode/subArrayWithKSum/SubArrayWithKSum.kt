package basics.leetcode.subArrayWithKSum

/**
 * A Sub problem of it's more complex cousin.
 * In this problem we just find subarray with zero sum.
 * Then solve the other more complex one
 */
object SubArrayWithKSum {
    fun solveOptimalForZeroSumSelfIncluded(arr: IntArray): Boolean {
        // 10,1,-4,-3,5,1

        TODO()
    }


    fun solveBruteForceSelfIncluded(arr: IntArray, k: Int = 0): Boolean {
        for(i in arr.indices){
            var sum = 0
            for(j in i until arr.size){
                sum += arr[j]
                if(sum == 0) return true
            }
        }
        return false
    }

    fun subArrayWithKSumSelfExcluded(arr: IntArray, k: Int): Boolean{
        for(i in arr.indices){
            var sum = arr[i]
            for(j in i+1 until arr.size){
                sum += arr[j]
                if(sum == k || sum % k == 0) return true
            }
        }
        return false
    }
}