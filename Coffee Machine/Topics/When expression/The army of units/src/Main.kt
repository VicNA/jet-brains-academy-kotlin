fun main() {
    val units = readln().toInt()
    println(
        when {
            units < 1 -> "no army"
            units in 1..4 -> "few"
            units in 5..9 -> "several"
            units in 10..19 -> "pack"
            units in 20..49 -> "lots"
            units in 50..99 -> "horde"
            units in 100..249 -> "throng"
            units in 250..499 -> "swarm"
            units in 500..999 -> "zounds"
            else -> "legion"
        }
    )
}