package basics.geekforgeeks

fun binary(n: Int) {
    if (n == 0) {
        return
    }
    binary(n / 2)
    print(n % 2)
}


tailrec fun printNumsTailRecursive(n: Int, acc: Int = 1) {
    if (n == 0) {
        return
    }
    print("$acc,")
    printNumsTailRecursive(n - 1, acc + 1)
}

fun sumOfFirstNNaturalNumbers(n: Int): Int {
    if (n == 0) return 0
    return n + sumOfFirstNNaturalNumbers(n - 1)
}

fun sumOfFirstNNaturalNumbersTailRecursive(n: Int, acc: Int = 0): Int {
    if (n == 0) return acc
    return sumOfFirstNNaturalNumbersTailRecursive(n - 1, acc + n)
}

fun printNums(n: Int, order: String = "regular") {
    if (n == 0) {
        return
    }
    if (order == "reversed") print("$n,")
    printNums(n - 1, order)
    if (order == "regular") print("$n,")
}

fun sumOfDigits(i: Int): Int {
    if (i % 10 == i) return i

    return i % 10 + sumOfDigits(i / 10)
}

fun main() {
//    printNums(13)
//    printNumsTailRecursive(13)
//    println(sumOfFirstNNaturalNumbersTailRecursive(10))
    println(sumOfDigits(873 ))
}