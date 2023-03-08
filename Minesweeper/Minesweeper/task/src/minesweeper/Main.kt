package minesweeper

import kotlin.random.Random

fun main() {
    print("How many mines do you want on the field? ")
    val minesweeper = Minesweeper(readln().toInt())

    var mark = true
    while (true) { // Тут условие о маркировке всех мин
        if (mark) minesweeper.print()
        println("Set/delete mines marks (x and y coordinates): ")
        mark = readln().split(" ")
            .map { it.toInt() }
            .let { minesweeper.markMine(it[0], it[1]) }
    }

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

            if (mines[posX][posY] == 'X') continue

            mines[posX][posY] = 'X'
            field[posX][posY] = '.'
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

    fun markMine(x: Int, y: Int): Boolean {
        if (field[x][y] in '1'..'8')
            return false

        if (field[x][y] == '*') {
            field[x][y] = '.'
            markCount--
        } else {
            field[x][y] = '*'
            markCount++

//            if (mines[x][y] == 'X') // определиться счетчиком, либо уменьшение мин либо флажки
//                totalMines--
        }

        return true
    }

    fun

    fun print() {
        val hline = "—"
        val vline = "│"

        println("\n $vline${(1..field.size).joinToString(" ")}$vline")
        println("$hline$vline${hline.repeat(field.size * 2 - 1)}$vline")

        for (i in field.indices) {
            println("${i + 1}$vline${field[i].joinToString(" ")}$vline")
        }

        println("$hline$vline${hline.repeat(field.size * 2 - 1)}$vline")
    }
}