package basics.problems.simple.leetcode
// https://leetcode.com/problems/backspace-string-compare/
fun typedStringComparison(s: String, t: String): Boolean {
    fun processBackspaces(str: String): String {
        var poundCounter = 0
        var list = mutableListOf<Char>()
        for(i in str.length-1 downTo 0){
            if(str[i] == '#') {
                poundCounter ++
            }else{
                if(poundCounter > 0) {
                    poundCounter--
                }else{
                    list.add(str[i])
                }
            }
        }
        return list.joinToString("")
    }

    return processBackspaces(s) == processBackspaces(t)
}

fun main() {
    println(typedStringComparison("a###b", "b"))
}