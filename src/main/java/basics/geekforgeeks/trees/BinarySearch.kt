package basics.geekforgeeks

object BinarySearch {
    fun iterative(sortedArray: IntArray, s: Int): Int {
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

    fun recursive(sortedArray: IntArray, s: Int): Int {

        fun inner(low: Int, high: Int): Int {
            if (low > high) return -1
            val searchAt = (low + high) / 2
            return if (sortedArray[searchAt] > s) {
                inner(low, searchAt - 1)
            } else if (sortedArray[searchAt] < s) {
                inner(searchAt + 1, high)
            } else { // equal
                searchAt
            }
        }
        return inner(0, sortedArray.size - 1)
    }
}

object FirstOccurrence {
    fun find(sortedArray: IntArray, s: Int): Int {
        var low = 0
        var high = sortedArray.size - 1

        while (low <= high) {
            val searchAt = (low + high) / 2
            if (sortedArray[searchAt] > s) {
                high = searchAt - 1
            } else if (sortedArray[searchAt] < s) {
                low = searchAt + 1
            } else if (searchAt == 0 || sortedArray[searchAt] != sortedArray[searchAt - 1]) { // equal
                return searchAt
            } else {
                high = searchAt - 1
            }
        }
        return -1
    }
}