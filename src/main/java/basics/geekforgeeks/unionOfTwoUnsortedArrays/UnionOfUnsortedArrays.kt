package basics.geekforgeeks.unionOfTwoUnsortedArrays

/**
 *  Find union of two unsorted arrays
 *
 */

object UnionOfUnsortedArrays {
    fun find(arr1: IntArray, arr2: IntArray): IntArray {
        val set = mutableSetOf<Int>()
        for(num in arr1){
            set.add(num)
        }

        for(num in arr2){
            set.add(num)
        }

        return set.toIntArray()
    }
}