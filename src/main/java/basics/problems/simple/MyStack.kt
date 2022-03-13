package basics.problems.simple

class StackUsingArray(private var capacity: Int) {
    private var array = Array(capacity) { _ -> 0 }
    private var index = -1

    fun push(element: Int) {
        if(index == capacity - 1) {
            expandCapacity()
        }
        index ++
        array[index] = element
    }

    fun pop(): Int {
        if(isEmpty()) throw Exception("Trying to Pop an Empty Stack")
        val popped = peek()
        array[index] = Int.MIN_VALUE
        index --
        return popped
    }

    fun peek(): Int {
        if(isEmpty()) throw Exception("Trying to Peek an Empty Stack")
        return array[index]
    }

    fun size(): Int {
        return index + 1
    }

    fun isEmpty(): Boolean {
        return index == -1
    }

    override fun toString(): String {
        return "${array.contentToString()}, size = $index"
    }

    private fun expandCapacity() {
        capacity *= 2
        val newArray = Array(capacity) { _ -> 0 }
        for (i in array.indices) {
            newArray[i] = array[i]
        }
        array = Array(capacity) { _ -> 0 }
        array = newArray
    }
}