package basics.geekforgeeks

fun binary(n: Int) {
    if (n == 0) {
        return
    }
    binary(n / 2)
    print(n % 2)
}

fun printNums(n: Int, order: String = "regular") {
    if(n == 0){
        return
    }
    if(order == "reversed") print("$n,")
    printNums(n - 1, order)
    if(order == "regular") print("$n,")
}

fun main() {
//    printNums(13)
    printNums(13, "reversed")
}