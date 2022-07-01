fun main() {
    val n = readln().toInt()

    var num = 0
    var counter = 0
    while (counter < n) {
        counter += ++num
        if (counter > n) {
            print("$num ".repeat(n - (counter - num)))
        } else {
            print("$num ".repeat(num))
        }
    }
}