package basics.problems.simple.leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ReverseStringTest {
    @Test
    fun `should reverse string recursively`(){
        val input = "abc123"
        assertEquals("321cba", ReverseString.doItRecursive(input))
    }
}