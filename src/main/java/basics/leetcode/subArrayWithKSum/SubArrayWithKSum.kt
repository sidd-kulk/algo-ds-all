package basics.leetcode.subArrayWithKSum

/**
 * A Sub problem of it's more complex cousin.
 * In this problem we just find subarray with zero sum.
 * Then solve the other more complex one
 */
object SubArrayWithKSum {
    fun solveOptimalForZeroSumSelfIncluded(arr: IntArray, k: Int = 0): Boolean {
        // 1, 4, 13, -3, -10, 5
        val prefixSumArray = prefixSum(arr) // 1,5,18,15,5,10
        val set = mutableSetOf<Int>()
        for(i in prefixSumArray.indices){
            if(set.contains(prefixSumArray[i]) || prefixSumArray[i] == 0){
                return true
            } else if (k != 0 && prefixSumArray[i] % k == 0) {
                return true
            }
            else {
                set.add(prefixSumArray[i])
            }
        }
        return false
    }

    fun solveOptimalForKSumSelfExcluded(arr: IntArray, k: Int = 0): Boolean {
        println("${arr.asList()}, $k")
        val prefixSumArray = prefixSum(arr)
        val set = mutableSetOf<Int>()
        println(prefixSumArray.asList())
        for(i in prefixSumArray.indices){
            if(k == prefixSumArray[i] || set.contains(prefixSumArray[i] - k)   ){ // TODO - Not Working
                return true
            } else {
                set.add(prefixSumArray[i])
            }

//            set.add(prefixSumArray[i])
//            if(set.contains(k) || set.contains(prefixSumArray[i] - k) || prefixSumArray[i] % k == 0){
//                return true
//            }
        }
        return false
    }

    fun prefixSum(arr: IntArray): IntArray {
        val prefixSumArray = IntArray(arr.size)
        prefixSumArray[0] = arr[0]
        for(i in 1 until arr.size){
            prefixSumArray[i] = arr[i] + prefixSumArray[i-1]
        }
        return prefixSumArray
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(prefixSum(intArrayOf(1, 4, 13, -3, -10, 5)).asList())
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

    fun subArrayWithKSumBruteForceSelfExcluded(arr: IntArray, k: Int): Boolean{
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