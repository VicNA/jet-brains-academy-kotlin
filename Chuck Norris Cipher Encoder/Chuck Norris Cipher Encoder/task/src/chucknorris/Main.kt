package chucknorris

fun main() {
    println("Input string:")
    val input = readln()

    println("\nThe result:")
    for (ch in input) {
        println("$ch = ${String.format("%7s", Integer.toBinaryString(ch.code))
            .replace(" ", "0")}")
    }
}