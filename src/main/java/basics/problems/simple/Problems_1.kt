package basics.problems.simple

import java.util.*
import java.util.stream.Collectors
import kotlin.collections.HashSet

class ShortestCompletionWord {
    // Source; https://leetcode.com/problems/shortest-completing-word/
    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        val transformedLicensePlate = transform(licensePlate)
        val sortedBy = words.sortedBy { it.length }
        sortedBy.forEach { word ->
            val transformedWord = transform(word)
            if (charArrayContains(transformedWord, transformedLicensePlate)) {
                return word
            }
        }
        return ""
    }

    fun transform(licensePlate: String) = licensePlate.lowercase().filter {
        it != ' ' && !it.isDigit()
    }.toCharArray()

    fun charArrayContains(main: CharArray, contains: CharArray): Boolean {
        var counter = 0
        var temp = main.clone()
        for (c in contains) {
            if (temp.contains(c)) {
                temp = removeFromCharArray(temp, c)
                counter++
            } else {
                break
            }
        }
        if (counter == contains.size) {
            return true
        }
        return false
    }

    fun removeFromCharArray(array: CharArray, remove: Char): CharArray {
        return array.joinToString("").replaceFirst(remove.toString(), "").toCharArray()
    }
}


fun countOfDistinctElements(array: IntArray): Int {
    if (array.size <= 1) return array.size
    return array.toSet().size
}

fun frequencyOfElements(array: IntArray): Map<Int, Int> {
    val map = mutableMapOf<Int, Int>()
    for (num in array) {
        map[num] = map.getOrDefault(num, 0) + 1
    }
    return map
}

fun main() {
//    println(ShortestCompletionWord().transform("Ah s 34 an"))
//    println(ShortestCompletionWord().charArrayContains("steps".toCharArray(), "spst".toCharArray()))
//    println(ShortestCompletionWord().shortestCompletingWord("1s3 PSt", arrayOf("step","steps","stripe","stepple")))
//    println(countOfDistinctElements(intArrayOf(1, 2, 3, 4, 5, 5, 4, 2)))
    println(frequencyOfElements(intArrayOf(1, 2, 3, 4, 5, 5, 4, 2, 2)))
}