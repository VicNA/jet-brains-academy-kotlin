fun main() = println((readln().toLong() until readln().toLong())
    .reduce { acc, el -> acc * el })