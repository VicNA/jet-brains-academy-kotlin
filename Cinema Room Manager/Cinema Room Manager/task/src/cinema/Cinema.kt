package cinema

fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()

    val allSeats = rows * seats

    val cinema = MutableList(rows) { MutableList(seats) { "S" } }
    printCinema(cinema)

    println("Enter a row number:")
    val row = readln().toInt()
    println("Enter a seat number in that row:")
    val seat = readln().toInt()

    val price =
        if (allSeats <= 60)
            10
        else
            if (row <= rows / 2) 10 else 8

    println("\nTicket price: $$price")

    cinema[row - 1][seat - 1] = "B"
    printCinema(cinema)
}

fun printCinema(cinema: List<List<Any>>) {
    print("\nCinema:\n  ")
    repeat(cinema[0].size) { print("${it + 1} ") }
    println()

    for (i in cinema.indices) {
        print("${i + 1} ")
        for (j in cinema[i]) {
            print("$j ")
        }
        println()
    }
    println()
}