package machine

class CoffeeMachine {
    var _water = 400
    var _milk = 540
    var _coffee = 120
    var cups = 9
    var money = 550
//    var action = 1

    fun action(input: String): Boolean {
        var exit = false
        when (input) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> remaining()
            "exit" -> exit = true
        }
        return exit
    }

    fun remaining() {
        println("\nThe coffee machine has:")
        println("$_water ml of water")
        println("$_milk ml of milk")
        println("$_coffee g of coffee beans")
        println("$cups disposable cups")
        println("$$money of money")
    }

    fun fill() {
        println("\nWrite how many ml of water you want to add:")
        _water += readln().toInt()

        println("Write how many ml of milk you want to add:")
        _milk += readln().toInt()

        println("Write how many grams of coffee beans you want to add:")
        _coffee += readln().toInt()

        println("Write how many disposable cups you want to add:")
        cups += readln().toInt()
    }

    fun take() {
        println("\nI gave you $$money")
        money = 0
    }

    fun buy() {
        println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
        when (readln()) {
            "1" -> {
                if (_water < 250 || _coffee < 16 || cups < 1) {
                    print("Sorry, not enough ")
                    if (_water < 250) println("water!")
                    if (_coffee < 16) println("coffee!")
                    if (cups < 1) println("cups!")
                } else {
                    println("I have enough resources, making you a coffee!")
                    makeCoffee(250, 16)
                    money += 4
                }
            }

            "2" -> {
                if (_water < 350 || _milk < 75 || _coffee < 20 || cups < 1) {
                    print("Sorry, not enough ")
                    if (_water < 350) println("water!")
                    if (_milk < 75) println("milk!")
                    if (_coffee < 20) println("coffee!")
                    if (cups < 1) println("cups!")
                } else {
                    println("I have enough resources, making you a coffee!")
                    makeCoffee(350, 20, 75)
                    money += 7
                }
            }

            "3" -> {
                if (_water < 200 || _milk < 100 || _coffee < 12 || cups < 1) {
                    print("Sorry, not enough ")
                    if (_water < 200) println("water!")
                    if (_milk < 100) println("milk!")
                    if (_coffee < 12) println("coffee!")
                    if (cups < 1) println("cups!")
                } else {
                    println("I have enough resources, making you a coffee!")
                    makeCoffee(200, 12, 100)
                    money += 6
                }
            }

            "back" -> return
        }
    }

    private fun makeCoffee(water: Int, coffee: Int, milk: Int = 0) {
        _water -= water
        _coffee -= coffee
        _milk -= milk
        cups--
    }
}


fun main() {
    val coffeeMachine = CoffeeMachine()
    var exit = false
    while (!exit) {
        println("\nWrite action (buy, fill, take, remaining, exit):")
        exit = coffeeMachine.action(readln())
    }
}