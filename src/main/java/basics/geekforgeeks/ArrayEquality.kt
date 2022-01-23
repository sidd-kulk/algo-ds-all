package basics.geekforgeeks

/**
 * Given two arrays A and B of equal size N, the task is to find if given arrays are equal or not. Two arrays are said to be equal if both of them contain same set of elements, arrangements (or permutation) of elements may be different though.
Note : If there are repetitions, then counts of repeated elements must also be same for two array to be equal.

Example 1:

Input:
N = 5
A[] = {1,2,5,4,0}
B[] = {2,4,5,0,1}
Output: 1
Explanation: Both the array can be
rearranged to {0,1,2,4,5}
Example 2:

Input:
N = 3
A[] = {1,2,5}
B[] = {2,4,15}
Output: 0
Explanation: A[] and B[] have only
one common value.
Your Task:
Complete check() function which takes both the given array and their size as function arguments and returns true if the arrays are equal else returns false.The 0 and 1 printing is done by the driver code.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(N)

Constraints:
1<=N<=107
1<=A[],B[]<=1018
 */
object ArrayEquality {
    fun check(arr1: IntArray, arr2: IntArray): Boolean {
        if (arr1.isEmpty() && arr2.isEmpty()) return true
        if (arr1.isEmpty() || arr2.isEmpty() || arr1.size != arr2.size) return false

        val map1 = mutableMapOf<Int, Int>()
        for (i in arr1.indices) {
            map1[arr1[i]] = map1.getOrDefault(arr1[i], 0) + 1
        }

        val map2 = mutableMapOf<Int, Int>()
        for (j in arr2.indices) {
            if (!map1.containsKey(arr2[j])) return false
            map2[arr2[j]] = map2.getOrDefault(arr2[j], 0) + 1
        }

        if (map1.size != map2.size) return false
        for (entry in map1.entries) {
            if (!map2.containsKey(entry.key)) return false
            if (entry.value != map2[entry.key]) return false
        }
        return true
    }
}