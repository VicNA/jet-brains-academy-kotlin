fun main() {
    val (num1, oper, num2) = readln().split(" ")
    val func = { a: String, b: String, f: (Long, Long) -> Long -> f(a.toLong(), b.toLong()) }

    println(
        when (oper) {
            "+" -> func(num1, num2) { a, b -> a + b }
            "-" -> func(num1, num2) { a, b -> a - b }
            "/" -> if (num2 == "0") "Division by 0!" else func(num1, num2) { a, b -> a / b }
            "*" -> func(num1, num2) { a, b -> a * b }
            else -> "Unknown operator"
        }
    )
}