package basics.geekforgeeks

object BinarySearch {
    fun search(sortedArray: IntArray, s: Int): Int {
        var low = 0
        var high = sortedArray.size - 1

        while (low <= high) {
            val searchAt = (low + high) / 2
            if (sortedArray[searchAt] > s) {
                high = searchAt - 1
            } else if (sortedArray[searchAt] < s) {
                low = searchAt + 1
            } else { // equal
                return searchAt
            }
        }
        return -1
    }
}