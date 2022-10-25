package machine

var water = 400
var milk = 540
var coffee = 120
var cups = 9
var money = 550

fun main() {

    remaining()

    while (true) {
        println("Write action (buy, fill, take, remaining, exit):")
        when (readln()) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> remaining()
            "exit" -> break
        }
    }
}

fun remaining() {
    println("\nThe coffee machine has:")
    println("$water ml of water")
    println("$milk ml of milk")
    println("$coffee g of coffee beans")
    println("$cups disposable cups")
    println("$$money of money")
}

fun buy() {
    println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    when (readln()) {
        "1" -> {
            if (water > 250) water -= 250
            coffee -= 16
            money += 4
        }

        "2" -> {
            water -= 350
            milk -= 75
            coffee -= 20
            money += 7
        }

        "3" -> {
            water -= 200
            milk -= 100
            coffee -= 12
            money += 6
        }
        "back" -> return
    }
    cups--
}

fun checkingResources(idx: Int): String {
    return TODO("перегрузка методов")
}

fun fill() {
    println("\nWrite how many ml of water you want to add:")
    water += readln().toInt()

    println("Write how many ml of milk you want to add:")
    milk += readln().toInt()

    println("Write how many grams of coffee beans you want to add:")
    coffee += readln().toInt()

    println("Write how many disposable cups you want to add:")
    cups += readln().toInt()
}

fun take() {
    println("\nI gave you $$money")
    money = 0
}
