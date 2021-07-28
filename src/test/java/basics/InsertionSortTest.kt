package basics

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class InsertionSortTest {
    @Test
    fun `should sort input array of integers`() {
        val inputArray = arrayOf(4,2,7,0,-1,99,76,45,23)
        assertEquals(arrayOf(-1,0,2,4,7,23,45,76,99),InsertionSort().sort(inputArray))
    }
}