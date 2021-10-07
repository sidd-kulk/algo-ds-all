package basics.problems.simple

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

//https://leetcode.com/problems/container-with-most-water/
fun waterFillingBarChart(inputArray: Array<Int>) {
    var waters = 0
    for (i in inputArray.indices) {
        for (j in i + 1 until inputArray.size) {
            val w = min(inputArray[i], inputArray[j]) * abs(j - i)
            if (w > waters) {
                waters = w
            }
        }
    }
    println(waters)
}

//https://leetcode.com/problems/container-with-most-water/
fun waterFillingBarChartOptimized(heights: IntArray): Int {
    var maxArea = 0
    var leftPointer = 0
    var rightPointer = heights.size - 1
    while (leftPointer < rightPointer) {
        val area = min(heights[leftPointer], heights[rightPointer]) * (rightPointer - leftPointer)
        maxArea = max(area, maxArea)
        if (heights[leftPointer] <= heights[rightPointer]) {
            leftPointer++
        } else {
            rightPointer--
        }
    }
    return maxArea
}

// https://leetcode.com/problems/unique-email-addresses
fun uniqueEmailAddresses(emails: Array<String>): Int {
    var map = mutableMapOf<String, Any>()
    var counter = 0
    for (email in emails) {
        val split = email.split("@")
        val dotReplacedEmail = split[0].replace(".", "")
        val indexOfPlus = dotReplacedEmail.indexOf("+")
        val plusIgnoredEmail = if (indexOfPlus > 0) {
            dotReplacedEmail.substring(IntRange(0, indexOfPlus - 1))
        } else {
            dotReplacedEmail
        }
        val key = plusIgnoredEmail.plus("@").plus(split[1])
        if (!map.containsKey(key)) {
            map[key] = ++counter
        }
    }
    return counter
}

// https://leetcode.com/problems/trapping-rain-water/submissions/
fun trappedWater(heights: Array<Int>): Int {
    //println(trappedWater(arrayOf(0,1,0,2,1,0,3,1,0,1,2)))
    var totalWater = 0
    for (i in heights.indices) {
        var maxLeft = 0
        var leftIndex = i - 1
        var maxRight = 0
        var rightIndex = i + 1

        while (leftIndex >= 0) {
            maxLeft = max(maxLeft, heights[leftIndex--])
        }

        while (rightIndex < heights.size) {
            maxRight = max(maxRight, heights[rightIndex++])
        }

        val waterAbove = min(maxLeft, maxRight) - heights[i]
        if (waterAbove > 0) {
            totalWater += waterAbove
        }
    }
    return totalWater
}

// https://leetcode.com/problems/trapping-rain-water/submissions/
fun trappedWaterOptimized(heights: Array<Int>): Int {
    var totalWater = 0
    var leftPointer = 0
    var rightPointer = heights.size - 1
    var maxRight = 0
    var maxLeft = 0

    while(rightPointer > leftPointer){
        if(heights[leftPointer] <= heights[rightPointer]){
            if(heights[leftPointer] > maxLeft) {
                maxLeft = heights[leftPointer]
            } else {
                totalWater += (maxLeft - heights[leftPointer])
            }
            leftPointer ++
        } else {
            if(heights[rightPointer] > maxRight){
                maxRight = heights[rightPointer]
            } else {
                totalWater += maxRight - heights[rightPointer]
            }
            rightPointer --
        }
    }
    return totalWater
}


fun main() {
//    waterFillingBarChart(arrayOf(7,1,2,3,9))
//    println(waterFillingBarChartOptimized(intArrayOf(7, 1, 2, 3, 9)))
//    println(waterFillingBarChartOptimized(intArrayOf(1, 4, 6, 5, 3, 7, 6)))
//    println(uniqueEmailAddresses(arrayOf("test.email+alex@leetcode.com","test.email.leet+alex@code.com")))
    println(trappedWater(arrayOf(0,1,0,2,1,0,3,1,0,1,2)))
    println(trappedWaterOptimized(arrayOf(0,1,0,2,1,0,3,1,0,1,2)))
}