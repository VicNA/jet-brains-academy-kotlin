fun main() {
    val ch = readln().first()

    println(ch.isDigit() && ch != '0' || ch.isUpperCase())
}