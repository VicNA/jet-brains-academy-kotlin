fun main() {
    var num: Int
    var result = 0
    do {
        num = readln().toInt()
        result += num
    } while (num != 0)

    println(result)
}