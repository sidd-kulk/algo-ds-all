package basics.problems.simple

import java.util.*

// https://leetcode.com/problems/valid-parentheses/
object ParenthesisValidation {
    fun validate(str: String): Boolean {
        val stack = Stack<Char>()
        val leftBrackets = "[{("
        val rightBrackets = "]})"
        val map = mapOf<Char, Char>(Pair(']', '['), Pair('}', '{'), Pair(')', '('))
        for (c in str) {
            if (leftBrackets.contains(c)) {
                stack.push(c)
            } else if (rightBrackets.contains(c)) {
                if (stack.size > 0) {
                    val popped = stack.pop()
                    if (popped != map[c]) {
                        return false
                    }
                } else {
                    return false
                }
            }
        }
        return stack.size == 0
    }
}

object BalancedParenthesis {
    fun validate(str: String): Boolean {
        val stack = Stack<Char>()

        for (c in str) {
            if ("({[".contains(c)) {
                stack.push(c)
            } else if (")}]".contains(c)) {
                if (stack.isEmpty()) return false
                val popped = stack.pop()
                if (!matchComplimentaryParenthesis(popped, c)) {
                    return false
                }
            } else {
                return false
            }
        }

        return stack.isEmpty()
    }

    private fun matchComplimentaryParenthesis(leftBracket: Char, rightBracket: Char): Boolean {
        return (leftBracket == '(' && rightBracket == ')') || (leftBracket == '{' && rightBracket == '}') || (leftBracket == '[' && rightBracket == ']')
    }
}

// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
object MinimumBracketsRemoval {
    fun minimumBracketRemoval(input: String): String {
        if (input.trim() == "") {
            return ""
        }

        val stack = Stack<Int>()
        val rightBracket = ')'
        val leftBracket = '('
        val output: StringBuilder = StringBuilder()
        for (c in input.indices) {
            val charAt = input[c]
            if (charAt == leftBracket) {
                stack.push(c)
                output.append(charAt)
            } else if (charAt == rightBracket) {
                if (stack.size > 0) {
                    stack.pop()
                    output.append(charAt)
                } else {
                    output.append(' ')
                }
            } else {
                output.append(charAt)
            }
        }

        val charArray = output.toString().toCharArray()
        for (index in stack) {
            charArray[index] = ' '
        }
        val filteredArray = charArray.filter { it != ' ' }

        return filteredArray.joinToString(separator = "")
    }

    fun minimumBracketRemovalV2(inp: String): String {
        if (inp.trim() == "") {
            return ""
        }

        val stack = Stack<Int>()
        val rightBracket = ')'
        val leftBracket = '('
        val arr = inp.toCharArray()
        for (c in arr.indices) {
            val charAt = arr[c]
            if (charAt == leftBracket) {
                stack.push(c)
            } else if (charAt == rightBracket) {
                if (stack.size > 0) {
                    stack.pop()
                } else {
                    arr[c] = ' '
                }
            }
        }

        while (stack.size > 0) {
            arr[stack.pop()] = ' '
        }
        val filteredArray = arr.filter { it != ' ' }

        return filteredArray.joinToString(separator = "")
    }
}