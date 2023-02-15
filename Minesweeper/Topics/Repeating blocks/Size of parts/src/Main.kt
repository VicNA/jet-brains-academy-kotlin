fun main() {
    val numbers = IntArray(3) { 0 }
    repeat(readln().toInt()) {
        val size = readln().toInt()
        numbers[size + 1]++
    }
    println("${numbers[1]} ${numbers[2]} ${numbers[0]}")
}