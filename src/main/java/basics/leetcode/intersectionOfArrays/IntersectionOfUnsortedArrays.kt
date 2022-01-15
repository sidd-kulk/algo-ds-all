package basics.leetcode.intersectionOfArrays

//https://leetcode.com/problems/intersection-of-two-arrays/
object IntersectionOfUnsortedArrays  {
    fun find(arr1: IntArray, arr2: IntArray): IntArray{
        val set = mutableSetOf<Int>()
        val output = mutableListOf<Int>()
        for(num in arr1){
            set.add(num)
        }

        for(num in arr2){
            if(set.contains(num)){
                output.add(num)
                set.remove(num) // Tricky Part.
            }
        }
        return output.toIntArray()
    }
}