package tictactoe

fun main() {
    val grid = Array(3) { Array(3) { '_' }.toMutableList() }.toMutableList()
    printGrid(grid)

    var isEnd = false
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
            else -> isEnd = setMove(grid, move, ++step)
        }
    } while (!isEnd)

}

fun setMove(grid: MutableList<MutableList<Char>>, move: MutableList<Int>, step: Int): Boolean {
    val state = if (step % 2 == 0) 'O' else 'X'
    grid[move[0]][move[1]] = state

    var win = false
    var draw = false
    // check row
    for (i in 0..grid.lastIndex) {
        if (grid[move[0]][i] != state) break
        if (i == grid.lastIndex) win = true
    }
    // check column
    if (!win) {
        for (i in 0..grid.lastIndex) {
            if (grid[i][move[1]] != state) break
            if (i == grid.lastIndex) win = true
        }
    }
    // check diag 1
    if (!win) {
        if (move[0] == move[1]) {
            for (i in 0..grid.lastIndex) {
                if (grid[i][i] != state) break
                if (i == grid.lastIndex) win = true
            }
        }
    }
    // check diag 2
    if (!win) {
        if (move[0] + move[1] == grid.lastIndex) {
            for (i in 0..grid.lastIndex) {
                if (grid[i][grid.lastIndex - i] != state) break
                if (i == grid.lastIndex) win = true
            }
        }
    }
    // check draw
    if (!win && step == grid.size * grid.size) draw = true

    printGrid(grid)

    if (win) println("$state wins")
    if (draw) println("Draw")

    return win || draw
}

fun printGrid(grid: MutableList<MutableList<Char>>) {
    val rep = grid.sumOf { it.count() }
    println("-".repeat(rep))
    grid.forEach { println("| ${it.joinToString(" ")} |") }
    println("-".repeat(rep))
}