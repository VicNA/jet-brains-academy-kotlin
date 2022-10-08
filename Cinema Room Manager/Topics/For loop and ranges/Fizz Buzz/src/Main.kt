fun main() {
    for (i in readln().toInt()..readln().toInt()) {
        when {
            i.mod(3) == 0 && i.mod(5) == 0 -> println("FizzBuzz")
            i.mod(3) == 0 -> println("Fizz")
            i.mod(5) == 0 -> println("Buzz")
            else -> println(i)
        }
    }
}