package tictactoe

fun main() {
    val str = readln()
    val countX = str.count { it == 'X' }
    val countO = str.count { it == 'O' }
    val countEmpty = str.count { it == '_' }

    val sb = StringBuilder()
    var result = ""
    var countWin = 0

    if (countX - countO !in -1..1) {
        result = "Impossible"
    } else {
        repeat(3) {
            sb.append(str[it * 3]).append(str[it * 3 + 1]).append(str[it * 3 + 2])
            sb.append(str[it]).append(str[it + 3]).append(str[it + 6])
            if (it == 0) {
                sb.append(str[it]).append(str[it + 4]).append(str[it + 8])
            }
            if (it == 2) {
                sb.append(str[it]).append(str[it + 2]).append(str[it + 4])
            }
        }
        for (s in sb.chunked(3)) {
            if (s == "XXX") {
                result = "X wins"
                countWin++
            }
            if (s == "OOO") {
                result = "O wins"
                countWin++
            }
        }
        if (countWin > 1) result = "Impossible"
        if (countWin == 0 && countEmpty > 0) result = "Game not finished"
        if (countWin == 0 && countEmpty == 0) result = "Draw"
    }


    println("-".repeat(str.length))
    for (s in str.chunked(3)) {
        println("|${s.split("").joinToString(" ")}|")
    }
    println("-".repeat(str.length))

    println(result)
}