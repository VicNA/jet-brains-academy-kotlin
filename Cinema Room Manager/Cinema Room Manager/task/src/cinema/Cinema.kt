package cinema

fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()

    val allSeats = rows * seats
    val income =
            if (allSeats <= 60)
                allSeats * 10
            else
                (rows / 2 * seats * 10) + (rows - rows / 2) * seats * 8
    println("Total income:\n$$income")
}