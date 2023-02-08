fun main() = println(
    Array(readln().toInt()) { readln().toInt() }
        .sortedDescending()
        .let { if (it.size == 1) it[0] else it[0] * it[1] }
)