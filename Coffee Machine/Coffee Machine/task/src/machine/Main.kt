package machine

class CoffeeMachine {
    var water = 400
    var milk = 540
    var coffee = 120
    var cups = 9
    var money = 550
    var state = State.MainMenu

    init {
        println("\nWrite action (buy, fill, take, remaining, exit):")
    }

    enum class State {
        MainMenu, CoffeeMenu
    }

    enum class Drink(val money: Int, val water: Int, val coffee: Int, val milk: Int) {
        Espresso(4, 250, 16, 0),
        Latte(7, 350, 20, 75),
        Cappuccino(6, 200, 12, 100)
    }

    fun action(input: String): Boolean {
        var exit = false
        if (state == State.MainMenu) {
            when (input) {
                "buy" -> {
                    state = State.CoffeeMenu
                    println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
                }

                "fill" -> fill() //TODO
                "take" -> take()
                "remaining" -> remaining()
                "exit" -> exit = true
            }
        }
        if (state == State.CoffeeMenu) {
            when (input) {
                "1" -> executeCoffeeMenu(Drink.Espresso)
                "2" -> executeCoffeeMenu(Drink.Latte)
                "3" -> executeCoffeeMenu(Drink.Cappuccino)
                "back" -> state = State.MainMenu
            }
        }
        return exit
    }

    private fun executeCoffeeMenu(drink: Drink) {
        if (checkResource(drink)) {
            println("I have enough resources, making you a coffee!")
            makeCoffee(drink)
        } else {
            printNotResource(drink)
        }
        state = State.MainMenu
    }

    fun remaining() {
        println("\nThe coffee machine has:")
        println("$water ml of water")
        println("$milk ml of milk")
        println("$coffee g of coffee beans")
        println("$cups disposable cups")
        println("$$money of money")
        state = State.MainMenu
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
        state = State.MainMenu
    }

    private fun makeCoffee(drink: Drink) {
        this.money += drink.money
        this.water -= drink.water
        this.coffee -= drink.coffee
        this.milk -= drink.milk
        cups--
    }

    private fun checkResource(drink: Drink) =
        water < drink.water || coffee < drink.coffee || milk < drink.milk || cups < 1

    private fun printNotResource(drink: Drink) {
        print("Sorry, not enough ")
        if (water < drink.water) println("water!")
        if (milk < drink.milk) println("milk!")
        if (coffee < drink.coffee) println("coffee!")
        if (cups < 1) println("cups!")
    }
}


fun main() {
    val coffeeMachine = CoffeeMachine()
    var exit = false
    while (!exit) {
        exit = coffeeMachine.action(readln())
    }
}