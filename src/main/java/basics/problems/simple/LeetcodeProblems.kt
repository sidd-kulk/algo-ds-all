package basics.problems.simple

import kotlin.math.abs
import kotlin.math.min

fun waterFillinBarChart(inputArray: Array<Int>){
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

fun main() {
    waterFillinBarChart(arrayOf(1,3,7,9,2))
}