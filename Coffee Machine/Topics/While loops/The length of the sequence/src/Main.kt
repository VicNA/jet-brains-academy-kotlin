import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    var count = 0
    var wasZero = false
    var input: String
    while (sc.hasNext()) {
        input = sc.nextLine()
        if (input.toInt() == 0) wasZero = true
        if (!wasZero) count++
    }
    println(count)
}
