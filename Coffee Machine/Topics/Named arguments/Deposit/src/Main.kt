import kotlin.math.pow

fun main() {
    val param = readln()
    val value = readln().toInt()

    println(
        when (param) {
            "amount" -> finalAmount(amount = value)
            "percent" -> finalAmount(percent = value)
            "years" -> finalAmount(years = value)
            else -> finalAmount()
        }
    )
}

fun finalAmount(amount: Int = 1000, percent: Int = 5, years: Int = 10) = (amount * (1 + percent / 100.0).pow(years)).toInt()