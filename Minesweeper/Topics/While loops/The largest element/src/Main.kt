fun main() {
    var number = -1
    var max = Int.MIN_VALUE

    while (number != 0) {
        number = readln().toInt()
        if (number != 0) {
            if (number > max) max = number
        }
    }

    println(max)
}