fun main() {
    val str = readln().toCharArray()
    val tmp = str[0]
    str[0] = str[str.lastIndex]
    str[str.lastIndex] = tmp
    println(str.joinToString(""))
}