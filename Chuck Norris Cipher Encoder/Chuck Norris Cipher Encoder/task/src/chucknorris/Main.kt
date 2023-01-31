package chucknorris

fun main() {
    println("Input string:")
    val input = readln()

    val sb = StringBuilder()
    input.forEach { sb.append(Integer.toBinaryString(it.code).padStart(7, '0')) }
    val array = sb.toString().toCharArray()
    sb.clear()

    var count = 1
    for (i in array.indices) {
        if (i > 0) {
            if (array[i] == array[i - 1]) {
                count++
            } else {
                if (array[i - 1] == '0') sb.append( " 00 ") else sb.append(" 0 ")
                sb.append("0".repeat(count))
                count = 1
            }
        }
        if (i == array.size - 1) {
            if (array[i] == '0') sb.append( " 00 ") else sb.append(" 0 ")
            sb.append("0".repeat(count))
        }
    }
    println("\nThe result:\n${sb.trim()}")
}