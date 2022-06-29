fun main() {    
    val numbers = readLine()!!.split(' ').map { it.toInt() }.toMutableList()
    // Do not touch lines above
    val tmp = numbers[numbers.lastIndex]
    numbers[numbers.lastIndex] = numbers[0]
    numbers[0] = tmp

    // Do not touch lines below
    println(numbers.joinToString(separator = " "))
}