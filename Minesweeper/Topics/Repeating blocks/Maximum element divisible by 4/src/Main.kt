fun main() {
    val n = readln().toInt()

    var max = 0
    repeat(n) {
        val num = readln().toInt()
        if (num % 4 == 0 && num > max) max = num
    }
    println(max)
}