fun main() {
    val num = readln().toInt()
    when {
        num < 0 -> println("negative")
        num > 0 -> println("positive")
        else -> println("zero")
    }
}