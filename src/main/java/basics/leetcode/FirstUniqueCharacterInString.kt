package basics.leetcode

import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.LinkedHashMap

object FirstUniqueCharacterInString {
    // l e e t c o d e
    fun solve(str: String): Int {
        val map = LinkedHashMap<Char, Int>()
        for ((i: Int, c: Char) in str.withIndex()) {
            map[c] = map.getOrDefault(c, 0) + 1
        }
        var counter = 0
        var index = -1
        for (c in str) {
            if (map[c] == 1) {
                index = counter
                break
            }
            counter++
        }
        return index
    }
}

fun main() {
    println(FirstUniqueCharacterInString.solve("leetcode"))
}