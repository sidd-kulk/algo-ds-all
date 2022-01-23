package basics.geekforgeeks

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ArrayEqualityTest {

    @Test
    fun check() {
        assertTrue(ArrayEquality.check(intArrayOf(1,2,5,4,0), intArrayOf(2,4,5,0,1)))
        assertTrue(ArrayEquality.check(intArrayOf(), intArrayOf()))
        assertFalse(ArrayEquality.check(intArrayOf(1,2,5), intArrayOf(2,4,15)))
        assertFalse(ArrayEquality.check(intArrayOf(), intArrayOf(2,4,15)))
        assertFalse(ArrayEquality.check(intArrayOf(0,5,0), intArrayOf(5,0,5)))
    }
}