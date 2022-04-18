package basics.leetcode

object WordSearchBackTrackingMaze {
    private var board: Array<Array<Char>>? = null
    private var rows = 0
    private var columns = 0

    fun check(board: Array<Array<Char>>?, word: String): Boolean {
        this.board = board
        rows = board!!.size
        columns = board[0].size

        for (row in 0 until rows) {
            for (col in 0 until columns) {
                if (recursive(row, col, word, 0)) return true
            }
        }
        return false
    }

    fun recursive(row: Int, col: Int, word: String, index: Int): Boolean {
        /* Step 1). check the bottom case. */
        if (index >= word.length) return true

        if (row < 0 || row == rows || col < 0 || col == columns || board!![row][col] != word[index]) return false

        var ret = false
        board!![row][col] = '#'
        val rowOffsets = intArrayOf(0, 1, 0, -1)
        val colOffsets = intArrayOf(1, 0, -1, 0)
        for (d in 0..3) {
            ret = recursive(row + rowOffsets[d], col + colOffsets[d], word, index + 1)
            if (ret) break
        }

        board!![row][col] = word[index]
        return ret
    }
}

fun main() {
//    WordSearchBackTrackingMaze.check()
}