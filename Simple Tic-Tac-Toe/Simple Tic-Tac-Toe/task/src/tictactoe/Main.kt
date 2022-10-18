package tictactoe

fun main() {
    val grid = Array(3) { Array(3) { '_' }.toMutableList() }.toMutableList()
    printGrid(grid)

    var end = false
    var step = 0
    do {
        val move = mutableListOf<Int>()
        try {
            readln().split(' ').map { move += it.toInt() - 1 }
        } catch (e: NumberFormatException) {
            println("You should enter numbers!")
            continue
        }
        when {
            move[0] !in 0..2 || move[1] !in 0..2 -> println("Coordinates should be from 1 to 3!")
            grid[move[0]][move[1]] != '_' -> println("This cell is occupied! Choose another one!")
            else -> {
                step++
                grid[move[0]][move[1]] = if (step % 2 == 0) 'O' else 'X'
                if (step >= 5) {

                }
            }
        }
    } while (!end)

    printGrid(grid)
}

fun countingTheGame(grid: MutableList<MutableList<Char>>, state: Char): Boolean {
    var counter = 0
    for (i in 0..grid.lastIndex) {
        for (j in 0..grid[0].lastIndex) {
            if (grid[i][j] == state) counter++
        }
        if (counter == grid.size) {
            break
        } else counter = 0

    }
    return game
}

fun printGrid(grid: MutableList<MutableList<Char>>) {
    val rep = grid.sumOf { it.count() }
    println("-".repeat(rep))
    grid.forEach { println("| ${it.joinToString(" ")} |") }
    println("-".repeat(rep))
}