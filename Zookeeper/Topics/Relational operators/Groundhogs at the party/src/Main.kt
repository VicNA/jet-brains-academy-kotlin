fun main() {
    val count = readln().toInt()
    val weekend = readln().toBoolean()

    println((count >= 10 && count <= 20 && !weekend) || (count >= 15 && count <= 25 && weekend))
}