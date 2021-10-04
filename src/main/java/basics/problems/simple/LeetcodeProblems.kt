package basics.problems.simple

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

//https://leetcode.com/problems/container-with-most-water/

fun waterFillingBarChart(inputArray: Array<Int>){
    var waters = 0
    for(i in inputArray.indices) {
        for(j in i+1 until inputArray.size){
            val w = min(inputArray[i], inputArray[j]) * abs(j - i)
            if(w > waters) {
                waters = w
            }
        }
    }
    println(waters)
}

fun waterFillingBarChartOptimized(heights: IntArray): Int {
    var maxArea = 0
    var leftPointer = 0
    var rightPointer = heights.size-1
    while(leftPointer < rightPointer) {
        val area = min(heights[leftPointer], heights[rightPointer]) * (rightPointer - leftPointer)
        maxArea = max(area, maxArea)
        if(heights[leftPointer] <= heights[rightPointer]){
            leftPointer++
        }else{
            rightPointer--
        }
    }
    return maxArea
}


fun main() {
//    waterFillingBarChart(arrayOf(7,1,2,3,9))
    println(waterFillingBarChartOptimized(intArrayOf(7,1,2,3,9)))
    println(waterFillingBarChartOptimized(intArrayOf(1,4,6,5,3,7,6)))
}