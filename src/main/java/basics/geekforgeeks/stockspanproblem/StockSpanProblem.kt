package basics.geekforgeeks.stockspanproblem

import java.util.*



object StockSpanProblem {
    fun solve(arr: IntArray): IntArray {
        if (arr.isEmpty()) return intArrayOf()
        val stack = Stack<Int>()
        val stockSpan = mutableListOf<Int>()
        stockSpan.add(1)
        stack.push(0)

        for (i in 1 until arr.size) {
            while (stack.isNotEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop()
            }
            val span = if (stack.isEmpty()) i + 1 else i - stack.peek()
            stockSpan.add(span)
            stack.push(i)
        }
        println(stockSpan)
        return stockSpan.toIntArray()
    }
}