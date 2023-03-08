fun main() {
    val array = IntArray(readln().toInt()) { readln().toInt() }
    val number = readln().toInt()

    println(if (array.any { number == it }) "YES" else "NO")
}