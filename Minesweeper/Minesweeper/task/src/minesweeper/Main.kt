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

    private var markMines = 0
    private var markCount = 0

    private val field = Array(9) { Array(9) { '.' } }
    private val mines = Array(9) { Array(9) { '.' } }

    init {
        var mine = totalMines
        var posX: Int
        var posY: Int
        var x: Int
        var y: Int

        while (mine > 0) {
            posX = Random.nextInt(field.size)
            posY = Random.nextInt(field.size)

            if (mines[posY][posX] == 'X') continue

            mines[posY][posX] = 'X'
            field[posY][posX] = '.'
            mine--

            for (i in -1..1) {
                y = posY + i

                if (y !in field.indices) continue

                for (j in -1..1) {
                    x = posX + j

                    if (x !in field.indices || mines[y][x] == 'X') continue

                    if (field[y][x] == '.')
                        field[y][x] = '1'
                    else
                        field[y][x]++
                }
            }
        }
    }

    fun markMine(x: Int, y: Int): Boolean {
        if (field[y][x] in '1'..'8')
            return false

        if (field[y][x] == '*') {
            if (mines[y][x] == 'X') markMines--
            field[y][x] = '.'
            markCount--
        } else {
            if (mines[y][x] == 'X') markMines++
            field[y][x] = '*'
            markCount++
        }

        return true
    }

    fun allMinesMarked() = markMines == totalMines && markMines == markCount

    fun print() {
        val hline = "—"
        val vline = "│"

        println("\n $vline${(1..field.size).joinToString("")}$vline")
        println("$hline$vline${hline.repeat(field.size)}$vline")

        for (i in field.indices) {
            println("${i + 1}$vline${field[i].joinToString("")}$vline")
        }

        println("$hline$vline${hline.repeat(field.size)}$vline")
    }
}