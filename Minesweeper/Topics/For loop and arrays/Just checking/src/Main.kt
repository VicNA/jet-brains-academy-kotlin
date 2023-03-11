fun main() {
    val numbers = IntArray(readln().toInt()) { readln().toInt() }
    val (p, m) = readln().split(" ").map { it.toInt() }

    numbers.also { println(if (it.contains(p) && it.contains(m)) "YES" else "NO") }
}