package basics.leetcode.dp.twoDGridTraveller

/**
 * Say that you are a traveler on a 2D grid. You begin in the top-left corner and your goal is to travel to the bottom-right corner. You may only move down or right.
In how many ways can you travel to the goal on a grid with dimensions m * n?
Write a function ‘gridTraveler(m, n)` that calculates this.
 */
object TwoDGridTraveller {

    fun noOfWaysToTraverseBruteForce(x: Int, y: Int): Int{
        if(x < 0 || y < 0) throw IllegalArgumentException("Arguments cannot be negative")

        if(x == 0 || y == 0) return 0
        if(x == 1 && y == 1) return 1

        return noOfWaysToTraverseBruteForce(x -1 , y) + noOfWaysToTraverseBruteForce(x, y - 1)
    }
}