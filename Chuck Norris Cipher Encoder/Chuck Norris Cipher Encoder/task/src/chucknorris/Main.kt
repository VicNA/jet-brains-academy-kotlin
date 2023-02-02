package chucknorris

fun main() {
    println("Input string:")
    val input = readln()
    val encoded = input.split(" ").chunked(2)

    val sb = StringBuilder()
    for (enc in encoded) {
        if (enc.size > 1) {
            if (enc[0] == "0")
                sb.append("1".repeat(enc[1].length))
            else
                sb.append("0".repeat(enc[1].length))
        }
    }

    println("\nThe result:")
    for (str in sb.chunked(7)) {
        print(Char(str.toInt(2)))
    }
}