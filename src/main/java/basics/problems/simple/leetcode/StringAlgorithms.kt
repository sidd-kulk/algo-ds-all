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
// https://leetcode.com/problems/backspace-string-compare/
fun typedStringTwoPointer(s: String, t: String): Boolean {
    // "aa###b", "b"
    var sPointer = s.length - 1
    var tPointer = t.length - 1
    var tPoundCounter = 0
    var sPoundCounter = 0
    var finalResult = true
    while (sPointer >= 0 || tPointer >= 0) {
        var sx: Char
        var tx: Char
        var isCompareS = false
        var isCompareT = false

        if (sPointer >= 0) {
            sx = s[sPointer]
            if (sx == '#') {
                sPoundCounter++
                sPointer--
            } else {
                if (sPoundCounter > 0) {
                    sPoundCounter--
                    sPointer--
                } else {
                    isCompareS = true
                }
            }
        } else {
            isCompareS = true
            sx = ' '
        }

        if (tPointer >= 0) {
            tx = t[tPointer]
            if (tx == '#') {
                tPoundCounter++
                tPointer--
            } else {
                if (tPoundCounter > 0) {
                    tPoundCounter--
                    tPointer--
                } else {
                    isCompareT = true
                }
            }
        } else {
            isCompareT = true
            tx = ' '
        }

        if (isCompareS && isCompareT) {
            if (sx != tx) {
                finalResult = false
                break
            } else {
                sPointer--
                tPointer--
                continue
            }
        }

    }
    return finalResult
}

fun main() {
    println(typedStringTwoPointer("aaaa###b", "b"))
}