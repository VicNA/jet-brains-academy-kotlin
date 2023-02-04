fun main() {
    val array = IntArray(readln().toInt()) { readln().toInt() }
    val (p, m) = readln().split(" ").map { it.toInt() }

    var result = "YES"
    for (i in 0 until array.lastIndex) {
        if (array[i] == p && array[i + 1] == m ||
            array[i] == m && array[i + 1] == p
        ) {
            result = "NO"
            break
        }
    }

    println(result)
}