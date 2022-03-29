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
    fun findNotContainingNoBacktracking(str: String, search: String): List<String> {
        fun find(s: String): List<String> {
            fun swap(chars: CharArray, i: Int, j: Int) {
                val temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }

            fun inner(so: CharArray, i: Int, list: MutableList<String>): List<String> {
                if (i == so.size - 1) {
                    list.add(so.joinToString(""))
                }
                for (j in i until so.size) {
                    swap(so, j, i)
                    inner(so, i + 1, list)
                    swap(so, j, i)
                }
                return list
            }

            return inner(s.toCharArray(), 0, mutableListOf())

        }
        return find(str)
    }
}

fun main() {
    println(measureTimeMillis { PermutationsWithStringSearch.findNotContaining("ABCDEFGH", "AB") })
}