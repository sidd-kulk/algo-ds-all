package basics.leetcode


class LRUCache(private val capacity: Int) {
    private val map = mutableMapOf<Int, LRUValue>()
    var counter = 0
    fun get(key: Int): Int {
        val maybeVal = map[key]
        if (maybeVal != null) {
            map[key] = LRUValue(maybeVal.value, ++counter)
            // println("get $key from $map == ${maybeVal.value}")
            return maybeVal.value
        }
        // println("get $key from $map == -1")
        return -1
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            map[key] = LRUValue(value, ++counter)
        } else if (map.size < capacity) {
            map[key] = LRUValue(value, ++counter)
        } else {
            val sortedEntries = map.entries.sortedBy { it.value.lastUsed }
            map.remove(sortedEntries.first().key)
            map[key] = LRUValue(value, ++counter)
        }
        // println("put $key in $map.  size = ${map.size}")
    }

    fun all(): Map<Int, Int> {
        return map.entries.associate {
            it.key to it.value.value
        }
    }

    data class LRUValue(val value: Int, val lastUsed: Int)
}

fun main() {
    val lruCache = LRUCache(2)
    lruCache.put(1, 10)
    lruCache.put(2, 11)
    lruCache.get(1)
    lruCache.put(3, 12)
    println(lruCache.all())

}