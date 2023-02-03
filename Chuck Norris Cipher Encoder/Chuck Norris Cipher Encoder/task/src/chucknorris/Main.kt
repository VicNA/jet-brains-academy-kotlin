package chucknorris

const val NOT_VALID = "Encoded string is not valid.\n"
val sb = StringBuilder()

fun main() {
    var command = ""
    while (command != "exit") {
        println("Please input operation (encode/decode/exit):")
        command = readln()

        when (command) {
            "encode" -> encode()
            "decode" -> decode()
            "exit" -> println("Bye!")
            else -> println("There is no '$command' operation\n")
        }

        if (sb.isNotEmpty()) println("${sb.trim().also { sb.clear() }}\n")
    }
}

fun encode() {
    println("Input string:")
    val input = readln()

    input.forEach { sb.append(Integer.toBinaryString(it.code).padStart(7, '0')) }
    val array = sb.toString().toCharArray().also { sb.clear() }

    var count = 1
    for (i in 1..array.lastIndex) {
        if (array[i] == array[i - 1])
            count++
        else {
            sb.append(if (array[i - 1] == '0') " 00 " else " 0 ")
            sb.append("0".repeat(count))
            count = 1
        }
        if (i == array.lastIndex) {
            sb.append(if (array[i] == '0') " 00 " else " 0 ")
            sb.append("0".repeat(count))
        }
    }

    println("Encoded string:")
}

fun decode() {
    println("Input encoded string:")
    val input = readln().split(" ")

    if (input.size % 2 != 0 || input.any { !it.contains("0") })
        println(NOT_VALID).also { return }

    val encoded = input.chunked(2)

    if (encoded.any { (it[0].length > 2) })
        println(NOT_VALID).also { return }

    for (enc in encoded) {
        if (enc[0] == "0")
            sb.append("1".repeat(enc[1].length))
        else
            sb.append("0".repeat(enc[1].length))
    }

    if (sb.length % 7 != 0)
        println(NOT_VALID).also { sb.clear(); return }

    println("Decoded string:")
    sb.chunked(7)
        .also { sb.clear() }
        .map { sb.append(Char(it.toInt(2))) }
}