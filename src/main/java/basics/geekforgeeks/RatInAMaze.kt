package basics.geekforgeeks

object RatInAMaze {
    fun visitAllGridsOnlyOnce(
        m: Int,
        n: Int
    ) { // Means, Visit all the cells of the maze only one, regardless of whether it's blocked or not.
        fun visit(visited: Array<Array<Int>>, i: Int, j: Int, str: String = "") {
            println("Rat is at $i, $j")

            // downward
            if (i < m - 1 && visited[i + 1][j] != 1) {
                println("downward")
                visited[i + 1][j] = 1
                visit(visited, i + 1, j, "${str}D")
            }

            // right
            if (j < n - 1 && visited[i][j + 1] != 1) {
                println("right")
                visited[i][j + 1] = 1
                visit(visited, i, j + 1, "${str}R")
            }

            // left
            if (j > 0 && visited[i][j - 1] != 1) {
                println("left")
                visited[i][j - 1] = 1
                visit(visited, i, j - 1, "${str}L")
            }

            // up
            if (i > 0 && visited[i - 1][j] != 1) {
                println("up")
                visited[i - 1][j] = 1
                visit(visited, i - 1, j, "${str}U")
            }
        }

        val visited = Array(m) { _ -> Array(n) { _ -> 0 } }
        visited[0][0] = 1
        visit(visited, 0, 0)
        visited.forEach { println(it.contentToString()) }
    }
}

fun main() {
    RatInAMaze.visitAllGridsOnlyOnce(3, 3)
}