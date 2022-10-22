import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    when (readln()) {
        "triangle" -> {
            val (a, b, c) = Array(3) { readln().toDouble() }
            val p = (a + b + c) / 2
            println(sqrt(p * (p - a) * (p - b) * (p - c)))
        }

        "rectangle" -> {
            val (a, b) = Array(2) { readln().toDouble() }
            println(a * b)
        }

        "circle" -> {
            val pi = 3.14
            val r = readln().toDouble()
            println(pi * r.pow(2))
        }
    }
}