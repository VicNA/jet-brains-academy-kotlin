fun main() {
    val n = readln().toInt()
    val array = Array(n) { readln().toInt() }
    var num = array.last()
    var count = 1
    var max = 1
    for (i in array.size - 2 downTo 0) {
        if (array[i] <= num) {
            count++
            if (count > max) max = count
        } else {
            count = 1
        }

        num = array[i]
    }

    println(max)
}