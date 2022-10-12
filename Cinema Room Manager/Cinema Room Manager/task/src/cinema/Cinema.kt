package cinema

import java.util.*

fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()

    val allSeats = rows * seats
    val totalIncome =
        if (allSeats <= 60)
            allSeats * 10
        else
            rows / 2 * seats * 10 + (rows - rows / 2) * seats * 8
    val cinema = Array(rows) { Array(seats) { 'S' } }

    var menu: Int
    var currentIncome = 0
    var purchasedTickets = 0
    do {
        println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit")
        menu = readln().toInt()
        if (menu == 1) printCinema(cinema)
        if (menu == 2) {
            currentIncome += buyTicket(cinema, rows, seats)
            purchasedTickets++
        }
        if (menu == 3) printStatistics(allSeats, totalIncome, currentIncome, purchasedTickets)
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

fun buyTicket(cinema: Array<Array<Char>>, rows: Int, seats: Int): Int {
    var row: Int
    var seat: Int
    do {
        println("\nEnter a row number:")
        row = readln().toInt()
        println("Enter a seat number in that row:")
        seat = readln().toInt()
        if (row in 1..rows && seat in 1..seats) {
            if (cinema[row - 1][seat - 1] != 'B')
                break
            else
                println("\nThat ticket has already been purchased!")
        } else
            println("\nWrong input!")
    } while (true)

    val price =
        if (rows * seats <= 60)
            10
        else
            if (row <= rows / 2) 10 else 8

    cinema[row - 1][seat - 1] = 'B'
    println("Ticket price: $$price")
    return price
}

fun printStatistics(allSeats: Int, totalIncome: Int, currentIncome: Int, purchasedTickets: Int) {
    println("Number of purchased tickets: $purchasedTickets")
    println("Percentage: ${"%.2f".format(Locale.US, purchasedTickets.toDouble() / allSeats * 100)}%")
    println("Current income: $$currentIncome")
    println("Total income: $$totalIncome")
}