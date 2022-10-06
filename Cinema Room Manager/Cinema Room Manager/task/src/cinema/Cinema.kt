package cinema

fun main() {
    val rows = 0..7
    val seats = 1..8

    println("Cinema:")
    for (i in rows) {
        if (i == 0) {
            print("  ")
        } else {
            print("$i ")
        }
        for (j in seats) {
            if (i == 0) {
                print("$j ")
            } else {
                print("S ")
            }
        }
        println()
    }
}