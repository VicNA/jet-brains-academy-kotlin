package machine

fun main() {
    val coffeeMachine = mutableMapOf(
        "water" to 400,
        "milk" to 540,
        "coffee" to 120,
        "cups" to 9,
        "money" to 550
    )

    printCoffeeMachine(coffeeMachine)

    println("\nWrite action (buy, fill, take):")
    when (readln()) {
        "buy" -> buy(coffeeMachine)
        "fill" -> fill(coffeeMachine)
        "take" -> TODO()
    }

    printCoffeeMachine(coffeeMachine, 1)
}

fun printCoffeeMachine(cm: MutableMap<String, Int>, newLine: Int = 0) {
    repeat(newLine) { print("\n") }
    println("The coffee machine has:")
    println("${cm["water"]} ml of water")
    println("${cm["milk"]} ml of milk")
    println("${cm["coffee"]} g of coffee beans")
    println("${cm["cups"]} disposable cups")
    println("$${cm["money"]} of money")
}

fun buy(cm: MutableMap<String, Int>) {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    when (readln()) {
        "1" -> TODO()
        "2" -> TODO()
        "3" -> TODO()
    }
}

fun fill(cm: MutableMap<String, Int>) {
    println("Write how many ml of water you want to add:")
    cm["water"] = cm.getValue("water") + readln().toInt()

    println("Write how many ml of milk you want to add:")
    cm["milk"] = cm.getValue("milk") + readln().toInt()

    println("Write how many grams of coffee beans you want to add:")
    cm["coffee"] = cm.getValue("coffee") + readln().toInt()

    println("Write how many disposable cups you want to add:")
    cm["cups"] = cm.getValue("cups") + readln().toInt()
}

fun take(cm: MutableMap<String, Int>) {

}
