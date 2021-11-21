package basics.problems.simple.recursion

import java.lang.IllegalArgumentException

fun factorial(n: Int): Int {
    return if(n == 1) 1
    else n * factorial(n-1)
}

tailrec fun factorialTailRec(n: Int, acc: Int = 1): Int {
    return if(n == 0) acc
    else factorialTailRec(n - 1, acc*n)
}

fun main() {
    println(factorialTailRec(10))
    println(factorial(10))
}