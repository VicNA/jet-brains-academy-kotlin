package minesweeper

import kotlin.random.Random

fun main() {
    print("How many mines do you want on the field? ")
    val minesweeper = Minesweeper(readln().toInt())

    var input: String
    while (true) { // Тут условие о маркировке всех мин
        minesweeper.print()
        println("Set/delete mines marks (x and y coordinates): ")
        input = readln()
    }
}

class Minesweeper(totalMines: Int) {
    private val field = Array(9) { Array(9) { '.' } }
    private val minefield = Minefield(totalMines)

    inner class Minefield(val totalMines: Int) {
        val mines = Array(9) { Array(9) { '.' } }

        init {
            var mine = totalMines
            var posX: Int
            var posY: Int
            var x: Int
            var y: Int

            while (mine > 0) {
                posX = Random.nextInt(field.size)
                posY = Random.nextInt(field.size)

                if (mines[posX][posY] == 'X') continue

                mines[posX][posY] = 'X'
                mine--

                for (i in -1..1) {
                    x = posX + i

                    if (x !in field.indices) continue

                    for (j in -1..1) {
                        y = posY + j

                        if (y !in field.indices || mines[x][y] == 'X') continue

                        if (field[x][y] == '.')
                            field[x][y] = '1'
                        else
                            field[x][y]++
                    }
                }
            }
        }
    }

    fun print() {
        val hline = "—"
        val vline = "│"

        println(" $vline${(1..field.size).joinToString("")}$vline")
        println("$hline$vline${hline.repeat(field.size)}$vline")

        for (i in field.indices) {
            println("${i + 1}$vline${field[i].joinToString("")}$vline")
        }

        println("$hline$vline${hline.repeat(field.size)}$vline")
    }
}