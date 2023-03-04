fun main() {
    val (days, food, flight, hotel) = IntArray(4) { readln().toInt() }
    println(days * food + flight * 2 + hotel * (days - 1))
}