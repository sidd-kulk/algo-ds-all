package basics.leetcode

object Permutations {
    /**
     * Vanilla implementation - No diverging cases
     * - No repeated characters
     * - No spaces in between or at ends
     */
    fun vanilla(s: String) {
        fun swap(chars: CharArray, i: Int, j: Int) {
            val temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        fun inner(so: CharArray, i: Int) {
            if (i == so.size - 1) println(so.joinToString(""))
            for (c in i until so.size) {
                swap(so, c, i)
                inner(so, i + 1)
                swap(so, c, i)
            }
        }

        inner(s.toCharArray(), 0)

    }
}

fun main() {
    Permutations.vanilla("ABC")
}