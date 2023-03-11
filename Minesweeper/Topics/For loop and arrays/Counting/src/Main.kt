fun main() {
    val array = IntArray(readln().toInt()) { readln().toInt() }
    readln().toInt().let { n -> println(array.count { n == it }) }
}