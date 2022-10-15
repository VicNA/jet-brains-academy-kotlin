package tictactoe

fun main() {
    val str = readln()
    val grid = mutableListOf<MutableList<Char>>()
    for (s in str.chunked(3)) {
        val list = mutableListOf<Char>()
        s.forEach { list += it }
        grid += list
    }
    printGrid(grid)

    do {
        val move = mutableListOf<Int>()
        try {
            readln().split(" ").map { move += it.toInt() - 1 }
        } catch (e: NumberFormatException) {
            println("You should enter numbers!")
            continue
        }
        when {
            move[0] !in 0..2 || move[1] !in 0..2 -> println("Coordinates should be from 1 to 3!")
            grid[move[0]][move[1]] != '_' -> println("This cell is occupied! Choose another one!")
            else -> {
                grid[move[0]][move[1]] = 'X'
                break
            }
        }
    } while (true)

    printGrid(grid)
}

fun printGrid(grid: MutableList<MutableList<Char>>) {
    val rep = grid.sumOf { it.count() }
    println("-".repeat(rep))
    grid.forEach { println("| ${it.joinToString(" ")} |") }
    println("-".repeat(rep))
}