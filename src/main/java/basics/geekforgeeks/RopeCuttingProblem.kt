package basics.geekforgeeks

import java.util.*

object RopeCuttingProblem {
    fun cutIntoMaxPieces(n: Int, a: Int, b: Int, c: Int): Int {

        TODO()
    }
}

fun main() {
    TowerOfHanoi.solve(3)
}

object TowerOfHanoi {
    fun solve(noOfDisks: Int) {
        fun solveInner(n: Int, A: Stack<Int>, B: Stack<Int>, C: Stack<Int>) {
            if (n == 1) {
                C.push(A.pop())
//                println("Move disk $n from ${A.} to C")
                return
            }
            solveInner(n - 1, A, C, B)
            C.push(A.pop())
//            println("Move disk $n from A to C")
            solveInner(n - 1, B, A, C)
//            println(C)
        }

        val initialStack = Stack<Int>()
        for (i in 0 until noOfDisks) {
            initialStack.push(noOfDisks - i)
        }

        solveInner(noOfDisks, initialStack, Stack<Int>(), Stack<Int>())

        fun solveFor2() {
            val stack1 = Stack<Int>()
            stack1.push(1)
            stack1.push(2)
            val stack2 = Stack<Int>()
            val stack3 = Stack<Int>()

            stack2.push(stack1.pop())
            stack3.push(stack1.pop())
            stack3.push(stack2.pop())

        }

    }


}

object JosephusProblem {
    fun findSurvivor(n: Int, k: Int): Int { // 5, 3
        fun inner(no: Int, ko: Int, arr: Array<Int>, startAt: Int = 0): Int {
            if (no == 1) return 0
            var x = startAt
            if(x + ko >= no)
            while (arr[x + ko] != 1) {
                x++
            }
            arr[x] = 0
            return inner(no - 1, ko, arr, x)
        }

        return inner(n, k, Array(n) { _ -> 1 }, 0)
    }
}