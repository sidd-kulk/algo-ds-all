package basics.leetcode.dp.twoDGridTraveller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import kotlin.system.measureTimeMillis

internal class TwoDGridTravellerTest {
    @Test
    fun `should return 0 for a zero or one dimensional grid`() {
        assertEquals(0, TwoDGridTraveller.noOfWaysToTraverseBruteForce(0, 0))
        assertEquals(0, TwoDGridTraveller.noOfWaysToTraverseBruteForce(1, 0))
        assertEquals(0, TwoDGridTraveller.noOfWaysToTraverseBruteForce(0, 1))

        assertEquals(0, TwoDGridTraveller.noOfWaysToTraverseWithDynamicProgramming(0, 0))
        assertEquals(0, TwoDGridTraveller.noOfWaysToTraverseWithDynamicProgramming(1, 0))
        assertEquals(0, TwoDGridTraveller.noOfWaysToTraverseWithDynamicProgramming(0, 1))
    }

    @Test
    fun `should return 1 for a one by one grid`() {
        assertEquals(1, TwoDGridTraveller.noOfWaysToTraverseBruteForce(1, 1))
        assertEquals(1, TwoDGridTraveller.noOfWaysToTraverseWithDynamicProgramming(1, 1))
    }

    @Test
    fun `should return 3 for a two by three grid`() {
        assertEquals(3, TwoDGridTraveller.noOfWaysToTraverseBruteForce(2, 3))
        assertEquals(3, TwoDGridTraveller.noOfWaysToTraverseWithDynamicProgramming(2, 3))
    }

    @Test
    fun `should return 6 for a three by three grid`() {
        assertEquals(6, TwoDGridTraveller.noOfWaysToTraverseBruteForce(3, 3))
        assertEquals(6, TwoDGridTraveller.noOfWaysToTraverseWithDynamicProgramming(3, 3))
    }

    @Test
    fun `for weird cases`() {
        assertThrows(
            IllegalArgumentException::class.java,
            { TwoDGridTraveller.noOfWaysToTraverseBruteForce(-1, -1) },
            "Arguments cannot be negative"
        )
        assertThrows(
            IllegalArgumentException::class.java,
            { TwoDGridTraveller.noOfWaysToTraverseWithDynamicProgramming(-1, -1) },
            "Arguments cannot be negative"
        )
    }

    @Test
    fun `perf comparison`(){
        val bruteForceTime = measureTimeMillis { TwoDGridTraveller.noOfWaysToTraverseBruteForce(12, 12) }
        val dpSolutionTime = measureTimeMillis { TwoDGridTraveller.noOfWaysToTraverseWithDynamicProgramming(12, 12) }
        assertTrue(bruteForceTime > dpSolutionTime)

        val bruteForceTimeIter2 = measureTimeMillis { TwoDGridTraveller.noOfWaysToTraverseBruteForce(15, 14) }
        val dpSolutionTimeIter2 = measureTimeMillis { TwoDGridTraveller.noOfWaysToTraverseWithDynamicProgramming(15, 14) }
        assertTrue(bruteForceTimeIter2 > dpSolutionTimeIter2)
    }
}