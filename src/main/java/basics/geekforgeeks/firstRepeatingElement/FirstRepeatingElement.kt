package basics.geekforgeeks.firstRepeatingElement

object FirstRepeatingElement {

    fun findIndex(arr: IntArray): Int {
        if (arr.size <= 1) return -1

        val map = mutableMapOf<Int, Int>()
        for (i in arr.indices) {
            if (map.containsKey(arr[i])) {
                return map[arr[i]]!!
            } else {
                map[arr[i]] = i
            }
        }
        return -1
    }
}