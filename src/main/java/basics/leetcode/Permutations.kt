package basics.leetcode

import java.util.*
import kotlin.system.measureTimeMillis

object Permutations {
    /**
     * Vanilla implementation - No diverging cases
     * - No repeated characters
     * - No spaces in between or at ends
     */
    fun vanilla(s: String): Array<String> {
        fun swap(chars: CharArray, i: Int, j: Int) {
            if(i == j) return

            val temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        fun inner(so: CharArray, i: Int, list: MutableList<String>): Array<String> {
            if (i == so.size - 1) {
                list.add(so.joinToString(""))
                return list.toTypedArray()
            }
            for (j in i until so.size) {
                swap(so, j, i)
                inner(so, i + 1, list)
                swap(so, j, i)
            }
            return list.toTypedArray()
        }

        return inner(s.toCharArray(), 0, mutableListOf())

    }
}

fun main() {
    println(Permutations.vanilla("ABC").contentToString())
}