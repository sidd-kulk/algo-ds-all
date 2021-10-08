package basics.problems.simple.leetcode

import java.util.*

// https://leetcode.com/problems/backspace-string-compare/
fun typedStringComparison(s: String, t: String): Boolean {
    fun processBackspaces(str: String): String {
        var poundCounter = 0
        var list = mutableListOf<Char>()
        for (i in str.length - 1 downTo 0) {
            if (str[i] == '#') {
                poundCounter++
            } else {
                if (poundCounter > 0) {
                    poundCounter--
                } else {
                    list.add(str[i])
                }
            }
        }
        return list.joinToString("")
    }

    fun processBackspacesStack(str: String): String {
        var stack = Stack<Char>()
        for (i in str.indices) {
            if (str[i] == '#') {
                if (stack.size > 0) stack.pop()
            } else {
                stack.push(str[i])
            }
        }
        return stack.joinToString("")
    }

    val sString = processBackspacesStack(s)
    val tString = processBackspacesStack(t)
    if (sString.length == tString.length) {
        for (i in sString.indices) {
            if (sString[i] != tString[i]) return false
        }
        return true
    } else {
        return false
    }
//    return processBackspaces(s) == processBackspaces(t)
}

fun main() {
    println(typedStringComparison("a###b", "b"))
}