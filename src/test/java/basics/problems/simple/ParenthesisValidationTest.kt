package basics.problems.simple

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ParenthesisValidationTest {

    @Test
    fun `should return true if parenthesis are balanced`() {
        val input = "[{}]"
        Assertions.assertTrue(ParenthesisValidation.validate(input))
    }

    @Test
    fun `should return false if parenthesis are not balanced`() {
        Assertions.assertFalse(ParenthesisValidation.validate("[{(}]"))
        Assertions.assertFalse(ParenthesisValidation.validate("(}]"))
        Assertions.assertFalse(ParenthesisValidation.validate("}}}]](}]"))
    }
}