package basics.problems.simple

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MinimumBracketsRemovalTest {

    @Test
    fun `should return valid string by removing minimum set of unnecessary brackets - V2`() {
        assertEquals("abc", MinimumBracketsRemoval.minimumBracketRemovalV2("(abc"))
        assertEquals("(abc)", MinimumBracketsRemoval.minimumBracketRemovalV2("(abc)("))


        val output = MinimumBracketsRemoval.minimumBracketRemovalV2("(abc()")
        assertTrue("(abc)" == output || "abc()" == output)
        assertEquals("", MinimumBracketsRemoval.minimumBracketRemovalV2("))(("))

    }

    @Test
    fun `should return output blank string for input blank string or string with spaces - V2`(){
        assertEquals("", MinimumBracketsRemoval.minimumBracketRemovalV2(""))
        assertEquals("", MinimumBracketsRemoval.minimumBracketRemovalV2("  "))
    }

    @Test
    fun `should return output as input for string with no brackets or an already valid string with brackets - V2`(){
        assertEquals("abc", MinimumBracketsRemoval.minimumBracketRemovalV2("abc"))
        assertEquals("(abc)", MinimumBracketsRemoval.minimumBracketRemovalV2("(abc)"))
        assertEquals("(xyz)()", MinimumBracketsRemoval.minimumBracketRemovalV2("(xyz)()"))
        assertEquals("()", MinimumBracketsRemoval.minimumBracketRemovalV2("()"))
    }

    @Test
    fun `should return valid string by removing minimum set of unnecessary brackets`() {
        assertEquals("abc", MinimumBracketsRemoval.minimumBracketRemoval("(abc"))
        assertEquals("(abc)", MinimumBracketsRemoval.minimumBracketRemoval("(abc)("))


        val output = MinimumBracketsRemoval.minimumBracketRemoval("(abc()")
        assertTrue("(abc)" == output || "abc()" == output)
        assertEquals("", MinimumBracketsRemoval.minimumBracketRemoval("))(("))

    }

    @Test
    fun `should return output blank string for input blank string or string with spaces`(){
        assertEquals("", MinimumBracketsRemoval.minimumBracketRemoval(""))
        assertEquals("", MinimumBracketsRemoval.minimumBracketRemoval("  "))
    }

    @Test
    fun `should return output as input for string with no brackets or an already valid string with brackets`(){
        assertEquals("abc", MinimumBracketsRemoval.minimumBracketRemoval("abc"))
        assertEquals("(abc)", MinimumBracketsRemoval.minimumBracketRemoval("(abc)"))
        assertEquals("(xyz)()", MinimumBracketsRemoval.minimumBracketRemoval("(xyz)()"))
        assertEquals("()", MinimumBracketsRemoval.minimumBracketRemoval("()"))
    }
}