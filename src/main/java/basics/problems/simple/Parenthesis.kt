package basics.problems.simple

import java.util.*

// https://leetcode.com/problems/valid-parentheses/
object ParenthesisValidation {
    fun validate(str: String): Boolean {
        val stack = Stack<Char>()
        val leftBrackets = "[{("
        val rightBrackets = "]})"
        val map = mapOf<Char, Char>(Pair(']', '['), Pair('}', '{'), Pair(')', '('))
        for(c in str){
            if(leftBrackets.contains(c)){
                stack.push(c)
            } else if(rightBrackets.contains(c)) {
                if(stack.size > 0){
                    val popped = stack.pop()
                    if(popped != map[c]) {
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