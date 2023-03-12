package minesweeper

import kotlin.random.Random

fun main() {
    print("How many mines do you want on the field? ")
    val minesweeper = Minesweeper(readln().toInt())

    var mark = true
    while (!minesweeper.allMinesMarked()) {
        if (mark)
            minesweeper.print()
        else
            println("There is a number here!")

        print("Set/delete mines marks (x and y coordinates): ")
        mark = readln().split(" ")
            .map { it.toInt() - 1 }
            .let { minesweeper.markMine(it[0], it[1]) }
    }

    minesweeper.print()
    println("Congratulations! You found all the mines!")
}

class Minesweeper(private val totalMines: Int) {

    private val HLINE = "—"
    private val VLINE = "│"

    private var markMines = 0
    private var markCount = 0

    private val minefield = Array(9) { Array(9) { '.' } }
    private val playfield = Array(9) { Array(9) { '.' } }
    private var cell = minefield.size * minefield.size

    fun init() {
        var mine = totalMines
        var posX: Int
        var posY: Int
        var x: Int
        var y: Int

        while (mine > 0) {
            posX = Random.nextInt(minefield.size)
            posY = Random.nextInt(minefield.size)

            if (minefield[posY][posX] == 'X') continue

            minefield[posY][posX] = 'X'
            mine--

            for (i in -1..1) {
                y = posY + i

                if (y !in minefield.indices) continue

                for (j in -1..1) {
                    x = posX + j

                    if (x !in minefield.indices || minefield[y][x] == 'X') continue

                    if (minefield[y][x] == '.')
                        minefield[y][x] = '1'
                    else
                        minefield[y][x]++
                }
            }
        }
    }

    fun markMine(x: Int, y: Int): Boolean {
        if (minefield[y][x] in '1'..'8')
            return false

        if (minefield[y][x] == '*') {
            if (minefield[y][x] == 'X') markMines--
            minefield[y][x] = '.'
            markCount--
        } else {
            if (minefield[y][x] == 'X') markMines++
            minefield[y][x] = '*'
            markCount++
        }

        return true
    }

    fun allMinesMarked() = markMines == totalMines || cell == totalMines

    fun print() {
        println("\n $VLINE${(1..playfield.size).joinToString("")}$VLINE")
        println("$HLINE$VLINE${HLINE.repeat(playfield.size)}$VLINE")

        for (i in playfield.indices) {
            println("${i + 1}$VLINE${playfield[i].joinToString("")}$VLINE")
        }

        println("$HLINE$VLINE${HLINE.repeat(playfield.size)}$VLINE")
    }
}