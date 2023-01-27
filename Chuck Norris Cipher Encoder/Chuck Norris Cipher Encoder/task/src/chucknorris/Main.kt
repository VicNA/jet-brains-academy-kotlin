package chucknorris

fun main() = println("Input string:").let { readln().forEach { print("$it ") } }