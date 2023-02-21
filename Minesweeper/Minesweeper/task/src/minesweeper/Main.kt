package minesweeper

import kotlin.random.Random

fun main() {
    val field = Array(9) {
        Array(9) { '.' }
    }

    print("How many mines do you want on the field? ")
    var mine = readln().toInt()
    var (row, col, x, y) = arrayOf(0, 0, 0, 0)
//    var x = 0
//    var y = 0

    while (mine > 0) {
        row = Random.nextInt(field.size)
        col = Random.nextInt(field.size)

        if (field[row][col] != 'X') {
            field[row][col] = 'X'
            mine--

            for (i in -1..1) {
                x = (row + i).let { if (it < 0 || it > field.lastIndex) row else it } // значения выпадающие за границу, пропускать
                for (j in -1..1) {
                    y = (col + j).let { if (it < 0 || it > field.lastIndex) col else it } // значения выпадающие за границу, пропускать

                    if (field[x][y] != 'X' && field[x][y] != '.') {
                        field[x][y]++
                    } else if (field[x][y] == '.') {
                        field[x][y] = '1'
                    }
                }
            }
        }
    }

    field.forEach { println(it.joinToString(" ")) }
}
