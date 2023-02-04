fun main() = println(
    Array(readln().toInt()) { readln().toInt() }
        .contains(readln().toInt())
        .let { if (it) "YES" else "NO" })