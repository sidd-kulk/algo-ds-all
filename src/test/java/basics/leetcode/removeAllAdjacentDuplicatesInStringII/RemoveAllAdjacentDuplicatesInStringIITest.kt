package basics.leetcode.removeAllAdjacentDuplicatesInStringII

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RemoveAllAdjacentDuplicatesInStringIITest {

    @Test
    fun solve() {
        assertEquals("abcd", RemoveAllAdjacentDuplicatesInStringII.solve("abcd", 2))
        assertEquals("aa", RemoveAllAdjacentDuplicatesInStringII.solve("deeedbbcccbdaa", 3))
        assertEquals("ps", RemoveAllAdjacentDuplicatesInStringII.solve("pbbcggttciiippooaais", 2))
    }
}