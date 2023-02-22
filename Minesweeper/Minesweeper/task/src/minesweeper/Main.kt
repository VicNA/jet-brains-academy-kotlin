package minesweeper

import kotlin.random.Random

fun main() {
    val field = Array(9) {
        Array(9) { '.' }
    }

    print("How many mines do you want on the field? ")
    var mine = readln().toInt()
    var (row, col, x, y) = arrayOf(0, 0, 0, 0)

    while (mine > 0) {
        row = Random.nextInt(field.size)
        col = Random.nextInt(field.size)

        if (field[row][col] != 'X') {
            field[row][col] = 'X'
            mine--

            for (i in -1..1) {
                x = row + i
                if (x !in field.indices) continue

                for (j in -1..1) {
                    y = col + j
                    if (y !in field.indices) continue

                    if (field[x][y] != 'X' && field[x][y] != '.') {
                        field[x][y]++
                    } else if (field[x][y] == '.') {
                        field[x][y] = '1'
                    }
                }
            }
        }
    }

    field.forEach { println(it.joinToString("")) }
}
