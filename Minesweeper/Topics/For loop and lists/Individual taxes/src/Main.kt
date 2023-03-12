fun main() = IntArray(readln().toInt()) { readln().toInt() }
    .map { it * readln().toInt() }
    .run { indexOf(maxOf { it }) + 1 }
    .let(::print)