package basics.geekforgeeks.firstRepeatingElement

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class FirstRepeatingElementTest {

    @Test
    fun findIndex() {
        arrayOf(
            Pair(intArrayOf(1, 5, 3, 4, 3, 5, 6), 2),
            Pair(intArrayOf(1, 2, 3, 4), -1),
            Pair(intArrayOf(10,10,1,0), 0),
            Pair(intArrayOf(), -1),
            Pair(intArrayOf(9), -1),
            Pair(intArrayOf(9,5,8,-1,0,8,-1,5), 2)
        ).forEach {
            assertEquals(it.second, FirstRepeatingElement.findIndex(it.first))
        }
    }
}