package basics.geekforgeeks

fun binary(n: Int) {
    if(n == 0) {
        return
    }
    binary(n/2)
    print(n%2)
}

fun main() {
    binary(13)
}