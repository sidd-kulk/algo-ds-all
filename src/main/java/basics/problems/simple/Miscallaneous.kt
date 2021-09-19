package basics.problems.simple

import org.junit.jupiter.api.Assertions.*
import java.util.*

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

fun pairAddingUpTo(array: Array<Int>, sum: Int): Optional<Array<Int>> {
    val empty = Optional.empty<Array<Int>>()
    if(array.isNullOrEmpty()) {
        return empty;
    }

    return Optional.of(array)
}


/********************  TESTS ******************************/
fun main() {
    Tests.runAll()
}

class Tests {
    companion object {
        fun runAll() {
            val tests = Tests()
            tests.`should return null if input array is empty`()
        }
    }

    fun `should return null if input array is empty`() {
        val result = pairAddingUpTo(emptyArray(), 9)
        assertEquals(OptionalInt.empty(), result)
    }
}