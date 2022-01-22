package basics.geekforgeeks

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CountMoreThanNByKOccurrencesTest {

    @Test
    fun countOptimal() {
        arrayOf(
            Triple(intArrayOf(20,30), intArrayOf(30,10,20,20,10,20,30,30), 4),
            Triple(intArrayOf(30), intArrayOf(30,10,20,30,30,40,30,40,30), 2)
        ).forEach {
            assertArrayEquals(it.first.sortedArray(), CountMoreThanNByKOccurrences.countOptimalWithHashing(it.second, it.third).sortedArray())
        }
    }
}