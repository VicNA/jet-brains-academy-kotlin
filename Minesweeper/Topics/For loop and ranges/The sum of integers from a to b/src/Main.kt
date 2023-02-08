fun main() {
    val (a, b) = Array(2) { readln().toInt() }
    println((a..b).sum())
}