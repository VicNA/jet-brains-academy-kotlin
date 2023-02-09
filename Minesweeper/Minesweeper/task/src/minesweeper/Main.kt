package minesweeper

import kotlin.random.Random

fun main() {
    val field = Array(9) {
        Array(9) { '.' }
    }

    print("How many mines do you want on the field? ")
    var mine = readln().toInt()
    var x = 0
    var y = 0

    while (mine > 0) {
        x = Random.nextInt(field.size)
        y = Random.nextInt(field.size)

        if (field[x][y] != 'X') {
            field[x][y] = 'X'
            mine--
        }
    }

    field.forEach { println(it.joinToString("")) }
}
