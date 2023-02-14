package minesweeper

fun main() {
    print("How many mines do you want on the field? ")
    var mine = readln().toInt()
    val field = ("X".repeat(mine) + "0".repeat(9 * 9 - mine)).toList().shuffled()
        .chunked(9).map { it.toTypedArray() }

    for (i in 0..field.lastIndex) {
        for (j in 0..field[i].lastIndex) {
            if (field[i][j] == 'X') {
                if (i + 1 < field.lastIndex &&  j + 1 < field[i].lastIndex && field[i+ 1][j + 1] != 'X') field[i + 1][j + 1]++
                if (j + 1 < field[i].lastIndex && field[i][j + 1] != 'X') field[i][j + 1]++
                if (i + 1 < field.lastIndex && field[i + 1][j] != 'X') field[i + 1][j]++
            }
        }
    }

    field.forEach { println(it.joinToString("")) }
}
