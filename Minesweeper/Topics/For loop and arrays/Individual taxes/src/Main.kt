fun main() = Array(readln().toInt()) { readln().toInt() }
    .map { readln().toInt() * it }
    .let { println(it.indexOf(it.maxOrNull()) + 1) }