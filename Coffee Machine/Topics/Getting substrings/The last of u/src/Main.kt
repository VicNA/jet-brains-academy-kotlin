fun main() {
    val string = readln()
    print(string.substringBeforeLast('u').plus('u'))
    println(string.substringAfterLast('u').uppercase())
}