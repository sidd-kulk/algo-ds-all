package basics.problems.simple

import org.junit.jupiter.api.Assertions.*
import java.util.*
import org.paukov.combinatorics3.Generator;

/**
 * Given an array of positive integers, find the index of a pair of numbers that add up
 * to a given integer.  E.g. Given [5, 2, 6, 3, 1] and 9, the output will be the array [2, 3] because 6+3 = 9
 */

/**
 * Constraints:
 * 1.  Input array can be empty.  Input number will always be positive integer.
 * 2.  There will always be a solution.  And there will only be one solution.
 * 3.  Numbers will not repeat
 * 4.  Return null if solution is not found or any constraints are not satisfied.
 */

/**
 * Test Cases:
 * 1.  Given either an empty array or array with only 1 element, return null.
 * 2.  Return null if solution not found
 */

fun pairAddingUpToBruteForce(array: Array<Int>, sum: Int): Optional<Array<Int>> {
    val empty = Optional.empty<Array<Int>>()
    if (array.isNullOrEmpty() || array.size == 1) {
        return empty;
    }

    for (i in 1 until array.size) {
        for (j in i until array.size) {
            if (array[i] + array[j] == sum) {
                return Optional.of(arrayOf(i, j))
            }
        }
    }
    return empty
}


fun nPairAddingUpTo(array: Array<Int>, nPair: Int, sum: Int): Optional<List<Int>> {
    /**
     * [5, 6, 1, 2, 8, 3], 4, 14 ==> 1,2,8,3
     */

    if (array.isEmpty() || nPair == 0 || nPair > array.size) {
        return Optional.empty()
    }
    val allCombinations: List<MutableList<Int>> = combinations(array, nPair)
    val result = allCombinations.filter { it.sum() == sum }
    println(result)
    return if(result.isNotEmpty()) Optional.of(result.first()) else Optional.empty()
}

fun factorial(n: Int): Int = if (n < 1) 1 else (1..n).reduce { acc, num -> acc * num }
fun numberOfCombinations(n: Int, r: Int): Int = factorial(n) / (factorial(r) * factorial(n - r))
fun combinations(numbers: Array<Int>, k: Int): List<MutableList<Int>> {
    return Generator.combination(*numbers).simple(k).toList()
}


/********************  TESTS ******************************/
fun main() {
//    pairAddingUpTo(arrayOf(5, 2, 6, 3, 1), 9)
//    Tests.runAll()
//    println(numberOfCombinations(10, 7))
//    println("Tests Passed!")
//    println(combinations(arrayOf(5, 2, 6, 3, 1), 2))
    nPairAddingUpTo(arrayOf(5, 6, 1, 2, 8, 3), 4, 14).ifPresent(System.out::println)
}

class Tests {
    companion object {
        fun runAll() {
            val tests = Tests()
            tests.`should return null if input array is empty`()
            tests.`should return null if input array is has one element`()
            tests.`should return the index of two numbers that add up to the sum`()
        }
    }

    fun `should return null if input array is has one element`() {
        val result = pairAddingUpToBruteForce(arrayOf(1), 9)
        assertEquals(Optional.empty<Array<Int>>(), result)
    }

    fun `should return null if input array is empty`() {
        val result = pairAddingUpToBruteForce(emptyArray(), 9)
        assertEquals(Optional.empty<Array<Int>>(), result)
    }

    fun `should return the index of two numbers that add up to the sum`() {
        val result = pairAddingUpToBruteForce(arrayOf(5, 2, 6, 3, 1), 9)
        assertArrayEquals(arrayOf(2, 3), result.get())
    }
}