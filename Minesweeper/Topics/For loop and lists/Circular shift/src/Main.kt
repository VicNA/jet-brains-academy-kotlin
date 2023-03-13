import java.util.Collections

fun main() = List(readln().toInt()) { readln().toInt() }
    .also { Collections.rotate(it, 1) }
    .let { println(it.joinToString(" ")) }
