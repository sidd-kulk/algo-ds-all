package basics.geekforgeeks.stockspanproblem

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StockSpanProblemTest {
    @Test
    fun testSolve() {
        assertArrayEquals(intArrayOf(1,1,2,3,1,5), StockSpanProblem.solve(intArrayOf(30,20,25,28,27,29)))
    }
}