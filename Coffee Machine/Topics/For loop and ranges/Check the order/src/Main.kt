fun main() {
    val n = readln().toInt()
    val array = Array(n) { readln().toInt() }
    var num = Int.MIN_VALUE
    var bool = true
    array.forEach { bool = bool && it > num; num = it }
    if (bool) println("YES") else println("NO")
}