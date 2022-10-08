fun main() {
    val firstList = readLine()!!.split(' ').map { it }.toMutableList()
    val secondList = readLine()!!.split(' ').map { it }.toMutableList()
    firstList += secondList
    println(firstList.joinToString())

}