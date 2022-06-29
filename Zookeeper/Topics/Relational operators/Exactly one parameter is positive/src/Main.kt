fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()

    println((a > 0) xor (b > 0) xor (c > 0) xor (a > 0 && b > 0 && c > 0))
}