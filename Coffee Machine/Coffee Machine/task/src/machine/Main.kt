package machine

fun main() {
    println("Write how many cups of coffee you will need:")
    val water = 200
    val milk = 50
    val coffe = 15

    val cups = readln().toInt()

    println("For $cups cups of coffee you will need:")
    println("${cups * water} ml of water")
    println("${cups * milk} ml of milk")
    println("${cups * coffe} g of coffee beans")
}
