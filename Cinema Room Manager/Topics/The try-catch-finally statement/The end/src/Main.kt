fun solution() {
    val (a, b) = Array(2) { readln().toInt() }
    try {
        println(a / b)
    } catch (e: ArithmeticException) {
        println(e.message)
    } finally {
        println("This is the end, my friend.")
    }
}