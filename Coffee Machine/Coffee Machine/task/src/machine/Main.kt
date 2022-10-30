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

    enum class CoffeeDrink(val money: Int, val water: Int, val coffee: Int, val milk: Int) {
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
                "fill" -> fill()
                "take" -> take()
                "remaining" -> remaining()
                "exit" -> exit = true
            }
        }
        if (state == State.CoffeeMenu) {
            when (input) {
                "1" -> {
                    if (checkMakeCoffee(CoffeeDrink.Espresso)) {
                        println("I have enough resources, making you a coffee!")
                        makeCoffee(CoffeeDrink.Espresso)
                    }
                    state = State.MainMenu
                }

                "2" -> {
                    if (checkMakeCoffee(CoffeeDrink.Latte)) {
                        println("I have enough resources, making you a coffee!")
                        makeCoffee(CoffeeDrink.Latte)
                    }
                    state = State.MainMenu
                }

                "3" -> {
                    if (checkMakeCoffee(CoffeeDrink.Cappuccino)) {
                        println("I have enough resources, making you a coffee!")
                        makeCoffee(CoffeeDrink.Cappuccino)
                    }
                    state = State.MainMenu
                }

                "back" -> state = State.MainMenu
            }
        }
        return exit
    }

    fun remaining() {
        println("\nThe coffee machine has:")
        println("$water ml of water")
        println("$milk ml of milk")
        println("$coffee g of coffee beans")
        println("$cups disposable cups")
        println("$$money of money")
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

    fun take() = println("\nI gave you $$money").let { money = 0 }

    private fun makeCoffee(drink: CoffeeDrink) {
        this.money += drink.money
        this.water -= drink.water
        this.coffee -= drink.coffee
        this.milk -= drink.milk
        cups--
    }

    private fun checkMakeCoffee(drink: CoffeeDrink): Boolean {
        var check = true
        if (water < drink.water || coffee < drink.coffee || milk < drink.milk || cups < 1) {
            print("Sorry, not enough ")
            if (water < drink.water) println("water!")
            if (milk < drink.milk) println("milk!")
            if (coffee < drink.coffee) println("coffee!")
            if (cups < 1) println("cups!")
            check = false
        }
        return check
    }
}


fun main() {
    val coffeeMachine = CoffeeMachine()
    var exit = false
    while (!exit) {
        exit = coffeeMachine.action(readln())
    }
}