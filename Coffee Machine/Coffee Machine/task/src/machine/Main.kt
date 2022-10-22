package machine

fun main() {
    val useWater = 200
    val useMilk = 50
    val useCoffee = 15

    println("Write how many ml of water the coffee machine has:")
    val water = readln().toInt()
    var canMakeCups = water / useWater

    println("Write how many ml of milk the coffee machine has:")
    val milk = readln().toInt()
    canMakeCups = (milk / useMilk).coerceAtMost(canMakeCups)

    println("Write how many grams of coffee beans the coffee machine has:")
    val coffee = readln().toInt()
    canMakeCups = (coffee / useCoffee).coerceAtMost(canMakeCups)

    println("Write how many cups of coffee you will need:")
    val cups = readln().toInt()

    if (cups * useWater <= water && cups * useMilk <= milk && cups * useCoffee <= coffee) {
        if(canMakeCups > cups)
            println("Yes, I can make that amount of coffee (and even ${canMakeCups - cups} more than that)")
        else
            println("Yes, I can make that amount of coffee")
    } else {
        println("No, I can make only $canMakeCups cups of coffee")
    }
}
