fun main() {
    val (a, b, n) = Array(3) { readln().toInt() }
    println((a..b).count { it % n == 0 })
}