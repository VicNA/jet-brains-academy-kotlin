package machine

var water = 400
var milk = 540
var coffee = 120
var cups = 9
var money = 550

fun main() {
    while (true) {
        println("\nWrite action (buy, fill, take, remaining, exit):")
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
            if (water < 250 || coffee < 16 || cups < 1) {
                print("Sorry, not enough ")
                if (water < 250) println("water!")
                if (coffee < 16) println("coffee!")
                if (cups < 1) println("cups!")
            } else {
                println("I have enough resources, making you a coffee!")
                water -= 250
                coffee -= 16
                cups--
                money += 4
            }
        }
        "2" -> {
            if (water < 350 || milk < 75 || coffee < 20 || cups < 1) {
                print("Sorry, not enough ")
                if (water < 350) println("water!")
                if (milk < 75) println("milk!")
                if (coffee < 20) println("coffee!")
                if (cups < 1) println("cups!")
            } else {
                println("I have enough resources, making you a coffee!")
                water -= 350
                milk -= 75
                coffee -= 20
                cups--
                money += 7
            }
        }
        "3" -> {
            if (water < 200 || milk < 100 || coffee < 12 || cups < 1) {
                print("Sorry, not enough ")
                if (water < 200) println("water!")
                if (milk < 100) println("milk!")
                if (coffee < 12) println("coffee!")
                if (cups < 1) println("cups!")
            } else {
                println("I have enough resources, making you a coffee!")
                water -= 200
                milk -= 100
                coffee -= 12
                cups--
                money += 6
            }
        }
        "back" -> return
    }

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
