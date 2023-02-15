fun main() {
    val n = readln().toInt()
    val grades = IntArray(4)

    var grade: Int
    repeat(n) {
        grade = readln().toInt()
        grades[grade - 2]++
    }

    println(grades.joinToString(" "))
}