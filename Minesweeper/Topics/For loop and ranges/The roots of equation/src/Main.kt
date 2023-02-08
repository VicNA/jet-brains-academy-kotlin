import kotlin.math.pow

fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()
    val d = readln().toInt()

    var result: Double
    for (x in 0..1000) {
        result = a * x.toDouble().pow(3) + b * x.toDouble().pow(2) + c * x + d
        if (result == 0.0) println(x)
    }
}