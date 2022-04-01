package basics.geekforgeeks

import basics.leetcode.Permutations
import kotlin.system.measureTimeMillis

object RateInAMaze {
    fun solve(arr: Array<Array<Int>>) {

    }
}

object PermutationsWithStringSearch {
    // No backtracking
    fun findNotContaining(str: String, search: String): List<String> {
        val perms = Permutations.vanilla(str)
        return perms.filterNot {
            it.contains(search)
        }
    }

    // With Backtracking
    fun findNotContainingWithBacktracking(str: String, search: String): List<String> {
        fun find(s: String): List<String> {
            fun swap(chars: CharArray, i: Int, j: Int) {
                if (i == j) return
                val temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }

            fun isNeeded(so: CharArray): Boolean {
                TODO()
                return true
            }

            fun inner(so: CharArray, i: Int, list: MutableList<String>): List<String> {
                if (i == so.size - 1) {
                    list.add(so.joinToString(""))
                    return list
                }
                for (j in i until so.size) {
                    if (isNeeded(so)) {
                        swap(so, j, i)
                        inner(so, i + 1, list)
                        swap(so, j, i)
                    }
                }
                return list
            }

            return inner(s.toCharArray(), 0, mutableListOf())

        }
        return find(str)
    }
}

fun main() {
//    println(measureTimeMillis { PermutationsWithStringSearch.findNotContaining("ABCDEFGH", "AB") })
    println(PermutationsWithStringSearch.findNotContainingWithBacktracking("ABC", "AB"))
}