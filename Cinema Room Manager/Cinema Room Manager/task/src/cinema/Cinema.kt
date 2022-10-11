package cinema

fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()

    val cinema = Array(rows) { Array(seats) { 'S' } }

    var menu: Int
    do {
        println("\n1. Show the seats\n2. Buy a ticket\n0. Exit")
        menu = readln().toInt()
        if (menu == 1) printCinema(cinema)
        if (menu == 2) buyTicket(cinema, rows, seats)
    } while (menu != 0)
}

fun printCinema(cinema: Array<Array<Char>>) {
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
}

fun buyTicket(cinema: Array<Array<Char>>, rows: Int, seats: Int) {
    println("\nEnter a row number:")
    val row = readln().toInt()
    println("Enter a seat number in that row:")
    val seat = readln().toInt()

    val price =
        if (rows * seats <= 60)
            10
        else
            if (row <= rows / 2) 10 else 8

    println("Ticket price: $$price")

    cinema[row - 1][seat - 1] = 'B'
}