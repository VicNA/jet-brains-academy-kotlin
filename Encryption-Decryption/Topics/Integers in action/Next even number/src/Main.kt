fun main() = println(readln().toInt().let { it + 2 - it.mod(2) })