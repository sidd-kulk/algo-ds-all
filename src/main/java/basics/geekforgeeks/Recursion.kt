package basics.geekforgeeks

fun binary(n: Int) {
    if (n == 0) {
        return
    }
    binary(n / 2)
    print(n % 2)
}


tailrec fun printNumsTailRecursive(n: Int, acc: Int = 1) {
    if(n == 0){
        return
    }
    print("$acc,")
    printNumsTailRecursive(n - 1, acc + 1)
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
    printNumsTailRecursive(13)
}