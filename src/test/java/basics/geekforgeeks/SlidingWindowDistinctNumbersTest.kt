package basics.geekforgeeks

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SlidingWindowDistinctNumbersTest {

    @Test
    fun countBruteForce() {
        arrayOf(
            Triple(intArrayOf(2,3,4,3), intArrayOf(10,20,20,10,30,40,10), 4),
            Triple(intArrayOf(1,1), intArrayOf(10,10,10,10), 3),
            Triple(intArrayOf(3,4,3), intArrayOf(10,10,5,3,20,5), 4),
            Triple(intArrayOf(), intArrayOf(), 4),
            Triple(intArrayOf(1), intArrayOf(1), 1)
        ).forEach {
            assertArrayEquals(it.first, SlidingWindowDistinctNumbers.countBruteForce(it.second, it.third))
        }
    }

    @Test
    fun countOptimal() {
        arrayOf(
            Triple(intArrayOf(2,3,4,3), intArrayOf(10,20,20,10,30,40,10), 4),
            Triple(intArrayOf(1,1), intArrayOf(10,10,10,10), 3),
            Triple(intArrayOf(3,4,3), intArrayOf(10,10,5,3,20,5), 4),
            Triple(intArrayOf(), intArrayOf(), 4),
            Triple(intArrayOf(1), intArrayOf(1), 1)
        ).forEach {
            assertArrayEquals(it.first, SlidingWindowDistinctNumbers.countOptimal(it.second, it.third))
        }
    }
}