package basics.leetcode.removeAllAdjacentDuplicatesInStringII

import java.util.*


// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
object RemoveAllAdjacentDuplicatesInStringII {

    fun solve(s: String, k: Int): String {
        val sb = LinkedList<Char>()
        for(c in s) sb.add(c)
        val counts = Stack<Int>()
        var i = 0
        while (i < sb.size) {
            if (i == 0 || sb[i] != sb[i - 1]) {
                counts.push(1)
            } else {
                val incremented: Int = counts.pop() + 1
                if (incremented == k) {
                    for(j in 0 until k) {
                        sb.removeAt(i-k+1)
                    }
                    i -= k
                } else {
                    counts.push(incremented)
                }
            }
            ++i
        }
        return sb.joinToString("")
    }
}