class City(val name: String) {
    var degrees: Int = when (name) {
        "Dubai" -> 30
        "Moscow" -> 5
        "Hanoi" -> 20
        else -> 0
    }
        set(value) {
            field = if (value !in -92..57) degrees else value
        }
}        

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    val list = listOf(firstCity, secondCity, thirdCity)
    val min = list.minOf { it.degrees }
    val filterList = list.filter { it.degrees == min }
    print(if (filterList.count() > 1) "neither" else filterList.first().name)
}